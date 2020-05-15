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
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket self;
        Socket cliente;
        int puerto = 5000;
        BufferedReader entrada;  
        
        try{
        
            self = new ServerSocket(puerto);
            System.out.println("Esperando la conexion");
            cliente = self.accept();
            System.out.println("se detecto un cliente");
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println("conexion confirmada");
            
            //lectura del mensaje
            String mensajeRecibido = entrada.readLine();
            System.out.println("Las cordenadas son "+mensajeRecibido);
            
            //desconexion
            System.out.println("Cerrando conexión...");
            self.close();
            
        }catch(IOException e){
            System.out.println("Something gone wrong");
        
        }
        
        
        
        
    }
    
    
    
}
