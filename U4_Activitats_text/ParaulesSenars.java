package U4_Activitats_text;

import java.util.Scanner;

public class ParaulesSenars {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Escriu una frase de diverses paraules:");
        String frase = lector.nextLine();
        // El string frase lo convierte en una array separada por espacios
        String[] arrayParaules = frase.split(" ");
        //recorre la array mostrando el valor en i y suma dos pociiones mostrando los pares
        for (int i = 0; i < arrayParaules.length; i = i + 2) {
            System.out.print(arrayParaules[i] + " ");
        }
    }
}
