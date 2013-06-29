/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclases;
import java.io.*;
/**
 *
 * @author Cristian
 */
public class Cliente {
    private long idCliente;
    private String[] nombreCliente = new String[50];
    static int numCliente=1;
    int cont;

    public Cliente(String nombCli){
          nombreCliente[numCliente] = nombCli;
          idCliente = numCliente;
          numCliente ++;
    }
    
    public void createCliente(){
        
    }
}
