package U4_Activitats_text;

import java.util.Scanner;

public class SubcadenaV {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        System.out.println("Escriu una frase:");
        String frase = lector.nextLine();

        int primeraV = frase.indexOf("v");
        int darreraV = frase.lastIndexOf("v");

        if (primeraV == -1) {
            System.out.println("No hi ha cap \"v\".");
        } else if (primeraV == darreraV) {
            System.out.println("Només hi ha una \"v\".");
        } else {
            System.out.println(frase.substring(primeraV, darreraV + 1));
        }
    }
}
