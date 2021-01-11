package Arrays;

public class Arrays {

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
    static final int MATRICULA_EXISTENT = -2;
    static final String MSG_MATRICULA_EXISTENT = "Aquesta matrícula ja existeix";
    static final String MSG_MATRICULA_INEXISTENT = "Aquesta matrícula no existeix";

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
        Arrays prg = new Arrays();
        prg.menu();
    }

    void menu() {
        boolean calSortir = false;
        char opcio;
        do {
            util.mostrarTex("\n1. Mostrar vehiculos");
            util.mostrarTex("2. Buscar vehiculos");
            util.mostrarTex("3. Agregar vehiculos");
            util.mostrarTex("4. Contar vehiculos");
            util.mostrarTex("0. Sortir de l'aplicació");
            opcio = demanarOpcioMenu();
            switch (opcio) {
                case '1':
                    mostrarArray();
                    break;
                case '2':
                    buscarVehicle();
                    mostrarArray();
                    break;
                case '3':
                    afegirVehicle();
                    mostrarArray();
                    break;
                case '4':
                    ContarVehicles();
                    break;
                case '0':
                    calSortir = true;
            }
        } while (!calSortir);
    }

    char demanarOpcioMenu() {

        String resp;
        resp = util.entrarTex("Esculliu una opció (1,2,3,4 o 0) i premeu [ENTRAR]: ");

        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    void mostrarArray() {
        //muestra los campos de la array fila por fila
        System.out.println("MATRICULA\tTIPV\tTIPREG\tPROPIETARI");
        for (int i = 0; i < vehicles.length; i++) {
            util.mostrarTex(vehicles[i][ID_MATRICULA] + "\t\t" + vehicles[i][ID_TIPUS_VEHICLE] + "\t" + vehicles[i][ID_TIPUS_REGISTRE] + "\t" + vehicles[i][ID_NIF_PROPIETARI]);
        }
    }

    private void buscarVehicle() {
        boolean calSortir = false;
        char opcio;
        do {
            util.mostrarTex("\n1. Per DNI");
            util.mostrarTex("2. Per matricula");
            util.mostrarTex("3. Per tipus");
            util.mostrarTex("0. Sortir de l'aplicació");
            opcio = demanarOpcioMenu();
            switch (opcio) {
                case '1':
                    mostrarPerDni();
                    break;
                case '2':
                    mostrarPerMatricula();
                    break;
                case '3':
                    mostrarPerTipus();
                    break;
                case '0':
                    calSortir = true;
            }
        } while (!calSortir);
    }

    private void mostrarPerDni() {
        String dni = util.entrarTex("Introduce el DNI: ");
        int fila = 0;
        boolean trobat = false;
        while (!trobat && fila < vehicles.length) {
            if (vehicles[fila][ID_NIF_PROPIETARI].equals(dni)) {
                trobat = true;
            } else {
                ++fila;
            }
        }
        if (!trobat) {
            fila = MATRICULA_INEXISTENT;
        }
        mostrarArrayFila(fila);
    }

    private void mostrarPerMatricula() {
        boolean trobat = false;
        String matricula = util.entrarTex("Introduce el Matricula: ");
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i][ID_MATRICULA].equalsIgnoreCase(matricula)) {
                mostrarArrayFila(i);
                trobat = true;
            }
        }
        if (!trobat) {
            util.mostrarTex(MSG_MATRICULA_INEXISTENT);
        }
    }

    private void mostrarPerTipus() {
        String tv = util.entrarTex("Introduce el tipus Vehicle: (MO/CO/CA)");
        String tr = util.entrarTex("Introduce el tipus Registre: (A/B/C)");
        CriterisCercaVehicles criteris = new CriterisCercaVehicles();
        criteris.tipusVehicle = tv;
        criteris.tipusRegistre = tr;
        mostrarVehiclesTipusVehicleRegistre(criteris);
    }

    private void afegirVehicle() {
        // Función que sirve para introducir un vehículo nuevo en la array
        String matricula = util.entrarTex("Matricula: "); // Llama al método de lectura
        int fila = obtenirFilaPerMatricula(matricula); // Llama la función que obtiene fila de la matricula si esta no existe cumple la condición 
        if (fila == MATRICULA_INEXISTENT) {
            String tipusVehicle = util.entrarTex("Tipus de vehicle (CO/MO/CA): ");
            String nifPropietari = util.entrarTex("Nif: ");
            Vehicle vehicle = new Vehicle();
            vehicle.matricula = matricula;
            vehicle.tipusVehicle = tipusVehicle;
            vehicle.tipusRegistre = "A";
            vehicle.nifPropietari = nifPropietari;
            afegirVehicle(vehicle);
        } else { // Si no cumple la condición muestra el siguiente mensaje
            util.mostrarTex(MSG_MATRICULA_EXISTENT);
        }
    }

    private void ContarVehicles() {
        int contador = 0;
        String tv = util.entrarTex("Introduce el tipus Vehicle: (MO/CO/CA): ");
        String tr = util.entrarTex("Introduce el tipus Registre: (A/B/C): ");
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i][ID_TIPUS_VEHICLE].equalsIgnoreCase(tv) && (vehicles[i][ID_TIPUS_REGISTRE].equalsIgnoreCase(tr))){
                contador++;
            }
        }
        String text= contador+"";
        util.mostrarTex(text);

    }

    void mostrarArrayFila(int fila) {
        //muestra los campos de la array fila por fila
        System.out.println("MATRICULA\tTIPV\tTIPREG\tPROPIETARI");
        util.mostrarTex(vehicles[fila][ID_MATRICULA] + "\t\t" + vehicles[fila][ID_TIPUS_VEHICLE] + "\t" + vehicles[fila][ID_TIPUS_REGISTRE] + "\t" + vehicles[fila][ID_NIF_PROPIETARI]);
    }

    void mostrarVehiclesTipusVehicleRegistre(CriterisCercaVehicles criteris) {

        // Usamos el método mostrarTex de la librería creada Utils para mostrar el texto por pantalla de sistema
        util.mostrarTex("\nTipus Vehicle: " + criteris.tipusVehicle + " Tipus Registre: " + criteris.tipusRegistre);

        // Con el for recorremso la array
        for (int i = 0; i < vehicles.length; i++) {

            // comprobmoas se tipusVehicle y tipusRegistre son iguales a el contenido de la array en i
            if (vehicles[i][ID_TIPUS_VEHICLE].equals(criteris.tipusVehicle) && vehicles[i][ID_TIPUS_REGISTRE].equals(criteris.tipusRegistre)) {

                // Si tipusRegistre es igual a el carácter B muestra el contenido de la columna de MATRICULA
                if (criteris.tipusRegistre.equals("B")) {

                    util.mostrarTex("Matricula: " + vehicles[i][ID_MATRICULA]);

                    // Si no es igual a el carácter B muestra el contenido de la columna de MATRICULA y el contenido de la columna PROPIETARI
                } else {

                    util.mostrarTex("Matricula: " + vehicles[i][ID_MATRICULA] + " Nif: " + vehicles[i][ID_NIF_PROPIETARI]);

                }

            }

        }

    }

    int afegirVehicle(Vehicle vehicle) {

        boolean trobat = false;
        int fila = 0;
        int ret = VEHICLE_NO_AFEGIT;

        // Esta función busca una fila vaciá en la array y si la encentra rellena la fila con los datos de Vehicle
        while (fila < vehicles.length && !trobat) { // Mientras fila sea menor que el tamaño de la array y “trobat” sea false cumple la condición 

            if (vehicles[fila][ID_MATRICULA].isEmpty()) { // Si el campo matricula esta vació cumple la condición 
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

    int obtenirFilaPerMatricula(String matricula) {
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
}
