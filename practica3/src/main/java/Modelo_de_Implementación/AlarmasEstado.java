/**
 * @(#) AlarmasEstado.java
 */

package Modelo_de_Implementación;

import java.util.*;

//seria abstracta
public abstract class AlarmasEstado
{
	//Estados de la Alarma
	public static Programado programado = new Programado();
	public static Desprogramado desprogramado = new Desprogramado();
	public static Sonando sonando = new Sonando();
	
	//Metodos abstractos para programar en las clases hijas
	public void nuevaAlarma( String id, Date hora, Alarma contexto ) {};
	public void borraAlarma( String id, Alarmas contexto ) {};
	public void alarmaOn( String id, Alarmas contexto ) {};
	public void alarmaOff( String id, Alarmas contexto ) {};
	public void apagar( Alarmas contexto ) {};
	
	public void entryAction (Alarmas contexto) {};
	public void exitAction (Alarmas contexto) {};
	public void doAction (Alarmas contexto) {};
	
	public static AlarmasEstado crear (Alarma contexto) {
		//estadoDesprogramado.entryAction(context);
		return desprogramado;
	}
	
	public static AlarmasEstado getEstadoProgramado () {
		return programado;
	}
	
	public static AlarmasEstado getEstadoSonando () {
		return sonando;
	}
	
	/*private Modelo_de_Implementación.Alarmas estado;*/
	
	/*public void nuevaAlarma( String id, Date hora, Alarma contexto )
	{
		Alarma a = new Alarma(id, hora);
		
	}*/
	
	/*public void borraAlarma( String id, Alarmas contexto )
	{
		
	}*/
	
	/*public void alarmaOn( String id, Alarmas contexto )
	{
		
	}*/
	
	/*public void alarmaOff( String id, Alarmas contexto )
	{
		
	}*/
	
	/*public void apagar( Alarmas contexto )
	{
		
	}*/
	
	
}
