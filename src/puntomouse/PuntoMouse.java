/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntomouse;

import javax.swing.JFrame;

/**
 *
 * @author TheLokestraps
 */
public class PuntoMouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         JFrame frame = new JFrame();
        frame.add(new MouseListener());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(670, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
}
