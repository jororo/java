package Activitats_array;

import java.util.Scanner;

public class OmpleArrayParells {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        System.out.print("Quin és el valor de \"i\"? ");
        int i = lector.nextInt();
        lector.nextLine();

        // creamos una array tan grande como el valor de i
        int[] array = new int[i];

        // a la fila 0 d ela array damos valor 0
        array[0] = 0;
        //Recorremos la array
        for (int j = 2; j < array.length; j++) {
            //al valor de array  en j le suma la poiciion anterior en la array mas dos
            array[j] = array[j - 2] + 2;
        }

        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j]+", ");
        }
    }
}
