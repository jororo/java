package EAC5_P3_LLIURABLE;

public class AppEac5p3 {
    static final int ID_MATRICULA = 0;
    static final int ID_TIPUS_VEHICLE = 1;
    static final int ID_TIPUS_REGISTRE = 2;
    static final int ID_NIF_PROPIETARI = 3;
    static final int MATRICULA_INEXISTENT = -1;
    static final int REGISTRE_ALTA = 1;
    static final int REGISTRE_COMPRAVENDA = 2;
    static final int REGISTRE_BAIXA = 3;
    static final int REGISTRE_TIPUSINEXISTENT = -1;
    static final int VEHICLE_NO_AFEGIT = -1;
    static final int VEHICLE_AFEGIT = 1;

    Utils util = new Utils();

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
        {"5018KAC", "MO", "C", "66620000U"},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""}};

    public static void main(String[] args) {
        AppEac5p3 prg = new AppEac5p3();
        prg.inici();
    }

    void inici() {
        boolean calSortir = false;
        char opcio;
        do {
            util.mostrarTex("\n1. Vehicle nou");
            util.mostrarTex("2. Compra Venda vehicle");
            util.mostrarTex("3. Baixa vehicle");
            util.mostrarTex("4. Cerca vehicles per tipus de vehicle i registre");
            util.mostrarTex("0. Sortir de l'aplicació");
            opcio = demanarOpcioMenu();
            switch (opcio) {
                case '1':
                    vehicleNou();
                    break;
                case '2':
                    compraVenda();
                    break;
                case '3':
                    baixaVehicle();
                    break;
                case '4':
                    cercaVehicles();
                    break;
                case '0':
                    calSortir = true;
            }
        } while (!calSortir);
    }

    char demanarOpcioMenu() {
        String resp;
        resp = util.entrarTex("Esculliu una opció (1,2,3,4 o 0) i premeu [ENTRAR].");
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    void vehicleNou() {
        int fila;
        String msg;
        String matricula;
        String tipusVehicle;
        String nif;
        matricula = util.entrarTex("Matricula: ");
        msg = util.validarMatricula(matricula);
        if (msg.equals("")) {
            fila = obtenirFilaPerMatricula(matricula);
            if (fila == MATRICULA_INEXISTENT) {
                tipusVehicle = util.entrarTex("Tipus de vehicle: ");
                nif = util.entrarTex("Nif: ");
                Vehicle vehicle = new Vehicle();
                vehicle.matricula = matricula;
                vehicle.tipusVehicle = tipusVehicle;
                vehicle.tipusRegistre = "A";
                vehicle.nifPropietari = nif;
                if (afegirVehicle(vehicle) == VEHICLE_AFEGIT) {
                    util.mostrarTex("El vehicle s'ha afegit correctament");
                } else {
                    util.mostrarTex("El vehicle no s'ha pogut");
                }
            } else {
                util.mostrarTex("Aquesta matricula ja existeix");
            }
        } else {
            util.mostrarTex(matricula + ": " + msg);
        }
    }

    void cercaVehicles() {
        String tipusVehicle;
        String tipusRegistre;

        tipusVehicle = util.entrarTex("Tipus de vehicle: ");
        tipusRegistre = util.entrarTex("Tipus de registre: ");
        CriterisCercaVehicles criteris1 = new CriterisCercaVehicles();
        criteris1.tipusVehicle = tipusVehicle;
        criteris1.tipusRegistre = tipusRegistre;
        mostrarVehiclesTipusVehicleRegistre(criteris1);
    }

    void baixaVehicle() {
        String matricula;
        String nif;
        String nifMatricula;
        String msg;
        int fila;
        matricula = util.entrarTex("Matricula: ");
        msg = util.validarMatricula(matricula);
        if (msg.equals("")) {
            fila = obtenirFilaPerMatricula(matricula);
            if (fila == MATRICULA_INEXISTENT) {
                util.mostrarTex("Aquesta matricula no existeix");
            } else if (obtenirTipusRegistreMatriculaPerFila(fila) == REGISTRE_BAIXA) {
                util.mostrarTex("Aquesta matricula ja està donada de baixa");
            } else {
                nif = util.entrarTex("Nif: ");
                nifMatricula = obtenirNifPerFila(fila);
                if (nif.equalsIgnoreCase(nifMatricula)) {
                    vehicles[fila][ID_TIPUS_REGISTRE] = "B";
                    vehicles[fila][ID_NIF_PROPIETARI] = "";
                } else {
                    System.out.println("El nif que has entrat no és el nif del propietari");
                }
            }
        } else {
            System.out.println(matricula + ": " + msg);
        }
    }

    void compraVenda() {
        String matricula;
        String nif;
        String nifVenedor;
        String nifComprador;
        String msg;
        int fila;
        matricula = util.entrarTex("Matricula: ");
        msg = util.validarMatricula(matricula);
        if (msg.equals("")) {
            fila = obtenirFilaPerMatricula(matricula);
            if (fila == MATRICULA_INEXISTENT) {
                System.out.println("Aquesta matricula no existeix");
            } else if (obtenirTipusRegistreMatriculaPerFila(fila) == REGISTRE_BAIXA) {
                System.out.println("Aquesta matricula està donada de baixa");
            } else {
                nif = util.entrarTex("Nif del venedor: ");
                nifVenedor = obtenirNifPerFila(fila);
                if (nif.equalsIgnoreCase(nifVenedor)) {
                    nifComprador = util.entrarTex("Nif del comprador: ");
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
        } else {
            System.out.println(matricula + ": " + msg);
        }

    }

    void mostrarPosicioMatricula(String matricula, int fila
    ) {
        System.out.print("La matricula: " + matricula);
        if (fila == MATRICULA_INEXISTENT) {
            util.mostrarTex(" no existeix");
        } else {
            System.out.print(" es troba a la posició o fila ");
            util.mostrarTex(String.valueOf(fila));
        }
    }

    void mostrarInformacio(int fila
    ) {
        int tipusRegistre;
        if (fila == MATRICULA_INEXISTENT) {
            return;
        }
        tipusRegistre = obtenirTipusRegistreMatriculaPerFila(fila);
        switch (tipusRegistre) {
            case 1:
                util.mostrarTex("Tipus de registre: Alta");
                util.mostrarTex("Nif: " + obtenirNifPerFila(fila));
                break;
            case 2:
                util.mostrarTex("Tipus de registre: Canvi de Nom");
                util.mostrarTex("Nif: " + obtenirNifPerFila(fila));
                break;
            case 3:
                util.mostrarTex("Tipus de registre: Baixa");
                break;
            default:
                util.mostrarTex("Tipus de registre: Incorrecte");
                break;
        }
    }

    String obtenirNifPerFila(int fila
    ) {
        return vehicles[fila][ID_NIF_PROPIETARI];
    }

    int obtenirTipusRegistreMatriculaPerFila(int fila
    ) {
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

    int obtenirFilaPerMatricula(String matricula
    ) {
        int fila = 0;
        boolean trobat = false;
        while (!trobat && fila < vehicles.length) {
            if (vehicles[fila][ID_MATRICULA].equals(matricula)) {
                trobat = true;
            } else {
                ++fila;
            }
        }
        if (!trobat) {
            fila = MATRICULA_INEXISTENT;
        }
        return fila;
    }

    void mostrarVehiclesTipusVehicleRegistre(CriterisCercaVehicles criteris
    ) {
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

    int afegirVehicle(Vehicle vehicle) {
        boolean trobat = false;
        int fila = 0;
        int ret = VEHICLE_NO_AFEGIT;
        while (fila < vehicles.length && !trobat) {
            if (vehicles[fila][ID_MATRICULA].equals("")) {
                vehicles[fila][ID_MATRICULA] = vehicle.matricula;
                vehicles[fila][ID_TIPUS_VEHICLE] = vehicle.tipusVehicle;
                vehicles[fila][ID_TIPUS_REGISTRE] = vehicle.tipusRegistre;
                vehicles[fila][ID_NIF_PROPIETARI] = vehicle.nifPropietari;
                trobat = true;
                ret = VEHICLE_AFEGIT;
            }
            fila++;
        }
        return ret;
    }

}
