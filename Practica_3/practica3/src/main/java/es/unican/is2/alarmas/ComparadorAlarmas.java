package es.unican.is2.alarmas;

import java.util.Comparator;

/**
 * Clase que sirve de comparador para la priority queue en base a el atributo date de alarmas
 * 
 *
 */
/**
*
* @author Roberto Hernando y Eduardo Llamosas
*
*/
public class ComparadorAlarmas implements Comparator<Alarma>{
    
    // Overriding compare()method of Comparator 
                // for descending order of cgpa
    public int compare(Alarma a1, Alarma a2) {
         return a1.getDate().compareTo(a2.getDate());
    }
}