package EAC6_P1_LLIURABLE;

import java.io.File;
import java.util.Arrays;

public class AsxM03b2Eac6P1 {

    static final String DADESDIR = "dades/models";

    String[] obtenirNivells() {
        // Creamos la array ret
        String[] ret;
        // Creamos un objeto con la clase File que guarda la ruta para poder interactuar con los ficheros del directorio.
        File models = new File(DADESDIR);
        // Utilizamos el método list que nos lo pone en un array
        ret = models.list();
        // Usamos el método "sort" de la clase "Arrays" para ordenar el contenido del array por orden alfabetico
        Arrays.sort(ret);
        // Retornamos la array
        return ret;
    }

    void mostrarModelsNivell(String nivellAConsultar) {

        // Creamos un objeto con la clase File que guarda la ruta para poder interactuar con los ficheros del directorio.
        File nivell = new File(DADESDIR, nivellAConsultar);
        // Metodo que devuelve el contenido del directorio del objeto nivells.
        File[] models = nivell.listFiles();
        // Ahora hacemos un recorrido en el array y mostramos el nombre        
        for (int i = 0; i < models.length; i++) {
            // getName(): Método que devuelve el nombre del fichero o directorio
            System.out.println(models[i].getName());
        }
    }

    boolean validarModel(String nivell, String model) {

        boolean ret = false;
        String xFichero = DADESDIR + "/" + nivell + "/" + model;
        File fichero = new File(xFichero);
        // Comprobamos que el directorio y el fichero sean correctos comprobado si esites el fichero en la ruta especificada
        if (fichero.exists()) {
            ret = true;
        }
        return ret;

    }

    void moureModel(String nivellOrigen, String model, String nivellDesti) {

        // Creamos un objeto con la clase File con la ruta que guarda en la constante
        File dadesDir = new File(DADESDIR);
        // Creamos un objeto con la clase File con al ruta origen
        File dirNivellOrigen = new File(dadesDir, nivellOrigen);
        // Creamos un objeto con la clase File con al ruta destino
        File dirNiivellDesti = new File(dadesDir, nivellDesti);
        // Creamos un objeto con la clase File con al ruta del fichero de origen
        File fileModelOrigen = new File(dirNivellOrigen, model);
        // Creamos un objeto con la clase File con al ruta del fichero de destino
        File fileMoodelDesti = new File(dirNiivellDesti, model);
        // En el fichero intercambiamos la ruta a la que pertenece de origen por al de destino a niveld e configuracion
        fileModelOrigen.renameTo(fileMoodelDesti);

    }

}
