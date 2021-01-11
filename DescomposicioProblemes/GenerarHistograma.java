package DescomposicioProblemes;

public class GenerarHistograma {

    public static final int CARES_DAU = 6;

//Variable global
    int[] llistaTirades = new int[CARES_DAU * 2 - 1];

    public static void main(String[] args) {
        GenerarHistograma programa = new GenerarHistograma();
        programa.inici();
    }

    public void inici() {
        generarTirades();
        mostrarHistograma();
        mostrarMaxim();
    }

    public void generarTirades() {
        //recorre dos bucles generado las tiradas de los dados 
        for (int i = 1; i <= CARES_DAU; i++) {
            for (int j = 1; j <= CARES_DAU; j++) {
                llistaTirades[i + j - 2]++;
                //System.out.println(" TR i: " + i + " TR j: " + j + " i + j - 2 " + llistaTirades[i + j - 2]++);
            }

        }
    }

    public void mostrarHistograma() {
        for (int i = 0; i < llistaTirades.length; i++) {
            if (i < 8) {
                System.out.print(" ");
            }
            System.out.print((i + 2) + ": ");
            for (int j = 0; j < llistaTirades[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void mostrarMaxim() {
        int maxim = 0;
        for (int i = 1; i < llistaTirades.length; i++) {
            if (llistaTirades[i] > llistaTirades[maxim]) {
                maxim = i;
            }
        }
        System.out.println("El maxim es " + (maxim + 2) + ".");
    }

}
