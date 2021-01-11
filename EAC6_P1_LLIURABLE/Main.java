package EAC6_P1_LLIURABLE;

public class Main {
    AsxM03b2Eac6P1 asxM03b2Eac6P1 = new AsxM03b2Eac6P1();
    Utils utils = new Utils();

    public static void main(String[] args) {
        Main programa = new Main();
        programa.inici();

    }
    
    void inici() {
        int opcio;
        do{
            utils.mostrarTitols("MECAPREN - PROFESSOR", "Menú principal");
            System.out.println();
            System.out.println("1.- Consultar models d'un nivell");
            System.out.println("2.- moure models entre nivells");
            System.out.println("3.- sortir");
            opcio = utils.entrarUnEnter("Esculliu una opció i premeu [ENTRAR]");
            switch(opcio){
                case 1:
                    pantallaConsultarModelsPerNivell();
                    break;
                case 2:
                    pantallaMoureModelsEntreNivell();
            }
        }while (opcio!=3);
    }
    
    void pantallaConsultarModelsPerNivell(){
        String nivellAConsultar;
        String[] nivells = asxM03b2Eac6P1.obtenirNivells();
        utils.mostrarTitols("MECAPREN - PROFESSOR", "Consulta dels models per nivells");
        nivellAConsultar = utils.seleccionarDeLlista("Escolliu un dels nivells.", nivells);
        utils.mostrarInformacio("Models del nivell "+nivellAConsultar);
        asxM03b2Eac6P1.mostrarModelsNivell(nivellAConsultar);
        utils.entrarPerContinuar();
    }
        
    void pantallaMoureModelsEntreNivell(){
        Utils utils = new Utils();
        String nivellOrigen;
        String nivellDesti;
        String modelAMoure;
        String[] nivells = asxM03b2Eac6P1.obtenirNivells();
        utils.mostrarTitols("MECAPREN - PROFESSOR", "Canvi de nivells dels models");
        nivellOrigen = utils.seleccionarDeLlista("Escolliu el nivell on es troba el model a moure.", nivells);
        System.out.println();
        System.out.println("Els models del nivell "+nivellOrigen+" són:");
        asxM03b2Eac6P1.mostrarModelsNivell(nivellOrigen);
        System.out.println();
        modelAMoure = utils.entrarText("Escriviu el nom del model que voleu moure i premeu [ENTRAR]");
        if(modelAMoure.isEmpty()){
            utils.mostrarAlerta("No heu escrit cap model.");
        }else if(asxM03b2Eac6P1.validarModel(nivellOrigen, modelAMoure)){
            nivellDesti = utils.seleccionarDeLlista("Escolliu el nivell on voleu moure el model escollit.", nivells);
            asxM03b2Eac6P1.moureModel(nivellOrigen, modelAMoure, nivellDesti);
            utils.mostrarInformacio("Model mogut correctament");
        }else{
            utils.mostrarAlerta(String.format("Al nivell %s no hi ha cap model de nom %s", nivellOrigen, modelAMoure));
        }
        utils.entrarPerContinuar();                
    }    
}
