/*
 * EAC6 Període 3 Tasca 2
 * ASXM3B2_EAC6P2_Romero_R
 */
package EAC6_P2_LLIURABLE;

/*
 * @author jordi Romero Robles 
 */

// Importamos librerias
import java.io.*;
import java.util.Scanner;

public class AsxM03b2Eac6P2 {

    // Definimos las constates necesarias
    static final int DADES_ALUMNES_MIDA_REGISTRE = Character.BYTES * 36;
    static final int DADES_ALUMNES_DESPLACAMENT_NOM = Character.BYTES * 4;
    static final int DADES_ALUMNES_DESPLACAMENT_NIVELL = Character.BYTES * 34;
    static final String DIRECTORI_NIVELLS = "dades/models";
    static final String DIRECTORI_PROVES = "dades/proves";
    static final String FICHER_ALUMNES = "dades/dadesAlumnes.bin";
    static final String ITEM_MODELS = "- ";
    // Instan-ciamos la case utils
    Utils utils = new Utils();

    public String obtenirNomAlumne(String idAlumne) {
        // Creamos una función para obtener el nombre del alumno buscando la id del alumno

        // Creamos las variables necesarias
        String ret = "";
        // Creamos las variable pos con el String idAlumne convirtiéndolo 
        int pos = Integer.parseInt(idAlumne);
        // Este if comprueba si la variable pos se comprende entre 0 y 99 si no cierra la aplicación
        if (pos >= 0 && pos <= 99) {
            RandomAccessFile dadesAlumnes;
            try {
                dadesAlumnes = new RandomAccessFile(FICHER_ALUMNES, "r");
                dadesAlumnes.seek(pos * DADES_ALUMNES_MIDA_REGISTRE + DADES_ALUMNES_DESPLACAMENT_NOM);
                ret = dadesAlumnes.readUTF();
                dadesAlumnes.close();
            } catch (FileNotFoundException ex) {
                System.out.println("No s'ha pogut trobar el fitxer de dades d'alumnes");
            } catch (IOException ex) {
                System.out.println("Hi ha hagut un error de lectura en el fitxer de dades d'alumnes");
            }
        } else {
            System.out.println("Identificador d'alumne no vàlid");
            System.exit(0);
        }
        return ret;
    }

    public String obtenirNivell(String idAlumne) {
        //Creamos una función para obtener el nivel del alumno buscando la id del alumno

        //Creamos las variables necesarias
        char nivell_1 = 0;
        char nivell_2 = 0;
        int pos = Integer.parseInt(idAlumne);
        //   Instan-ciamos la clase RandomAccessFile para manipular ficheros 
         RandomAccessFile dadesAlumnes;
        try {
            // Creamo el objeto dadesAlumnes
            dadesAlumnes = new RandomAccessFile(FICHER_ALUMNES, "r");
            dadesAlumnes.seek(pos * DADES_ALUMNES_MIDA_REGISTRE + DADES_ALUMNES_DESPLACAMENT_NIVELL);
            nivell_1 = dadesAlumnes.readChar();
            dadesAlumnes.seek(pos * DADES_ALUMNES_MIDA_REGISTRE + DADES_ALUMNES_DESPLACAMENT_NIVELL + 2);
            nivell_2 = dadesAlumnes.readChar();
            dadesAlumnes.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha pogut trobar el fitxer de dades d'alumnes");
        } catch (IOException ex) {
            System.out.println("Hi ha hagut un error de lectura en el fitxer de dades d'alumnes");
        }
        String ret = nivell_1 + "" + nivell_2;
        return ret;
    }

    public String[] obtenirModels(String nivell) {
        //Creamos una función para obtener el nivel del la lista obtenida del directorio
        File obtenirModels = new File(DIRECTORI_NIVELLS, nivell);
        String[] models = obtenirModels.list();
        return models;
    }

    public String seleccionarModel(String idAlumne) {
        //Muestra el listado de niveles del directorio 

        //Creamos las variables necesarias
        String nivell;
        String ret;
        String[] models;
        //Instan-ciamos los siguientes métodos
        nivell = obtenirNivell(idAlumne);
        models = obtenirModels(nivell);
        ret = utils.seleccionarDeLlista("Escolliu el model amb el que voleu practicar", models);
        return ret;
    }

    public void realitzarProva(String idAlumne, String nivell, String model) {
        //Muestra una linea del archivo seleccionado y registra la linea escrita 
        //en la consola de comnado en la linea correspondiente del archivo de salida
        
        //Instan-ciamos un objeto scanner
        Scanner scan = new Scanner(System.in);

        //Creamos las variables necesarias
        String nom_Archiu = idAlumne + "_" + nivell + "_" + model;
        String dir_Model = DIRECTORI_NIVELLS + "/" + nivell + "/" + model;
        String dir_Archiu = DIRECTORI_PROVES + "/" + nom_Archiu;
        utils.mostrarTitols("MECAPREN", model);
       
        //   Instan-ciamos la clase BufferedReader 
        BufferedReader buffer_Lectura;
        BufferedWriter buffer_Escritura;
        PrintWriter pw;
        try {
            buffer_Lectura = new BufferedReader(new FileReader(dir_Model));
            buffer_Escritura = new BufferedWriter(new FileWriter(dir_Archiu));
            pw = new PrintWriter(buffer_Escritura);
            String texto = buffer_Lectura.readLine();
            //Mientras el valor de texto no sea nulo ejecutara el siguiente codigo
            while (texto != null) {
                utils.mostrarInformacio(texto);
                String Introducir_Linea = scan.nextLine();
                pw.println(Introducir_Linea);
                texto = buffer_Lectura.readLine();
            }
            
            buffer_Lectura.close();
            buffer_Escritura.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha pogut trobar el fitxer de dades d'alumnes");
        } catch (IOException ex) {
            System.out.println("Hi ha hagut un error de lectura en el fitxer de dades d'alumnes");
        }
    }

    public void calcularIMostrarResultats(String idAlumne, String nomAlumne, String nivell, String model, int temps) {

        //Creamos las variables necesarias
        int errors = 0;
        int caracters = 0;
        
        // Creamos los objetos file llamado el método correspondiente
        File modelo = obtenirFileDelModel(nivell, model);
        File prueba = obtenirFileDeLaProva(idAlumne, nivell, model);

        try {
            Scanner contingutModel;
            Scanner fitxerDeLaProva;
            contingutModel = new Scanner(modelo);
            fitxerDeLaProva = new Scanner(prueba);
            while (contingutModel.hasNext()) {
                String liniaModel;
                String liniaProva;
                liniaModel = contingutModel.nextLine();
                if (fitxerDeLaProva.hasNextLine()) {
                    liniaProva = fitxerDeLaProva.nextLine();
                    for (int j = 0; j < liniaModel.length(); j++) {
                        if (liniaProva.length() <= j || liniaProva.charAt(j) != liniaModel.charAt(j)) {
                            errors++;
                        }
                    }
                    if (liniaProva.length() > liniaModel.length()) {
                        errors += liniaProva.length() - liniaModel.length();
                    }
                    caracters += liniaProva.length();
                } else {
                    errors += liniaModel.length();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha pogut trobar el fitxer de dades d'alumnes");
        }
        utils.mostrarTitols("MECAPREN", "Resultats de la prova realitzada");
        utils.mostrarInformacio(String.format("Prova de l'alumne %s copiant el model %s del nivell %s", nomAlumne, model, nivell));
        utils.mostrarInformacio(String.format("Has escrit %d caràcters, emprant %d segons i has comés %d errades", caracters, temps, errors));
    }

    public File obtenirFileDelModel(String nivell, String model) {

        //Creamos las variables necesarias
        String dir_Model = DIRECTORI_NIVELLS + "/" + nivell + "/" + model;
        File fileDelModel = new File(dir_Model);
        return fileDelModel;
    }

    public File obtenirFileDeLaProva(String idAlumne, String nivell, String model) {

        //Creamos las variables necesarias
        String nom_Archiu = idAlumne + "_" + nivell + "_" + model;
        String dir_Archiu = DIRECTORI_PROVES + "/" + nom_Archiu;
        File fileDeLaProva = new File(dir_Archiu);
        return fileDeLaProva;
    }

}
