/*
Descripción
Divide una cadena cada vez que encuentra un delimitador que coincida con la expresión regular pasada como parámetro.

Sintaxis
public String[] split(String regex)
public String[] split(String regex, int limit)

Parametros
regex, rexpresión regular que queremos utilizar como delimitador
limit, cuantas veces queremos ejecutar la división teniendo en cuenta la expresión regular.
 */
package U4_Activitats_text;

public class Split {

    public static void main(String[] args) {
        
        String sCiudades = "Avila#02Madrid#03Toledo#04Santander";
        String[] items = sCiudades.split("#0[0-9]");
        
        for (String item : items) {
            System.out.println(item);
        }
        
    }
}
