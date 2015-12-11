package ipspoofingServerSide;

import static ipspoofingServerSide.pcapInterfaceCapture.threadCheckBool;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerInterfaceIPSpoofing extends javax.swing.JFrame {

    private Enumeration<NetworkInterface> nets;
    private String fetchInterfaceName;
    private byte[] mac;
    private Object portTextFieldstartServer;
    private String portval;
    UtilitiesFunctions utl = new UtilitiesFunctions();
    private ServerSocket serverSock;
    private BufferedReader inFromClient;
    private String clientSentence;
    private DataOutputStream outToClient;
    private String sentence;
    private String macParameter;
    private pcapInterfaceCapture pic;

    public ServerInterfaceIPSpoofing() throws SocketException {
        initComponents();
        networkInterfaceList.addItem(null);
        ListUpNets LUN = new ListUpNets();
        chatJbuttonServer.setVisible(false);
        chatWritingJTextAreaServer.setVisible(false);
        stopCaptureJButtonServer.setVisible(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ualr.png")));
//        combining all jars into one final independent jar
//        https://www.youtube.com/watch?v=BsndjGOc1w4?

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connectionPanel = new javax.swing.JPanel();
        networkInterfaceList = new javax.swing.JComboBox();
        networkInterfaceLabel = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        jButtonListen = new javax.swing.JButton();
        chatJbuttonServer = new javax.swing.JButton();
        captureJbuttonServer = new javax.swing.JButton();
        chatWritingJTextAreaServer = new javax.swing.JTextField();
        stopCaptureJButtonServer = new javax.swing.JButton();
        dataSendReceivePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputJTextArea = new javax.swing.JTextArea();
        functionPanel = new javax.swing.JPanel();
        sharedKeyJText = new javax.swing.JTextField();
        sharedKeyLabel = new javax.swing.JLabel();
        sharedKeyJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IP Configuration Utility (upgautam@ualr.edu)");
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

        jButtonListen.setText("Listen");
        jButtonListen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListenActionPerformed(evt);
            }
        });

        chatJbuttonServer.setText("Chat");
        chatJbuttonServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatJbuttonServerActionPerformed(evt);
            }
        });

        captureJbuttonServer.setText("Capture");
        captureJbuttonServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                captureJbuttonServerMouseClicked(evt);
            }
        });
        captureJbuttonServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureJbuttonServerActionPerformed(evt);
            }
        });

        chatWritingJTextAreaServer.setText("Hello from Server to Client !!");

        stopCaptureJButtonServer.setText("Stop-Capture");
        stopCaptureJButtonServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopCaptureJButtonServerMouseClicked(evt);
            }
        });
        stopCaptureJButtonServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopCaptureJButtonServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout connectionPanelLayout = new javax.swing.GroupLayout(connectionPanel);
        connectionPanel.setLayout(connectionPanelLayout);
        connectionPanelLayout.setHorizontalGroup(
            connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonListen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectionPanelLayout.createSequentialGroup()
                        .addComponent(networkInterfaceLabel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectionPanelLayout.createSequentialGroup()
                        .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stopCaptureJButtonServer)
                            .addGroup(connectionPanelLayout.createSequentialGroup()
                                .addComponent(networkInterfaceList, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(captureJbuttonServer)))
                        .addGap(23, 23, 23))))
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addComponent(chatWritingJTextAreaServer, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatJbuttonServer)
                .addContainerGap(728, Short.MAX_VALUE))
        );
        connectionPanelLayout.setVerticalGroup(
            connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectionPanelLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonListen)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chatJbuttonServer)
                    .addComponent(chatWritingJTextAreaServer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addComponent(networkInterfaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(captureJbuttonServer)
                    .addComponent(networkInterfaceList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopCaptureJButtonServer)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            Logger.getLogger(ServerInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_networkInterfaceListActionPerformed

    private void portTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portTextFieldActionPerformed

    private void jButtonListenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListenActionPerformed
        portval = portTextField.getText();
        if (utl.isInteger(portval)) {
            if (utl.isOutOfRange(portval)) {

                int portint = Integer.parseInt(portval);
                try {
                    serverSock = new ServerSocket(portint);
                    System.out.println("uddhav");
//                  listener for clients
                    SocketAcceptandListener sat = new SocketAcceptandListener(serverSock, inFromClient, clientSentence, outputJTextArea);
                    sat.start();
                    utl.showButton(chatJbuttonServer);
                    utl.repaintandvalidate(chatJbuttonServer);
                    chatWritingJTextAreaServer.setVisible(true);
                    chatWritingJTextAreaServer.repaint();
                    chatWritingJTextAreaServer.validate();
                } catch (IOException ex) {
                    Logger.getLogger(ServerInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonListenActionPerformed

    private void networkInterfaceListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_networkInterfaceListItemStateChanged

    }//GEN-LAST:event_networkInterfaceListItemStateChanged

    private void networkInterfaceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkInterfaceListMouseClicked

    }//GEN-LAST:event_networkInterfaceListMouseClicked

    private void networkInterfaceListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkInterfaceListMousePressed
    }//GEN-LAST:event_networkInterfaceListMousePressed

    private void networkInterfaceListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkInterfaceListMouseReleased
    }//GEN-LAST:event_networkInterfaceListMouseReleased

    private void chatJbuttonServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatJbuttonServerActionPerformed
        try {
            outToClient = new DataOutputStream(SocketAcceptandListener.clienSocket.getOutputStream());

        } catch (IOException ex) {
            Logger.getLogger(ServerInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
        }
        sentence = chatWritingJTextAreaServer.getText();
        try {
            outToClient.writeBytes(sentence + '\n');

        } catch (IOException ex) {
            Logger.getLogger(ServerInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (sentence != null && !sentence.isEmpty()) {
            outputJTextArea.append("Own PC ==> " + sentence + "\n");
        }
        chatWritingJTextAreaServer.setText(null);

    }//GEN-LAST:event_chatJbuttonServerActionPerformed

    private void captureJbuttonServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureJbuttonServerActionPerformed

    }//GEN-LAST:event_captureJbuttonServerActionPerformed

    private void stopCaptureJButtonServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopCaptureJButtonServerActionPerformed

    }//GEN-LAST:event_stopCaptureJButtonServerActionPerformed

    private void captureJbuttonServerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_captureJbuttonServerMouseClicked
        outputJTextArea.setText(null);
        selectMatchedInterface();
        pcapInterfaceCapture.threadCheckBool = true;
        this.pic = new pcapInterfaceCapture(macParameter, threadCheckBool);
        pic.start();
        stopCaptureJButtonServer.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_captureJbuttonServerMouseClicked

    private void stopCaptureJButtonServerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopCaptureJButtonServerMouseClicked
//        stop the captureing thread
//       http://stackoverflow.com/questions/2076037/inside-onclicklistener-i-cannot-access-a-lot-of-things-how-to-approach
//       http://stackoverflow.com/questions/16221382/stop-thread-onclicklistener-java
        pcapInterfaceCapture.threadCheckBool = false;
    }//GEN-LAST:event_stopCaptureJButtonServerMouseClicked

    private void sharedKeyJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sharedKeyJButtonMouseClicked
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(ServerInterfaceIPSpoofing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ServerInterfaceIPSpoofing().setVisible(true);
            } catch (SocketException ex) {
                Logger.getLogger(ServerInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton captureJbuttonServer;
    public static javax.swing.JButton chatJbuttonServer;
    public static javax.swing.JTextField chatWritingJTextAreaServer;
    private javax.swing.JPanel connectionPanel;
    private javax.swing.JPanel dataSendReceivePanel;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JButton jButtonListen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel networkInterfaceLabel;
    public static javax.swing.JComboBox networkInterfaceList;
    public static javax.swing.JTextArea outputJTextArea;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton sharedKeyJButton;
    private javax.swing.JTextField sharedKeyJText;
    private javax.swing.JLabel sharedKeyLabel;
    public static javax.swing.JButton stopCaptureJButtonServer;
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
                Logger.getLogger(ServerInterfaceIPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
