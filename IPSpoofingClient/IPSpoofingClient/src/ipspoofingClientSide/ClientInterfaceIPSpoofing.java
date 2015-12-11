package ipspoofingClientSide;

import static ipspoofingClientSide.pcapInterfaceCapture.threadCheckBool;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientInterfaceIPSpoofing extends javax.swing.JFrame {

    private Enumeration<NetworkInterface> nets;
    private String fetchInterfaceName;
    private byte[] mac;
    private Object portTextFieldstartServer;
    private String portval;
    UtilitiesFunctions utl = new UtilitiesFunctions();
    private Socket clientSock;
    private BufferedReader inFromClient;
    private String clientSentence;
    private DataOutputStream outToServer;
    private String sentence;
    private String macParameter;
    private pcapInterfaceCapture pic;
    
    public static Integer hop_count;
    public static Inet4Address LocalIP;
    public static Integer LocalPort;
    public static Inet4Address PublicIP;
    public static Integer PublicPort;
    private static byte[] keyValue;

    public ClientInterfaceIPSpoofing() throws SocketException {
        initComponents();
        networkInterfaceList.addItem(null);
        ListUpNets LUN = new ListUpNets();
        chatJbuttonClient.setVisible(false);
        chatWritingJTextAreaClient.setVisible(false);
        stopCaptureJButtonClient.setVisible(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ualr.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connectionPanel = new javax.swing.JPanel();
        networkInterfaceList = new javax.swing.JComboBox();
        networkInterfaceLabel = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        jButtonConnect = new javax.swing.JButton();
        ipTextField = new javax.swing.JTextField();
        chatJbuttonClient = new javax.swing.JButton();
        captureJbuttonClient = new javax.swing.JButton();
        chatWritingJTextAreaClient = new javax.swing.JTextField();
        stopCaptureJButtonClient = new javax.swing.JButton();
        dataSendReceivePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputJTextArea = new javax.swing.JTextArea();
        functionPanel = new javax.swing.JPanel();
        sharedKeyJText = new javax.swing.JTextField();
        sharedKeyLabel = new javax.swing.JLabel();
        sharedKeyJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client    (upgautam@ualr.edu)");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.gray);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        networkInterfaceList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                networkInterfaceListItemStateChanged(evt);
            }
        });
        networkInterfaceList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                networkInterfaceListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                networkInterfaceListMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                networkInterfaceListMouseReleased(evt);
            }
        });
        networkInterfaceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkInterfaceListActionPerformed(evt);
            }
        });

        networkInterfaceLabel.setText("Select Network Interface");

        portTextField.setText("12345");
        portTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTextFieldActionPerformed(evt);
            }
        });

        jButtonConnect.setText("Connect");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        ipTextField.setText("127.0.0.1");
        ipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipTextFieldActionPerformed(evt);
            }
        });

        chatJbuttonClient.setText("Chat");
        chatJbuttonClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatJbuttonClientActionPerformed(evt);
            }
        });

        captureJbuttonClient.setText("Capture");
        captureJbuttonClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                captureJbuttonClientMouseClicked(evt);
            }
        });
        captureJbuttonClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureJbuttonClientActionPerformed(evt);
            }
        });

        chatWritingJTextAreaClient.setText("Hello from Client to Server !!");
        chatWritingJTextAreaClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatWritingJTextAreaClientActionPerformed(evt);
            }
        });

        stopCaptureJButtonClient.setText("Stop-Capture");
        stopCaptureJButtonClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopCaptureJButtonClientMouseClicked(evt);
            }
        });
        stopCaptureJButtonClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopCaptureJButtonClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout connectionPanelLayout = new javax.swing.GroupLayout(connectionPanel);
        connectionPanel.setLayout(connectionPanelLayout);
        connectionPanelLayout.setHorizontalGroup(
            connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(connectionPanelLayout.createSequentialGroup()
                        .addComponent(ipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chatWritingJTextAreaClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonConnect)
                    .addComponent(chatJbuttonClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectionPanelLayout.createSequentialGroup()
                        .addComponent(networkInterfaceLabel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectionPanelLayout.createSequentialGroup()
                        .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stopCaptureJButtonClient)
                            .addGroup(connectionPanelLayout.createSequentialGroup()
                                .addComponent(networkInterfaceList, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(captureJbuttonClient)))
                        .addGap(23, 23, 23))))
        );
        connectionPanelLayout.setVerticalGroup(
            connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectionPanelLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConnect)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chatJbuttonClient)
                    .addComponent(chatWritingJTextAreaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(networkInterfaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(captureJbuttonClient)
                    .addComponent(networkInterfaceList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stopCaptureJButtonClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outputJTextArea.setColumns(20);
        outputJTextArea.setRows(5);
        jScrollPane1.setViewportView(outputJTextArea);

        javax.swing.GroupLayout dataSendReceivePanelLayout = new javax.swing.GroupLayout(dataSendReceivePanel);
        dataSendReceivePanel.setLayout(dataSendReceivePanelLayout);
        dataSendReceivePanelLayout.setHorizontalGroup(
            dataSendReceivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        dataSendReceivePanelLayout.setVerticalGroup(
            dataSendReceivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataSendReceivePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sharedKeyJText.setText("SecretKey");
        sharedKeyJText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sharedKeyJTextActionPerformed(evt);
            }
        });

        sharedKeyLabel.setText("Function");

        sharedKeyJButton.setText("Encrypt");
        sharedKeyJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sharedKeyJButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout functionPanelLayout = new javax.swing.GroupLayout(functionPanel);
        functionPanel.setLayout(functionPanelLayout);
        functionPanelLayout.setHorizontalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(sharedKeyLabel)
                .addGap(18, 18, 18)
                .addComponent(sharedKeyJText)
                .addGap(18, 18, 18)
                .addComponent(sharedKeyJButton)
                .addContainerGap())
        );
        functionPanelLayout.setVerticalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sharedKeyJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sharedKeyJButton)
                    .addComponent(sharedKeyLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(connectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dataSendReceivePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(connectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dataSendReceivePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sharedKeyJTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sharedKeyJTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sharedKeyJTextActionPerformed

    private void networkInterfaceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkInterfaceListActionPerformed
        try {
            fetchInterfaceName = (String) networkInterfaceList.getSelectedItem();
            nets = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            Logger.getLogger(ClientInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_networkInterfaceListActionPerformed

    private void portTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portTextFieldActionPerformed

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        portval = portTextField.getText();
        String ipText = ipTextField.getText();
        if (utl.isInteger(portval)) {
            if (utl.isOutOfRange(portval)) {

                try {
                    int portint = Integer.parseInt(portval);
                    clientSock = new Socket(ipText, portint);

                    if (clientSock.isConnected()) {
                        ClientInterfaceIPSpoofing.chatJbuttonClient.show();
                        utl.repaintandvalidate(chatJbuttonClient);
                        chatWritingJTextAreaClient.setVisible(true);
                        chatWritingJTextAreaClient.repaint();
                        chatWritingJTextAreaClient.validate();
                    }
                    SocketAcceptandListener sat = new SocketAcceptandListener(clientSock, outputJTextArea);
                    sat.start();
                } catch (IOException ex) {
                    Logger.getLogger(ClientInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void networkInterfaceListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_networkInterfaceListItemStateChanged

    }//GEN-LAST:event_networkInterfaceListItemStateChanged

    private void networkInterfaceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkInterfaceListMouseClicked

    }//GEN-LAST:event_networkInterfaceListMouseClicked

    private void networkInterfaceListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkInterfaceListMousePressed
    }//GEN-LAST:event_networkInterfaceListMousePressed

    private void networkInterfaceListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkInterfaceListMouseReleased
    }//GEN-LAST:event_networkInterfaceListMouseReleased

    private void ipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipTextFieldActionPerformed

    private void chatJbuttonClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatJbuttonClientActionPerformed
        try {
            outToServer = new DataOutputStream(clientSock.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
        }
        sentence = chatWritingJTextAreaClient.getText();
        try {
            outToServer.writeBytes(sentence + '\n');
        } catch (IOException ex) {
            Logger.getLogger(ClientInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
        }
//        also write to own msgshowing text area
        if (sentence != null && !sentence.isEmpty()) {
            outputJTextArea.append("Own PC ==> " + sentence + "\n");
        }
        chatWritingJTextAreaClient.setText(null);
    }//GEN-LAST:event_chatJbuttonClientActionPerformed

    private void captureJbuttonClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureJbuttonClientActionPerformed

    }//GEN-LAST:event_captureJbuttonClientActionPerformed

    private void chatWritingJTextAreaClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatWritingJTextAreaClientActionPerformed

    }//GEN-LAST:event_chatWritingJTextAreaClientActionPerformed

    private void stopCaptureJButtonClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopCaptureJButtonClientActionPerformed

    }//GEN-LAST:event_stopCaptureJButtonClientActionPerformed

    private void captureJbuttonClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_captureJbuttonClientMouseClicked
        outputJTextArea.setText(null);
        selectMatchedInterface();
        pcapInterfaceCapture.threadCheckBool = true;
        this.pic = new pcapInterfaceCapture(macParameter, threadCheckBool);
        pic.start();
        stopCaptureJButtonClient.setVisible(true);
    }//GEN-LAST:event_captureJbuttonClientMouseClicked

    private void stopCaptureJButtonClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopCaptureJButtonClientMouseClicked
//        stop the captureing thread
//        http://stackoverflow.com/questions/2076037/inside-onclicklistener-i-cannot-access-a-lot-of-things-how-to-approach
//       http://stackoverflow.com/questions/16221382/stop-thread-onclicklistener-java
        pcapInterfaceCapture.threadCheckBool = false;
    }//GEN-LAST:event_stopCaptureJButtonClientMouseClicked

    private void sharedKeyJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sharedKeyJButtonMouseClicked
//        get all parameters: hop_count, LocalIP, LocalPort, PublicIP, PublicPort
        getAllParameters();
        keyValue = ((sharedKeyJText.getText().getBytes() != null)? sharedKeyJText.getText().getBytes() : null);
        
//        String response = Arrays.toString(keyValue);      
//        String[] byteValues = response.substring(1, response.length() - 1).split(",");
//        byte[] bytes = new byte[byteValues.length];
//        for (int i=0, len=bytes.length; i<len; i++) {
//           bytes[i] = Byte.parseByte(byteValues[i].trim());     
//        }
//        String str = new String(bytes);
//        System.out.println("Data's equivalent string is: "+str);

        encryptAllParameter(hop_count, LocalIP, LocalPort, PublicIP, PublicPort);
    }//GEN-LAST:event_sharedKeyJButtonMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientInterfaceIPSpoofing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ClientInterfaceIPSpoofing().setVisible(true);
            } catch (SocketException ex) {
                Logger.getLogger(ClientInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton captureJbuttonClient;
    public static javax.swing.JButton chatJbuttonClient;
    public static javax.swing.JTextField chatWritingJTextAreaClient;
    private javax.swing.JPanel connectionPanel;
    private javax.swing.JPanel dataSendReceivePanel;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel networkInterfaceLabel;
    public static javax.swing.JComboBox networkInterfaceList;
    public static javax.swing.JTextArea outputJTextArea;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton sharedKeyJButton;
    private javax.swing.JTextField sharedKeyJText;
    private javax.swing.JLabel sharedKeyLabel;
    public static javax.swing.JButton stopCaptureJButtonClient;
    // End of variables declaration//GEN-END:variables

    private void selectMatchedInterface() {
        for (NetworkInterface netint : Collections.list(nets)) {
            try {
                //                we can run below two line by process to disable 6to4 ip packets
//                set-net6to4configuration -state disabled
//                set-netisatapconfiguration -state disabled
                if (netint.isUp() && !netint.isVirtual()) {
                    if (netint.getDisplayName() == null ? fetchInterfaceName == null : netint.getDisplayName().equals(fetchInterfaceName)) {
//                            http://stackoverflow.com/questions/10962072/get-mac-address-in-java-using-gethardwareaddress-non-deterministic
                        mac = netint.getHardwareAddress();

//                            to print mac address in known form  
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < mac.length; i++) {
                            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                        }
                        this.macParameter = sb.toString();
                        break;
                    }
                }
            } catch (SocketException ex) {
                Logger.getLogger(ClientInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getAllParameters() {
        
    }

    private void encryptAllParameter(Integer hop_count, Inet4Address LocalIP, Integer LocalPort, Inet4Address PublicIP, Integer PublicPort) {
    }

}
