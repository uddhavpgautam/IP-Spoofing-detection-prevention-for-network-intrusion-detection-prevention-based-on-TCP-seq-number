package ipspoofingServerSide;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;

public class pcapInterfaceCapture extends Thread {

    private String pcafMac;
    private static byte[] macPcaf;
    private static StringBuilder sb;
    private static PcapIf selectedDevice;
    private static PcapPacketHandler<String> jpacketHandler;
    private static final DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private static Date datte;
    private static Integer pacLen;
    private static Integer pacWirelen;
    private final String macParameter;

    private String sourceHost;
    private String dstHost;
    private Long seqNum;
    private int tcpPortSrc;
    private int tcpPortDst;
    private Tcp tcp;
    private Ip4 ip;
    public static boolean threadCheckBool;
    private PrintWriter out;

    pcapInterfaceCapture(String macParameter, boolean threadCheckBool) {
        this.macParameter = macParameter;
        pcapInterfaceCapture.threadCheckBool = threadCheckBool;
        try {
            this.out = new PrintWriter("captureFileServer.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pcapInterfaceCapture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (threadCheckBool) {
            List<PcapIf> alldevs;
            StringBuilder errbuf;
            alldevs = new ArrayList<>(); // Will be filled with NICs    
            errbuf = new StringBuilder(); // For any error msgs   
            int r = Pcap.findAllDevs(alldevs, errbuf);
            if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
                System.err.printf("Can't read list of devices, error is %s", errbuf.toString());
                return;
            }

            String choose;
            for (PcapIf devicePcap : alldevs) {
                try {
                    macPcaf = devicePcap.getHardwareAddress();
                    sb = new StringBuilder();
                    for (int i = 0; i < macPcaf.length; i++) {
                        sb.append(String.format("%02X%s", macPcaf[i], (i < macPcaf.length - 1) ? "-" : ""));
                    }
                    choose = sb.toString();
                    sb = null;

                    if (macParameter.equalsIgnoreCase(choose)) {
                        System.out.println("device selected");
                        selectedDevice = devicePcap;
                        break;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(pcapInterfaceCapture.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.printf("\nChoosing '%s' :\n", (selectedDevice.getName() != null) ? selectedDevice.getName() : selectedDevice.getName());

            /**
             * *************************************************************************
             * Second we open up the selected device
             * ************************************************************************
             */
            int snaplen = 64 * 1024;           // Capture all packets, no trucation  
            int flags = Pcap.MODE_PROMISCUOUS; // capture all packets  
            int timeout = 10 * 1000;           // 10 seconds in millis  
            Pcap pcap = Pcap.openLive(selectedDevice.getName(), snaplen, flags, timeout, errbuf);

            if (pcap == null) {
                System.err.printf("Error while opening device for capture: " + errbuf.toString());
                return;
            }

            tcp = new Tcp();
            ip = new Ip4();

            jpacketHandler = new PcapPacketHandler<String>() {

                @Override
                public void nextPacket(PcapPacket packet, String user) {
//https://wiki.wireshark.org/TCP_Relative_Sequence_Numbers
                    if (packet.hasHeader(tcp)) {
                        tcpPortSrc = packet.getHeader(tcp).source();
                        tcpPortDst = packet.getHeader(tcp).destination();
                        seqNum = packet.getHeader(tcp).seq();

                    }

                    if (packet.hasHeader(ip)) {
                        sourceHost = Arrays.toString(packet.getHeader(ip).source());
                        dstHost = Arrays.toString(packet.getHeader(ip).destination());
                    }

                    datte = new Date(packet.getCaptureHeader().timestampInMillis());
                    pacLen = packet.getCaptureHeader().caplen(); // Length actually captured  
                    pacWirelen = packet.getCaptureHeader().wirelen(); // Original length

                    String dateStr = "Time" + df.format(datte);

                    String source = "\tSource: " + sourceHost;
                    String tcpPortSrc1 = "\tTCP-Port-Src: " + tcpPortSrc;
                    String tcpPortDst1 = "\tTCP-Port-Dst: " + tcpPortSrc;
                    String dst = "\tDestination: " + dstHost;
                    String seqNo1 = null;
                    String tcpSeqNo = null;
                    if (seqNum != null) {
                        seqNo1 = Long.toString(seqNum);
                    }
                    tcpSeqNo = "\tTCP-Seq: " + seqNo1;
                    String captPack = "\tCaptured Packet Length: " + pacLen.toString();
                    String origPack = "\tOriginal Packet Length: " + pacWirelen.toString();
                    
                    out.write("");
                    out.write(dateStr + source + tcpPortSrc1 + tcpSeqNo + dst + tcpPortDst1 + captPack + origPack + "\n");
                    ServerInterfaceIPSpoofing.outputJTextArea.append(dateStr + source + tcpPortSrc1 + tcpSeqNo + dst + tcpPortDst1 + captPack + origPack + "\n");

                }
            };

            pcap.loop(50, jpacketHandler, "");
            pcap.close();

        }
    }

}
