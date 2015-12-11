package ipspoofingClientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

class SocketAcceptandListener extends Thread {

    private final Socket clientSocket;
    private final JTextArea msgshowingAreabodyPanellChat;
    private BufferedReader br;
    private String serverSentence;

    SocketAcceptandListener(Socket clientSocket, JTextArea msgshowingAreabodyPanellChat) {
        this.clientSocket = clientSocket;
        this.msgshowingAreabodyPanellChat = msgshowingAreabodyPanellChat;
    }

    @Override
    public void run() {
        while (true) {
            try {
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                serverSentence = br.readLine();

                if (serverSentence != null && !serverSentence.isEmpty()) {
                    msgshowingAreabodyPanellChat.append("Received From Client ==> " + serverSentence + "\n");
                }

            } catch (IOException ex) {
                try {
                    clientSocket.close();
                    Logger.getLogger(SocketAcceptandListener.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex1) {
                    Logger.getLogger(SocketAcceptandListener.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

        }

    }

}
