package U5_DescomposicioProblemes;
/*
Feu un programa anomenat GenerarHistograma que mostri l’histograma de totes les 
tirades possibles amb dos daus de sis cares. Per fer això, l’estratègia que s’ha 
considerat és desar dins d’un array el nombre de repeticions de cada tirada 
possible (sempre entre 2 i 12) i després treballar a partir d’aquests valors. A 
continuació, ha de dir quin valor de tirada és el que té més repeticions. A mode 
de guia, la sortida hauria de ser semblant a la que es mostra tot seguit:
*/

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
        mostrarMim();
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

        // Crea un bucle llistaTirades.length como maximo valor
        for (int i = 0; i < llistaTirades.length; i++) {

            // si i es menor que 8 imprime una linea vacia
            if (i < 8) {
                System.out.print(" ");
            }
            // Muestra i sumnadole 2
            System.out.print((i + 2) + ": ");
            // recorre j asta el valor de llistaTirades en i y muestra un caracter por cada buble 
            for (int j = 0; j < llistaTirades[i]; j++) {

                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void mostrarMaxim() {
        int maxim = 0;
        // recorre i asta le maximo de llistaTirades (es 11)
        for (int i = 1; i < llistaTirades.length; i++) {
            // si llistaTirades en i es mayor que llistaTirades a maxin le damos el valor de 1
            if (llistaTirades[i] > llistaTirades[maxim]) {
                maxim = i;
            }
        }
        System.out.println("El maxim es " + (maxim + 2) + ". ");
    }

    public void mostrarMim() {
        int minim = 0;
        // recorre i asta le maximo de llistaTirades (es 11)
        for (int i = 1; i < llistaTirades.length; i++) {
            // si llistaTirades en i es menor que llistaTirades a minim le damos el valor de 1
            if (llistaTirades[i] < llistaTirades[minim]) {
                minim = i;
            }
        }
        System.out.println("El minim es " + (minim + 2) + ". ");
    }

}
