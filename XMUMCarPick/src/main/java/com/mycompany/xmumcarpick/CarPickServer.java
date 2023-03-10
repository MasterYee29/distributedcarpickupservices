/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.xmumcarpick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.transform.Source;

/**
 *
 * @author Francis
 */
public class CarPickServer extends javax.swing.JFrame {

    /**
     * Creates new form CarPickServer
     */
    XMUMCarPick OOP = new XMUMCarPick();
    ArrayList clientOutputStreams;
    ArrayList<String> userss;
    
    public class ClientHandler implements Runnable{
        BufferedReader reader;
        Socket socket;
        PrintWriter client;
        
        public ClientHandler(Socket clientSocket, PrintWriter user){
            client = user;
            try{
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
                
            }catch(Exception ex){
                showArea.append("Unexpected error... \n");
            }
        }
        
        @Override
        public void run(){
            String message, chat = "Chat";
            String[] data;
            
            try{
                while((message=reader.readLine())!=null){
                    showArea.append("Received: " + message + "\n");
                    data = message.split(":");
                    
                    for (String token : data){
                        showArea.append(token + "\n");
                    }
                    
                    switch (data[2]){
                        case "Connect":
                            tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                            userAdd(data[0]);
                            break;
                        case "Disconnect":
                            tellEveryone((data[0] + ":has disconnected!" + ":" + chat));
                            userRemove(data[0]);
                            break;
                        case "Chat":
                            tellEveryone(message);
                            break;
                        default:
                            showArea.append("No Conditions were met! \n");
                    }
                    
                }
            } catch (Exception ex){
                showArea.append("Lost a connection from user... \n");
                ex.printStackTrace();
                clientOutputStreams.remove(client);
            }
                
            
        }
    }
    
    public CarPickServer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startServer = new javax.swing.JButton();
        stopServer = new javax.swing.JButton();
        users = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        serverStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        startServer.setBackground(new java.awt.Color(102, 255, 102));
        startServer.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        startServer.setForeground(new java.awt.Color(0, 0, 0));
        startServer.setText("START");
        startServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startServerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startServerMouseExited(evt);
            }
        });
        startServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerActionPerformed(evt);
            }
        });

        stopServer.setBackground(new java.awt.Color(255, 51, 102));
        stopServer.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        stopServer.setForeground(new java.awt.Color(0, 0, 0));
        stopServer.setText("STOP");
        stopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopServerActionPerformed(evt);
            }
        });

        users.setBackground(new java.awt.Color(255, 255, 0));
        users.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        users.setForeground(new java.awt.Color(0, 0, 0));
        users.setText("USERS");
        users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(0, 153, 153));
        clear.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 0, 0));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        showArea.setColumns(20);
        showArea.setRows(5);
        jScrollPane1.setViewportView(showArea);

        serverStatus.setBackground(new java.awt.Color(51, 255, 255));
        serverStatus.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        serverStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        serverStatus.setText("Server");
        serverStatus.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(serverStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(serverStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(startServer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(users)
                        .addGap(18, 18, 18)
                        .addComponent(clear)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(startServer, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopServerActionPerformed
        // TODO add your handling code here:
        OOP.serverNormal(serverStatus);
        try{
            Thread.sleep(50);
            tellEveryone("Server:will be closed and disconnect all users! \n");
            showArea.append("Server stopping... \n");
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        
        showArea.setText("");
    }//GEN-LAST:event_stopServerActionPerformed

    private void startServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerActionPerformed
        // TODO add your handling code here:
        OOP.serverChange(serverStatus);
        Thread starter = new Thread(new StartServer());
        starter.start();

        showArea.append("Server started... \n");
    }//GEN-LAST:event_startServerActionPerformed

    private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
        // TODO add your handling code here:
        showArea.append("\n Online users : \n");
        for(String currentUser : userss){
            showArea.append(currentUser);
            showArea.append("\n");
        }
    }//GEN-LAST:event_usersActionPerformed

    private void startServerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startServerMouseEntered
        // TODO add your handling code here:
        OOP.changeColor(jPanel2);
    }//GEN-LAST:event_startServerMouseEntered

    private void startServerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startServerMouseExited
        // TODO add your handling code here:
        OOP.normalColor(jPanel2);
    }//GEN-LAST:event_startServerMouseExited

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        showArea.setText("");
    }//GEN-LAST:event_clearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarPickServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarPickServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarPickServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarPickServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarPickServer().setVisible(true);
            }
        });
    }
    
    public void userAdd(String data){
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        showArea.append("Before " + name + " is added. \n");
        userss.add(name);
        showArea.append("After " + name + " is added. \n");
        String[] tempList = new String[(userss.size())];
        userss.toArray(tempList);
        
        for(String token : tempList){
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    
    public void userRemove(String data){
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        userss.remove(name);
        String[] tempList = new String[(userss.size())];
        userss.toArray(tempList);
        
        for(String token : tempList){
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    
    public void tellEveryone(String message){
        Iterator it = clientOutputStreams.iterator();
        
        while(it.hasNext()){
            try{
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                showArea.append("Sending: " + message + "\n");
                writer.flush();
                showArea.setCaretPosition(showArea.getDocument().getLength());
            }catch(Exception IO){
                showArea.append("Error telling everyone... \n");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel serverStatus;
    private javax.swing.JTextArea showArea;
    private javax.swing.JButton startServer;
    private javax.swing.JButton stopServer;
    private javax.swing.JButton users;
    // End of variables declaration//GEN-END:variables
   public class StartServer implements Runnable{
       @Override
       public void run(){
           clientOutputStreams = new ArrayList();
           userss = new ArrayList();
           
           try{
               ServerSocket serverSocket = new ServerSocket(60000);
               
               while(true){
                   Socket clientSocket = serverSocket.accept();
                   PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                   clientOutputStreams.add(writer);
                   
                   Thread listener = new Thread(new ClientHandler(clientSocket, writer));
                   listener.start();
                   showArea.append("Got a new connection! \n");
               }
           }catch(Exception ex){
               showArea.append("Server has already started! \n");
           }
       }
   }
}

