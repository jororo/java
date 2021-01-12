package U4_Activitats_text;

import java.util.Scanner;

public class DarreraParaula {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ves escrivint paraules.");
        System.out.println("Per acabar, usa la paraula \"fi\".");
        String darreraParaula = "";
        boolean fi = false;
        // mietras "fi" sea falso
        do {
            String paraula = lector.next();
            // si paraula es igual a "fi" es verdadreo
            if (paraula.equals("fi")) {                
                fi = true;
            } else {

                // si el valor de paraula y darreraParaula son iguales
                if (paraula.compareTo(darreraParaula) > 0) {
                    
                    darreraParaula = paraula;
                    
                }
            }
        } while (!fi);
        System.out.println("La darrera parala és \"" + darreraParaula + "\".");
    }
}
