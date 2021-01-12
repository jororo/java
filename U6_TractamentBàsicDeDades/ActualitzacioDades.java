/*
Feu un programa que serveixi com a editor de fitxers orientats a byte que 
contingui només enters. Aquest s’ha de comportar de la manera següent. En i
niciar la seva execució, ha de preguntar a l’usuari quin fitxer vol editar, de 
manera que aquest pugui escriure el nom usant el teclat. Llavors, ha de mostrar 
el contingut del fitxer per pantalla, distribuït en files de 10 valors. No cal 
que formateu la sortida en columnes ben proporcionades. Si el fitxer no existia, 
se’n crea un de nou i, en aquest cas, no apareix cap valor, ja que el fitxer és 
buit.

Tot just després dels valors, el programa espera que l’usuari escrigui una 
comanda, d’entre les següents:

a valor: afegir aquest valor al final del fitxer.
d posició: esborrar el valor que hi ha en aquesta posició, comptant que el 
primer valor es considera en la posició 0. Ara hi ha un valor menys al fitxer.
x: el programa acaba.
 */
package U6_TractamentBàsicDeDades;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ActualitzacioDades {

    public static void main(String[] args) {
        ActualitzacioDades programa = new ActualitzacioDades();
        programa.inici();
    }

    public void inici() {
        try {
            //Es llegeix de teclat ruta del fitxer
            Scanner teclat = new Scanner(System.in);
            System.out.print("Escriu el nom del fitxer a editar: ");
            String origen = teclat.nextLine();
            File fitxer = new File(origen);
            RandomAccessFile raf = new RandomAccessFile(fitxer, "rw");

            boolean executar = true;

            while (executar) {
                mostrarFitxer(raf);
                System.out.println("\n-------------");
                System.out.print("Comanda: ");
                //Llegir comanda
                String comanda = teclat.next();
                if ("x".equals(comanda)) {
                    executar = false;
                } else {
                    if ("a".equals(comanda) && teclat.hasNextInt()) {
                        int valor = teclat.nextInt();
                        afegirValor(raf, valor);
                    } else if ("d".equals(comanda) && teclat.hasNextInt()) {
                        int posicio = teclat.nextInt();
                        eliminarValor(raf, posicio);
                    } else {
                        System.out.println("Comanda desconeguda.");
                    }
                }
            }

            raf.close();

        } catch (IOException e) {
            System.out.println("Error accedint al fitxer: " + e);
        }
    }

    /**
     * Mostra el contingut del fitxer per pantalla, escrivint 10 valors per
     * fila. Fixeu-vos que un RandomAccessFile es pot passar com a paràmetre.
     *
     * @param raf Fitxer d'acces relatiu a mostrar
     */
    public void mostrarFitxer(RandomAccessFile raf) {
        try {
            long numEnters = raf.length() / 4;
            //Cal garantir que l'apuntador esta al principi
            raf.seek(0);
            for (long i = 0; i < numEnters; i++) {
                if (i % 10 == 0) {
                    System.out.println();
                }
                int valor = raf.readInt();
                System.out.print(valor + " ");
            }
        } catch (IOException e) {
            System.out.println("Error llegint fitxer: " + e);
        }
    }

    /**
     * A partir d'un fitxer d'enters, afegeix un valor al final.
     *
     * @param raf Fitxer a modificar
     * @param valor Valor a afegir
     */
    public void afegirValor(RandomAccessFile raf, int valor) {
        try {
            long fiFitxer = raf.length();
            raf.seek(fiFitxer);
            raf.writeInt(valor);
        } catch (IOException e) {
            System.out.println("Error modificant fitxer: " + e);
        }
    }

    /**
     * A partir d'un fitxer d'enters, elimina un valor.
     *
     * @param raf Fitxer a modificar
     * @param posicio Posició a esborrar
     */
    public void eliminarValor(RandomAccessFile raf, int posicio) {
        try {
            if ((posicio >= raf.length() / 4) || (posicio < 0)) {
                System.out.println("Aquesta posició no existeix.");
            } else {
                long midaFinal = raf.length() - 4;
                //Per esborrar un valor, cal desplaçar tots els posteriors a sobre
                //de l'anterior valor.
                long posMoure = (posicio + 1) * 4;
                while (posMoure < raf.length()) {
                    raf.seek(posMoure);
                    int valor = raf.readInt();
                    raf.seek(posMoure - 4);
                    raf.writeInt(valor);
                    posMoure = posMoure + 4;
                }
                //Queda el darrer valor repetit. Cal ajustar la nova mida del fitxer
                raf.setLength(midaFinal);
            }
        } catch (IOException e) {
            System.out.println("Error modificant fitxer: " + e);
        }
    }

}
