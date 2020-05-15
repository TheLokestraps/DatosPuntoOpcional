/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.*;
import java.io.*;

/**
 *
 * @author usuario
 */
public class Server {

    /**
     * @param args the command line arguments
     */
//    static ServerSocket self;
//    static Socket selve;
//    static int puerto = 5000;
//    static BufferedReader entrada;    
        
    
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket self;
        Socket selve;
        int puerto = 5000;
        BufferedReader entrada;  
        
        System.out.println("si corri");
        try{
        
            self = new ServerSocket(puerto);
            System.out.println("Esperando la conexion");
            selve = self.accept();
            System.out.println("se detecto un cliente");
            entrada = new BufferedReader(new InputStreamReader(selve.getInputStream()));
            DataOutputStream salida = new DataOutputStream(selve.getOutputStream());       
            System.out.println("conexion confirmada");
            String mensajeRecibido = entrada.readLine();
            System.out.println(mensajeRecibido);
            salida.writeUTF("Se recibio tu mensaje.");
            salida.writeUTF("Gracias por conectarte.");
            System.out.println("Cerrando conexión...");
            self.close();
            
        }catch(IOException e){
            System.out.println("Errooooor");
        
        }
        
        
        
        
    }
    
    
    
}
