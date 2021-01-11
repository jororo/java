/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EAC4;

/**
 *
 * @author jordi
 */
public class EAC4_P1T2 {

    public static void main(String[] args) {
        //creamos el objero "prog" con la clase EAC4_P1T2
        EAC4_P1T2 prog = new EAC4_P1T2();
        // Llamamos la funcion "inici" del objeto "prog" creado de la clase "EAC4_P1T2"
        prog.inici();
    }

    void inici() {
        // ejecutamos la funcion mostrarMesosDeLAny
        mostrarMesosDeLAny();
        System.out.println("-----------");
        // ejecutamos la funcion mostrarValorsParellsFinsA100
        mostrarValorsParellsFinsA100();
    }

    void mostrarMesosDeLAny() {
        // listamso los meses del año
        System.out.println(" - Gener");
        System.out.println(" - Febrer");
        System.out.println(" - Març");
        System.out.println(" - Abril");
        System.out.println(" - Maig");
        System.out.println(" - Juny");
        System.out.println(" - Juliol");
        System.out.println(" - Agost");
        System.out.println(" - Setembre");
        System.out.println(" - Octubre");
        System.out.println(" - Novembre");
        System.out.println(" - Desembre");
    }

    // Muesta el 
    void mostrarValorsParellsFinsA100() {
        //recorremos el for mostrando el valor de "i" en cada bucle este aumenta su valor en 2 cada vuelta asta que es mayor o igaul que 100
        for (int i = 0; i <= 100; i += 2) {
            System.out.print(" - ");
            System.out.println(i);
        }
        
    }
}
