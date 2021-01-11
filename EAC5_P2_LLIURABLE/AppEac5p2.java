package EAC5_P2_LLIURABLE;

import java.util.Scanner;

public class AppEac5p2 {

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
        {"1111GGH", "CO", "A", "45821635K"},
        {"1122GGH", "MO", "A", "96521138G"},
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
        AppEac5p2 prg = new AppEac5p2();
        prg.inici();
    }

    void inici() {
        CriterisCercaVehicles criteris1 = new CriterisCercaVehicles();
        criteris1.tipusVehicle = "CO";
        criteris1.tipusRegistre = "A";
        mostrarVehiclesTipusVehicleRegistre(criteris1);

        CriterisCercaVehicles criteris2 = new CriterisCercaVehicles();
        criteris2.tipusVehicle = "CA";
        criteris2.tipusRegistre = "C";
        mostrarVehiclesTipusVehicleRegistre(criteris2);

        CriterisCercaVehicles criteris3 = new CriterisCercaVehicles();
        criteris3.tipusVehicle = "MO";
        criteris3.tipusRegistre = "B";
        mostrarVehiclesTipusVehicleRegistre(criteris3);
    }

    void mostrarVehiclesTipusVehicleRegistre(CriterisCercaVehicles criteris) {
        System.out.println("\nTipus Vehicle: " + criteris.tipusVehicle + " Tipus Registre: " + criteris.tipusRegistre);
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i][ID_TIPUS_VEHICLE].equals(criteris.tipusVehicle) && vehicles[i][ID_TIPUS_REGISTRE].equals(criteris.tipusRegistre)) {
                if (criteris.tipusRegistre.equals("B")) {
                    System.out.println("Matricula: " + vehicles[i][ID_MATRICULA]);
                } else {
                    System.out.println("Matricula: " + vehicles[i][ID_MATRICULA] + " Nif: " + vehicles[i][ID_NIF_PROPIETARI]);
                }
            }
        }
    }

}
