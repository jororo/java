package array;

import java.util.Scanner;

public class array_ejmplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* las array se puedend eclrar asi sin valores asignados
        
                int array_ejmplo[][];

        array_ejmplo = new int[4][4];
        
        o tambien se puedne declrar directamente con valores
        
        int array_ejmplo[][] = { {1,2,3,4}, {5,6,7,8}};
        
        int array_ejmplo[][];

        array_ejmplo = new int[4][4];
         */
 /*
        tabla
                columnas    
        filas   0   1   2   3   4
        0       0   1   2   3   4
        1       10  11  12  13  14
        2       20  21  22  23  24
        3       30  31  32  33  34
        4       40  41  42  43  44
        
         */
        int array_ejmplo[][] = {{0, 1, 2, 3, 4}, {10, 11, 12, 13, 14}, {20, 21, 22, 23, 24}, {30, 31, 32, 33, 34}, {40, 41, 42, 43, 44},};

        /*for (int x = 0; x < array_ejmplo.length; x++) {

            for (int y = 0; y < array_ejmplo[x].length; y++) {

                System.out.println(array_ejmplo[x][y]);

            }

        }*/
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce la fila");
        int fila = scan.nextInt();
        System.out.print("Introduce la columna");
        int columna = scan.nextInt();
        System.out.println(array_ejmplo[fila][columna]);

    }

}
