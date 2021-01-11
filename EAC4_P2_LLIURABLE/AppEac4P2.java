package EAC4_P2_LLIURABLE;

import java.util.Scanner;

public class AppEac4P2 {

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

    String[][] vehicles = {
        //MATRICULA TIPV  TIPREG  PROPIETARI
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
        AppEac4P2 prg = new AppEac4P2();
        prg.inici();
    }

    void inici() {

        boolean calSortir = false;
        char opcio;
        //muestra menu continuo mientras que calSortir sea verdadero
        do {
            System.out.println("");
            System.out.println("1. Compra Venda vehicle");
            System.out.println("2. Baixa vehicle");
            System.out.println("0. Sortir de l'aplicació");

            opcio = demanarOpcioMenu();
            switch (opcio) {
                case '1':
                    compraVenda();
                    break;
                case '2':
                    baixaVehicle();
                    break;
                case '0':
                    calSortir = true;
            }
        } while (!calSortir);
    }

    char demanarOpcioMenu() {

        String resp;
        System.out.println("Esculliu una opció (1,2 o 0) i premeu [ENTRAR].");
        resp = scanner.nextLine();
        //si "resp" esta vacio introduce un valor en blanco en "resp"
        if (resp.isEmpty()) {
            resp = " ";
        }
        //deculve el primero valro del string "resp" con la funcion "charAt(0)"
        //charAt(indice) es una funcion de String que devuelve el caracter ubicado en la posicion indice de la cadena
        return resp.charAt(0);
    }

    void baixaVehicle() {
        String matricula;
        String nif;
        String nifMatricula;
        int fila;
        //Nos pide la matricual por consola de sistema
        System.out.println("Matricula: ");
        matricula = scanner.nextLine();
        // Nos devulve la fila de la matricual introducida con al siguinte funcion 
        fila = obtenirFilaPerMatricula(matricula);
        if (fila == MATRICULA_INEXISTENT) {
            System.out.println("Aquesta matricula no existeix");
        } else if (obtenirTipusRegistreMatriculaPerFila(fila) == REGISTRE_BAIXA) {
            System.out.println("Aquesta matricula ja està donada de baixa");
        } else {
            System.out.println("Nif: ");
            nif = scanner.nextLine();
            nifMatricula = obtenirNifPerFila(fila);
            if (nif.equalsIgnoreCase(nifMatricula)) {
                vehicles[fila][ID_TIPUS_REGISTRE] = "B";
                vehicles[fila][ID_NIF_PROPIETARI] = "";
            } else {
                System.out.println("El nif que has entrat no és el nif del propietari");
            }
        }
    }

    void compraVenda() {
        String matricula;
        String nif;
        String nifVenedor;
        String nifComprador;
        int fila;
        System.out.println("Matricula: ");
        matricula = scanner.nextLine();
        fila = obtenirFilaPerMatricula(matricula);
        if (fila == MATRICULA_INEXISTENT) {
            System.out.println("Aquesta matricula no existeix");
        } else if (obtenirTipusRegistreMatriculaPerFila(fila) == REGISTRE_BAIXA) {
            System.out.println("Aquesta matricula està donada de baixa");
        } else {
            System.out.println("Nif del venedor: ");
            nif = scanner.nextLine();
            nifVenedor = obtenirNifPerFila(fila);
            if (nif.equalsIgnoreCase(nifVenedor)) {
                System.out.println("Nif del comprador: ");
                nifComprador = scanner.nextLine();
                if (nifVenedor.equalsIgnoreCase(nifComprador)) {
                    System.out.println("El nif del comprador és el mateix que el del comprador");
                } else {
                    vehicles[fila][ID_TIPUS_REGISTRE] = "C";
                    vehicles[fila][ID_NIF_PROPIETARI] = nifComprador;
                }
            } else {
                System.out.println("El nif que has entrat no és el nif del propietari");
            }
        }
    }

    void mostrarPosicioMatricula(String matricula, int fila) {
        System.out.print("La matricula: ");
        System.out.print(matricula);
        if (fila == MATRICULA_INEXISTENT) {
            System.out.println(" no existeix");
        } else {
            System.out.print(" es troba a la posició o fila ");
            System.out.println(fila);
        }
    }

    void mostrarInformacio(int fila) {
        int tipusRegistre;
        if (fila == MATRICULA_INEXISTENT) {
            return;
        }
        tipusRegistre = obtenirTipusRegistreMatriculaPerFila(fila);
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
        if (vehicles[fila][ID_TIPUS_REGISTRE].equalsIgnoreCase("A")) {
            ret = REGISTRE_ALTA;
        } else if (vehicles[fila][ID_TIPUS_REGISTRE].equalsIgnoreCase("C")) {
            ret = REGISTRE_COMPRAVENDA;
        } else if (vehicles[fila][ID_TIPUS_REGISTRE].equalsIgnoreCase("B")) {
            ret = REGISTRE_BAIXA;
        }
        return ret;
    }

    
    int obtenirFilaPerMatricula(String matricula) {
    // Esta funcion no devuelve la fila que corresponde a la matricula 
        int fila = 0;
        boolean trobat = false;
        // mientras trobat sea falso y fila sea menos que la fila maxima de la array vehicles ejecutara lo siguinte
        while (!trobat && fila < vehicles.length) {
            
            //Si el valor de la matricual de la array para la pocicion indicada es igual a "matricula"
            if (vehicles[fila][ID_MATRICULA].equals(matricula)) {
                //trobat es verdadewro
                trobat = true;
            } else {
                //si no se suma 1 a "fila"
                ++fila;
            }
        }
        //si despues de terminarl while "trobat" es falso da a fila el valro al constante MATRICULA_INEXISTENT
        if (!trobat) {
            fila = MATRICULA_INEXISTENT;
        }
        return fila;
    }

}
