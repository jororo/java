/*
Donat el codi font parcial del programa MaximComuDivisor, que es mostra tot 
seguit, completeu el mètode mcd (inicialment buit), de manera que, donats dos 
valors enters (positius o negatius), calculi el seu Màxim Comú Divisor (MCD) 
seguit l'algorisme d'Euclides.
 */
package U5_ParametritzacioMetodes;

import java.util.Scanner;

//Un programa que calcula l'MCD de dos numeros
public class MaximComuDivisor {

    public static void main(String[] args) {
        MaximComuDivisor programa = new MaximComuDivisor();
        programa.inici();
    }

    public void inici() {
        System.out.print("Escriu el valor a: ");
        int a = llegirEnterTeclat();
        System.out.print("Escriu el valor b: ");
        int b = llegirEnterTeclat();
//Recordar que un mètode s'avalua com una expressió
        System.out.println("L'MCD de " + a + " i " + b + " és " + mcd(a, b));
    }

    public int llegirEnterTeclat() {
        Scanner lector = new Scanner(System.in);
        int enterLlegit = 0;
        boolean llegit = false;
        //Mienbtras llegit sea false
        while (!llegit) {
            llegit = lector.hasNextInt();
            //si llegit es un entero
            if (llegit) {
                //le el siguinte entero
                enterLlegit = lector.nextInt();
            } else {
                //si no indica que no es un entero
                System.out.println("Això no és un enter.");
                lector.next();
            }
        }
        lector.nextLine();
        return enterLlegit;
    }

    public int mcd(int a, int b) {
        //Si a es menor que 0
        if (a < 0) {
            // ponemos a en negativo
            a = -a;
        }
        //Si b es menor que 0
        if (b < 0) {
            // ponemos b en negativo
            b = -b;
        }

        int r = 0;
        //mientras b sea desigual a 0
        while (b != 0) {
            //r toma el valor del resto de la division entre a y b
            r = a % b;
            //a toma el valor de b
            a = b;
            //b toma el valor de r
            b = r;
        }
        return a;

    }

}
