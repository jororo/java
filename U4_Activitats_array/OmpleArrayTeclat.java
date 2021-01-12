package U4_Activitats_array;

import java.util.Scanner;

public class OmpleArrayTeclat {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        int[] array = new int[10];

        System.out.println("Es llegiran " + array.length + " valors enters.");
        System.out.println("Pots escriure'n diversos en una sola línia.");

        int index = 0;
        while (index < array.length) {
            if (lector.hasNextInt()) {
                array[index] = lector.nextInt();
                index++;
            } else {
                lector.next();
            }
        }
        lector.nextLine();

        System.out.println("La seqüència llegida és:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
