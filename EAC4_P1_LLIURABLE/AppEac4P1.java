package EAC4_P1_LLIURABLE;

import java.util.Scanner;

public class AppEac4P1 {

    static final int ID_MATRICULA = 0;
    static final int ID_TIPUS_VEHICLE = 1;
    static final int ID_TIPUS_REGISTRE = 2;
    static final int ID_NIF_PROPIETARI = 3;
    static final int MATRICULA_INEXISTENT = -1;
    static final int REGISTRE_ALTA = 1;
    static final int REGISTRE_COMPRAVENDA = 2;
    static final int REGISTRE_BAIXA = 3;
    static final int REGISTRE_TIPUSINEXISTENT = -1;

    Scanner scanner = new Scanner(System.in);

    // creamos la array bidimensional "vehicles" con los siguintes datos
    String[][] vehicles = {
        //  MATRICULA  TIP    M   PROPIETARI
        {"1111GGH", "C0", "A", "45821635K"},
        {"1122GGH", "M0", "A", "96521138G"},
        {"2233GKA", "CA", "A", "32651114X"},
        {"2344GZD", "CO", "C", "63284450V"},
        {"2534GZR", "CA", "C", "56722215M"},
        {"2691JAA", "MO", "A", "63284450V"},
        {"2712JAA", "CO", "B", ""},
        {"2845JAB", "CO", "C", "66620000U"},
        {"2848JDE", "CO", "A", "73332266Q"},
        {"2955JDW", "CO", "A", "11429999K"},
        {"2968JDZ", "CO", "A", "22223333L"},
        {"3015KAA", "MO", "A", "88521136J"},
        {"3018KAB", "MO", "B", ""},
        {"3022KAB", "CO", "A", "29753241P"},
        {"4025KAB", "CO", "A", "55552246Y"},
        {"4035KAB", "CA", "R", "38922010T"},
        {"4051KAB", "CO", "A", "62035492U"},
        {"5015KAC", "MO", "A", "45821635K"},
        {"5018KAC", "MO", "C", "66620000U"},};

    public static void main(String[] args) {
        AppEac4P1 prg = new AppEac4P1();
        prg.inici();
    }

    void inici() {
        int fila;

        System.out.println("");
        fila = obtenirFilaPerMatricula("2534GZR");
        mostrarPosicioMatricula("2534GZR", fila);
        mostrarInformacio(fila);

        System.out.println("");
        fila = obtenirFilaPerMatricula("1122GGH");
        mostrarPosicioMatricula("1122GGH", fila);
        mostrarInformacio(fila);

        System.out.println("");
        fila = obtenirFilaPerMatricula("5522GGH");
        mostrarPosicioMatricula("5522GGH", fila);
        mostrarInformacio(fila);

        System.out.println("");
        fila = obtenirFilaPerMatricula("2712JAA");
        mostrarPosicioMatricula("2344GZD", fila);
        mostrarInformacio(fila);

        System.out.println("");
        fila = obtenirFilaPerMatricula("4035KAB");
        mostrarPosicioMatricula("4035KAB", fila);
        mostrarInformacio(fila);

        System.out.println("");
        fila = obtenirFilaPerMatricula("2344GZD");
        mostrarPosicioMatricula("2344GZD", fila);
        mostrarInformacio(fila);

    }

    int obtenirFilaPerMatricula(String matricula) {
        int fila = 0;
        boolean trobat = false;
        //mientras trobat sea falso y fila sea menor que la fila maxima de la array "vehicles" ejecutara lo siguinte
        while (!trobat && fila < vehicles.length) {
            //Si el valor de la array en la fila "fila" columna "ID_MATRICULA" sehan igual que el valore de "matricula"
            if (vehicles[fila][ID_MATRICULA].equals(matricula)) {
                // trobat es verdadero
                trobat = true;
            } else {
                //Suma 1 a fila
                ++fila;
            }
        }
        if (!trobat) {
            // si despues del while el valor de trobat es igual a falso a fila le introduce el valor de la constante MATRICULA_INEXISTENT
            fila = MATRICULA_INEXISTENT;
        }
        return fila;
    }

    void mostrarPosicioMatricula(String matricula, int fila) {

        System.out.print("La matricula: ");
        System.out.print(matricula);

        //Si el valor de fila es igual al valor de MATRICULA_INEXISTENT muestra lo siguinte
        if (fila == MATRICULA_INEXISTENT) {

            System.out.println(" no existeix");

            //Si no muestra lo siguinte
        } else {

            System.out.print(" es troba a la posició o fila ");
            System.out.println(fila);

        }
    }

    void mostrarInformacio(int fila) {
        int tipusRegistre;
        //Si el valor de fila es igual al valor de MATRICULA_INEXISTENT no devulve nada
        if (fila == MATRICULA_INEXISTENT) {
            return;
        }
        //llama la funcion obtenirTipusRegistreMatriculaPerFila con el valor de fila
        tipusRegistre = obtenirTipusRegistreMatriculaPerFila(fila);
        // sdegun el valor de "tipusRegistre" muestra la inforamcion
        switch (tipusRegistre) {
            case 1:
                System.out.println("Tipus de registre: Alta");
                System.out.println("Nif: " + obtenirNifPerFila(fila));
                break;
            case 2:
                System.out.println("Tipus de registre: Canvi de Nom");
                System.out.println("Nif: " + obtenirNifPerFila(fila));
                break;
            case 3:
                System.out.println("Tipus de registre: Baixa");
                break;
            default:
                System.out.println("Tipus de registre: Incorrecte");
                break;
        }
    }

    String obtenirNifPerFila(int fila) {
        return vehicles[fila][ID_NIF_PROPIETARI];
    }

    int obtenirTipusRegistreMatriculaPerFila(int fila) {
        int ret = REGISTRE_TIPUSINEXISTENT;
        //si el valor de la array fila "fila" y columna "ID_TIPUS_REGISTRE" es igual a "A"
        if (vehicles[fila][ID_TIPUS_REGISTRE].equalsIgnoreCase("A")) {
            ret = REGISTRE_ALTA;
        //si el valor de la array fila "fila" y columna "ID_TIPUS_REGISTRE" es igual a "C"
        } else if (vehicles[fila][ID_TIPUS_REGISTRE].equalsIgnoreCase("C")) {
            ret = REGISTRE_COMPRAVENDA;
        //si el valor de la array fila "fila" y columna "ID_TIPUS_REGISTRE" es igual a "B"
        } else if (vehicles[fila][ID_TIPUS_REGISTRE].equalsIgnoreCase("B")) {
            ret = REGISTRE_BAIXA;
        }
        return ret;
    }

}
