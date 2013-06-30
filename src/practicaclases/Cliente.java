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
    static int numCliente=0;
    int cont;

    public Cliente(String nombCli){
          nombreCliente[numCliente] = nombCli;          
          numCliente ++;
          idCliente = numCliente;
    }
    public Cliente()
    {
    }

    public void crearCliente() throws IOException
    {
        InputStreamReader entrada = new InputStreamReader(System.in);
    BufferedReader teclado = new BufferedReader (entrada);
	String nom;
	System.out.println ("Ingrese nombre del titular de la cuenta:");
	nom = teclado.readLine();
        numCliente ++;
	nombreCliente[numCliente] = nom;
        idCliente = numCliente;                        
        imprimir();
    }
    void imprimir()
    {
        if(numCliente==0)
        {
            try {
                crearCliente();
            } catch (IOException ex) {
                Logger.getLogger(TipoCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            System.out.println ("\nListado de clientes");
            for(cont=1;cont<=numCliente;cont++)
            {
                System.out.println (cont+" "+nombreCliente[cont]);
            }
        }
    }
}
