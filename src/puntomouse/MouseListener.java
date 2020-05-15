/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntomouse;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheLokestraps
 */
public class MouseListener extends javax.swing.JPanel {

    /**
     * Creates new form MouseListener
     */
    
    boolean EntraClick;
    public Graphics g;
    public ArrayList<Point> points;
    public Socket cliente;
    public DataOutputStream out;
    public BufferedReader in;
    
    public MouseListener() {
        initComponents();
        points = new ArrayList<>();
        EntraClick = false;
        
        
        try{
             cliente = new Socket("127.0.0.1",5000);//Socket para el cliente en localhost en puerto 5000
            
            System.out.println("Cliente conectado..."+cliente);//Muestra conexión del cliente
            
            out = new DataOutputStream(cliente.getOutputStream());
            in = new BufferedReader(new InputStreamReader(System.in));
        }catch(IOException e){
            System.out.println("NOT CONNECTED");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jButton1.setText("Transmitir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Parar Trasmision");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(670, 480));
        jPanel1.setMinimumSize(new java.awt.Dimension(670, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 480));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EntraClick = false;
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!EntraClick) {
                    if (e.getX() > 170) {
                        try {
                            out.writeUTF(e.getX()+" "+e.getY());
                        } catch (IOException ex) {
                            System.out.println("NOT CONNECTED");
                        }
                            points.add(new Point(e.getX(), e.getY()));
                            System.out.println(e.getX()+" "+e.getY());
                    } else {
                        JOptionPane.showMessageDialog(null, "Fuera de los limites", "ERORR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        EntraClick = true;
        try {
            cliente.close();
            System.out.println("Fin del cliente");
        } catch (IOException ex) {
            System.out.println("NOT CONNECTED");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.add(new MouseListener());
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setSize(670, 480);
            frame.setResizable(false);
            frame.setVisible(true);

        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
