/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclases;

import java.io.*;
import java.util.logging.*;


public class TipoCuenta extends CuentaBancaria

{
    private long idTipoCuenta;
    private String[] descripcion = new String[50];
    static int numCuenta=0;
    int cont;
    public TipoCuenta()
    {
    }
    public void addTipoCuenta() throws IOException
    {
        InputStreamReader entrada = new InputStreamReader(System.in);
    BufferedReader teclado = new BufferedReader (entrada);
	String nom;
	System.out.println ("Ingrese descripción del tipo de cuenta:");
	nom = teclado.readLine();
	numCuenta ++;
        descripcion[numCuenta] = nom;        
        idTipoCuenta = numCuenta;
        imprimir();
    }
    void imprimir()
    {
        if(numCuenta==0)
        {
            try {
                addTipoCuenta();
            } catch (IOException ex) {
                Logger.getLogger(TipoCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            System.out.println ("\nListado de clientes");
            for(cont=1;cont<=numCuenta;cont++)
            {
                System.out.println (cont+" "+descripcion[cont]);
            }
        }
    }
}
