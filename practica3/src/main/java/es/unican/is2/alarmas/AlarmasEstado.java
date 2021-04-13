/**
 * @(#) AlarmasEstado.java
 */
/**
*
* @author Roberto Hernando y Eduardo Llamosas
*
*/
package es.unican.is2.alarmas;

import java.util.*;

//seria abstracta
public abstract class AlarmasEstado
{
	//Estados de la Alarma
	public static Programado programado = new Programado();
	public static Desprogramado desprogramado = new Desprogramado();
	public static Sonando sonando = new Sonando();
	
	public void entryAction (Alarmas contexto) {};
	public void exitAction (Alarmas contexto) {};
	public void doAction (Alarmas contexto) {};
	
	public static AlarmasEstado crear (Alarma contexto) {
	
		return desprogramado;
	}
	
	public static AlarmasEstado getEstadoProgramado () {
		return programado;
	}
	
	public static AlarmasEstado getEstadoSonando () {
		return sonando;
	}
	
	
	//Metodos para las clases hijas:
	
	public void nuevaAlarma( String id, Date hora, Alarma contexto )
	{
		
	}
	
	public void borraAlarma( String id, Alarmas contexto )
	{
		
	}
	
	public void alarmaOn( String id, Alarmas contexto )
	{
		
	}
	
	public void alarmaOff( String id, Alarmas contexto )
	{
		
	}
	
	public void apagar( Alarmas contexto )
	{
		
	}
	
	
}
