package EAC6_P2_LLIURABLE;

public class Main {
    Utils utils = new Utils();
    AsxM03b2Eac6P2 asxM03b2Eac6P2 = new AsxM03b2Eac6P2();

    public static void main(String[] args) {
        Main programa = new Main();
        programa.inici();
    }

    void inici() {
        long momentInicial;
        long momentFinal;
        String idAlumne;
        String nomAlumne;
        String nivell;
        String model;
        
        utils.mostrarTitols("MECAPREN", "Identificació i selecció del model");
        
        idAlumne = utils.entrarText("Escriu el teu identificador (4 dígits): ");
        nomAlumne = asxM03b2Eac6P2.obtenirNomAlumne(idAlumne);
        nivell = asxM03b2Eac6P2.obtenirNivell(idAlumne);
        
        model = asxM03b2Eac6P2.seleccionarModel(idAlumne);
        
        momentInicial = System.currentTimeMillis()/1000;
        asxM03b2Eac6P2.realitzarProva(idAlumne, nivell, model);
        momentFinal = System.currentTimeMillis()/1000;
        asxM03b2Eac6P2.calcularIMostrarResultats(idAlumne, nomAlumne, nivell, model, (int) (momentFinal-momentInicial));
    }


}
