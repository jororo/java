package U4_Activitats_text;

import java.util.Scanner;

public class SumaEntersComes {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Escriu un text compost per nombres separats per comes:");
        String text = lector.nextLine();
        //convierte el string introducido separado la array por comas        
        String[] arrayValors = text.split(",");
        
        int suma = 0;
        //recorre la array 
        for (int i = 0; i < arrayValors.length; i++) {
            //convierte el valor de la array en i a entero
            int valor = Integer.parseInt(arrayValors[i]);
            //suma el valor de "valor" a la variable suma
            suma = suma + valor;
        }
        System.out.println("La suma és " + suma + ".");
    }
}