package Modelo_de_Implementación;

import java.util.Comparator;

public class ComparadorAlarmas implements Comparator<Alarma>{
    
    // Overriding compare()method of Comparator 
                // for descending order of cgpa
    public int compare(Alarma a1, Alarma a2) {
         return a1.getDate().compareTo(a2.getDate());
    }
}