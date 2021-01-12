package U4_Activitats_text;

import java.util.Scanner;

public class InverteixArrayText {

    public static final int NUM_PARAULES = 5;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        String[] array = new String[NUM_PARAULES];

        System.out.println("Escriu " + NUM_PARAULES + " paraules separades per espai.");
        System.out.println("N'hi ha d'haver una per línia.");
        
        //crea un bucle asta el valor de NUM_PARAULES
        for (int i = 0; i < NUM_PARAULES; i++) {
            // nos pide el valro de la array en i
            array[i] = lector.next();
            // limpia el scanner
            lector.nextLine();
        }
        
        //crea un bucle que empiezqa por el valor las alto de la array y va retando uno al valor de i
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
