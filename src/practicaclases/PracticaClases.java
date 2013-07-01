/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclases;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Ender Mendez
 */
class practicaclases {
    static void limpiar()
    {
        int i;
        for(i=0;i<100; i++ )
        System.out.println("");
    }
    static void pausa(int tiempo)
    {
    try{
        Thread.sleep(tiempo);
        }catch(Exception ex){
        ex.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Cliente cliente1 = new Cliente();
        TipoCuenta tipocuenta1 = new TipoCuenta();
        CuentaBancaria cuenta1 = new CuentaBancaria();
        TipoOperacion ope1 = new TipoOperacion();
        InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader teclado = new BufferedReader (entrada);
	String opcion,mont;
        int op_cliente;
        String num_cliente;
        int op_cuenta;
        String num_cuenta;
        int num_ope;
        int op_principal;
        float monto;
        Date now=new Date();
        SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora=new SimpleDateFormat("HH:mm:ss");
        System.out.println("Fecha:" + fecha.format(now)+"\nHora: "+hora.format(now));
        do
        {
            System.out.println ("Bienvenido al Banco Universal...\n"
                                +"\t\tOperación a realizar:\n"
                                + "\t1- Gestión de Cliente"
                                + "\t 2- Cuenta Bancaria\n"
                                + "\t3- Operaciones"
                                + "\t\t4- Salir del Sistema");
            System.out.println ("\tElige una Opción:");
            opcion = teclado.readLine();
            op_principal = Integer.parseInt(opcion);
            limpiar();
            switch(op_principal)
            {
                case 1:
                  do
                    {
                        System.out.println ("Operación a realizar:\n"
                                            + "1- Crear Cliente\n"
                                            + "2- Listar clientes\n"
                                            + "3- Volver al menu anterior");
                        System.out.println ("Elige una Opción:");
                        opcion = teclado.readLine();
                        op_cliente = Integer.parseInt(opcion);
                        limpiar();

                        switch(op_cliente)
                        {
                            case 1:
                               cliente1.crearCliente();
                               System.out.println ("\nElige Cliente:");
                               opcion = teclado.readLine();
                               num_cliente = opcion;
                               limpiar();
                               tipocuenta1.imprimir();
                               System.out.println ("\nElige tipo de cuenta:");
                               opcion = teclado.readLine();
                               num_cuenta = opcion;
                               limpiar();
                               cuenta1.crearCuentaBancaria(num_cliente, num_cuenta, fecha.format(now));
                               limpiar();
                            break;
                            case 2:                               
                                cliente1.imprimir();
                                pausa(3000);
                                limpiar();
                            break;
                            case 3:
                            break;
                            default:
                                System.out.println ("opción incorrecta");
                            break;
                        }                        
                    }while(op_cliente!=3);
                break;
                case 2:
                    tipocuenta1.imprimir();
                    System.out.println ("\nElige tipo de cuenta:");
                    opcion = teclado.readLine();
                    num_cuenta = opcion;
                    limpiar();
                    cliente1.imprimir();
                    System.out.println ("\nElige Cliente:");
                    opcion = teclado.readLine();
                    num_cliente = opcion;
                    limpiar();
                    cuenta1.crearCuentaBancaria(num_cliente, num_cuenta, fecha.format(now));                    
                break;
                case 3:
                    cliente1.imprimir();
                    System.out.println ("\nElige Cliente:");
                    opcion = teclado.readLine();
                    num_cliente = opcion;
                    limpiar();
                    cuenta1.getCuentaBancaria(num_cliente);
                    System.out.println ("\nElige una Cuenta:");
                    opcion = teclado.readLine();
                    num_cuenta = opcion;
                    limpiar();
                    ope1.imprimir();
                    System.out.println ("Operación a Realizar:");
                    opcion = teclado.readLine();
                    num_ope = Integer.parseInt(opcion);
                    limpiar();
                    do
                    {
                         limpiar();

                        switch(num_ope)
                        {
                            case 1:
                                System.out.println ("Ingrese monto a depositar:");
                                mont = teclado.readLine();                               
                                cuenta1.depositaCuenta(mont, num_cuenta);
                            break;
                            case 2:
                                System.out.println ("Ingrese monto a depositar:");
                                mont = teclado.readLine();
                                cuenta1.retiraCuenta(mont, num_cuenta);
                            break;
                            case 3:
                                cuenta1.getCuentaBancaria(num_cliente);
                            break;
                            case 4:
                            break;
                            default:
                                System.out.println ("opción incorrecta");
                            break;
                        }
                    }while(num_ope!=4);                                        
                   
                break;
                case 4:
                    System.out.println ("Saliendo del sistema...");
                    pausa(1000);
                break;
                default:
                    System.out.println ("opción incorrecta");
                break;
            }
            limpiar();
        }while(op_principal!=4);
    }

}
