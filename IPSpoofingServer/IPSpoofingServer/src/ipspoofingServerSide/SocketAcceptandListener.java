package ipspoofingServerSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

class SocketAcceptandListener extends Thread {

    public static Socket clienSocket;
    private BufferedReader br;
    private String clientSentence;
    private final ServerSocket sc;
    private final JTextArea textAreaServer;
    private UtilitiesFunctions utl;
    private boolean bool;

    SocketAcceptandListener(ServerSocket serverSock, BufferedReader inFromClient, String clientSentence, JTextArea outputJTextArea) {
        this.sc = serverSock;
        this.br = inFromClient;
        this.clientSentence = clientSentence;
        this.textAreaServer = outputJTextArea;
        this.bool = true;
    }

    @Override
    public void run() {
        while (bool) {

            try {
                clienSocket = sc.accept();
            } catch (IOException ex) {
                Logger.getLogger(SocketAcceptandListener.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                br = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(ServerInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (bool) {
                try {
                    clientSentence = br.readLine();
                    if (clientSentence != null && !clientSentence.isEmpty()) {
                        ServerInterfaceIPSpoofing.outputJTextArea.append("Received From Client ==> " + clientSentence + "\n");
                    } else {
//                        close the both sockets, accepts also should blocked
                        sc.close();
                        clienSocket.close();
                        if (sc.isClosed()) {
                            System.out.println("server is closed now");
                        }
                        this.bool = false;

                    }
                } catch (IOException ex) {
                    Logger.getLogger(SocketAcceptandListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

}
