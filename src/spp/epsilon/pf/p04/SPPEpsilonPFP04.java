//Proyecto Final 
//Problema 4
//Equipo Epsilon
//Nombres, matrículas y carreras de integrantes de equipo:
//Roberto Alain Rivera Bravo | A01411516 | IMT11
//Fabricio Arturo Balboa Cavazos | A01411541 | IMT11
//Andrés de Jesús Martínez Castillo | A01411447 | IMT11
//Jessica Delgado González | A01411536 | IMT11
//Alfredo Alejandro Lárraga Sosa | A01410278 | LMC

/*
 4.	Realiza un programa en Java que muestre un Menú con 3 opciones: 
Opción 1: Inventario, Opción 2: Vender, Opción 3: Salir. Al presionar la
Opción 1 el usuario podrá introducir un artículo con los campos: clave, descripción
y precio unitario, deberá guardarlos en un arreglo. Al presionar la opción 2,
el usuario introducirá una clave de productos ya registrados para guardarlos en otro arreglo,
la opción deberá repetirse hasta presionar el botón Cancelar, después deberá mostrar el total 
a pagar de los artículos introducidos, si se introduce alguna clave inexistente deberá notificarse al usuario. 
 */
package spp.epsilon.pf.p04;

import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class SPPEpsilonPFP04 {

 
    public static void main(String[] args) {
        boolean flag;
        
        do{        
            menu(); //manda a método menú
            flag = salida(); //recibe el valor booleano
        } while (flag==false);
        JOptionPane.showMessageDialog(null, "Vuelva pronto ");
    }
    
    public static void menu(){
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione: ",
                    "MENU",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                    new Object []{"Inventario", "Vender", "Salir"}, "Inventario");
        if(opcion==0){
                arrayString();
        }else if(opcion==1){
            JOptionPane.showMessageDialog(null,"No hay nada en el inventario");

        }else{
            JOptionPane.showMessageDialog(null, "Vuelva pronto ");
        }
    }

    public static void arrayString(){
        String[][]A=new String[100][3];
        int m=0;
        while(m==0){

            for (int i = 0; i < A.length; i++) {
                String [] V=vector();
                A[i][0]=V[0];
                A[i][1]=V[1];
                A[i][2]=V[2];
                m=JOptionPane.showOptionDialog(null, "¿Desea agregar otro artículo?",
                "Artículos",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                new Object []{"Si", "No"},"Si");
                if(m==1){
                    i=A.length;
                    int opcion = JOptionPane.showOptionDialog(null, "Seleccione: ",
                    "MENU",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                    new Object []{"Inventario", "Vender", "Salir"}, "Inventario");
                    if(opcion==0){
                        m=0;
                        } else if(opcion==1){
                        vender(A);
                        } else{
                            JOptionPane.showMessageDialog(null,"Vuelva pronto");
                            System.exit(0);
                        }
                }
             
            }
           
        }
        
    }
    
    public static String[] vector(){
        String[] V = new String[3];
        V[0]=solicitarDatoString("Introduce la clave del producto[3 dígitos]");
        V[1]=solicitarDatoString("Introduce la descripción del producto");
        V[2]=solicitarDatoDouble("Introduce el precio unitario del producto");
        return V;
    }
    
    public static String solicitarDatoString(String mensaje){//Método que me devuelve una variable tipo String validada introducida mediante cuadro de dialogo
        boolean flag;
        String n = null;
            do{
                try{//Se utiliza un Try & Catch para evitar errores cuando se ingresan valores por teclado
                    n=JOptionPane.showInputDialog(null,  mensaje);
                    flag=true;
                 }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato no válido, vuelva a intentar", "Error", JOptionPane.ERROR_MESSAGE);
                    flag=false;     
                }   
            }while(flag==false);
        return n;
    }
    
    public static String solicitarDatoDouble(String mensaje){//Método que me devuelve una variable tipo String validada introducida mediante cuadro de dialogo
        boolean flag; String n = null; double y=0;
            do{
                try{//Se utiliza un Try & Catch para evitar errores cuando se ingresan valores por teclado
                    n=JOptionPane.showInputDialog(null,  mensaje);
                    y=Double.parseDouble(n);
                    flag=true;
                 }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato no válido, vuelva a intentar", "Error", JOptionPane.ERROR_MESSAGE);
                    flag=false;     
                }   
            }while(flag==false);
            n=Double.toString(y);
        return n;
    }
    
    //realiza las operaciones de venta por clave
    public static void vender(String[][]inventario){
        String clave;
        int m = -1, confirm;
        double total = 0;
        
        do{
            clave = JOptionPane.showInputDialog(null,"Ingrese la clave del produto a vender", "Clave Producto", JOptionPane.QUESTION_MESSAGE);
            if (clave != null ){
                for(int i = 0; i < inventario.length; i++){
                    if(clave.equals(inventario[i][0])){
                        m = i;
                        System.out.println(m+""+i);
                        i = inventario.length;
                    } else {
                       m=-1;
                    }
                      
                }
                
                if(m == -1){
                    JOptionPane.showMessageDialog(null, "La clave introducida no existe en inventario", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    
                JOptionPane.showMessageDialog(null, "Ha vendido el producto "
                +inventario[m][1]+" de clave "+inventario[m][0]+ " y precio " +inventario[m][2],
                "Venta", JOptionPane.WARNING_MESSAGE);
            
                total+=Double.parseDouble(inventario[m][2]);
                JOptionPane.showMessageDialog(null, "El subtotal hasta ahora es $"+total,"Subtotal", JOptionPane.INFORMATION_MESSAGE);
                }
            } else{
                confirm = JOptionPane.showConfirmDialog(null,"¿Confirmas salir de la venta?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if(confirm == 1){
                    clave = "";
                } 
            }

        } while (clave != null);
        
        JOptionPane.showMessageDialog(null, "El total de a pagar de los artículos vendidos es $"+total, 
                "Total vendido", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Método salir: da opción de terminar o reiniciar los cálculos   
    public static boolean salida(){
        int option;
        boolean flag;
        
        option = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", 
        "Menú de salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        //verifica si el String es igual a "1"
        if(option == 1){
             //Se manda el valor booleano para volver a ejecutar el programa
            flag=false;
        } else{
            //Se manda el valor booleano para terminar el programa
           flag=true; 
        }
        
        return flag;  //Se regresa el valor booleano
    }

    
}