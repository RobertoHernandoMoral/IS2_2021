/**
 * @(#) Alarmas.java
 */

package Modelo_de_Implementación;

import java.util.*;
//prueba2
//prueba4
public class Alarmas
{
	
	private ArrayList<Alarma> alarmasActivas = new ArrayList<Alarma>();
	private ArrayList<Alarma> alarmasDesactivadas = new ArrayList<Alarma>();
	
	private int INTERVALO_SONAR;
	
	/*private Alarma alarmasDesactivadas;*/
	
	/*private Alarma alarmasActivas;*/
	
	public Alarma alarma( String id )
	{
		return null;
	}
	
	/**
	 * Añade una nueva alarma preparada para sonar. Retorna true si ese añade y false si no se añade porque ya existe una alarma para la misma hora.
	 */
	public boolean anhadeAlarma( Alarma a )
	{	
		if (getAlarma(a) == false) {
			alarmasActivas.add(a);
			return true;
		}
		else {
			return false;
		}
			}
	
	//si existe la alarma elimina y devuelve true, sino false
	public boolean eliminaAlarma( Alarma a )
	{
		if (buscaIdAlarmaActiva(a.getId()) == a) {
			alarmasActivas.remove(a);
			return true;
		}
		else if (buscaIdAlarmaDesactiva(a.getId()) == a) {
			alarmasDesactivadas.remove(a);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//CREO QUE DEBERIA DE SER UNA COLA
	public Alarma alarmaMasProxima( )
	{
		//return alarmasActivas.peek;
		return null;
	}
	
	public void desactivaAlarma( Alarma a )
	{
		if (alarmasActivas.contains(a)) {
			alarmasActivas.remove(a);
			alarmasDesactivadas.add(a);
		}
	}
	
	public void activaAlarma( Alarma a )
	{
		if (alarmasDesactivadas.contains(a)) {
			alarmasDesactivadas.remove(a);
			alarmasActivas.add(a);
		}
	}
	
	public Alarma alarmasActivas( )
	{
		return null;
	}
	
	public Alarma alarmasDesactivadas( )
	{
		return null;
	}
	
	public void activarMelodía( )
	{
		
	}
	
	public void desactivarMelodía( )
	{
		
	}
	
	public void nuevaAlarma( String id, Date hora, Alarmas contexto )
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
	
	
	//busca si hay una alarma a la hora de la Alarma "a"
	private boolean getAlarma(Alarma a) {
		//busco en las alarmas activas
		for (Alarma o : alarmasActivas) {
			if (a.getHora().equals(o.getHora())) {
				return true;
			}
		}
		//busco en las alarmas desactivas
		for (Alarma o : alarmasDesactivadas) {
			if (a.getHora().equals(o.getHora())) {
				return true;
			}
		}
		
		return false;
	}
	
	//busca el id de "a" en "alarmas"
	public Alarma buscaIdAlarmaActiva(String id) {
		for (Alarma o : alarmasActivas) {
			if (id.equals(o.getId())) {
				return o;
			}
		}
		return null;
	}
	
	public Alarma buscaIdAlarmaDesactiva(String id) {
		//busco en las alarmas desactivas
		for (Alarma o : alarmasDesactivadas) {
			if (id.equals(o.getId())) {
				return o;
			}
		}
		return null;
	}
}
