/**
 * @(#) Alarmas.java
 */

package Modelo_de_Implementaci�n;

import java.util.*;

public class Alarmas
{
	private int INTERVALO_SONAR;
	
	private Alarma alarmasDesactivadas;
	
	private Alarma alarmasActivas;
	
	public Alarma alarma( String id )
	{
		return null;
	}
	
	/**
	 * A�ade una nueva alarma preparada para sonar. Retorna true si ese a�ade y false si no se a�ade porque ya existe una alarma para la misma hora.
	 */
	public boolean anhadeAlarma( Alarma a )
	{
		return false;
	}
	
	public boolean eliminaAlarma( Alarma a )
	{
		return false;
	}
	
	public Alarma alarmaMasProxima( )
	{
		return null;
	}
	
	public void desactivaAlarma( Alarma a )
	{
		
	}
	
	public void activaAlarma( Alarma a )
	{
		
	}
	
	public Alarma alarmasActivas( )
	{
		return null;
	}
	
	public Alarma alarmasDesactivadas( )
	{
		return null;
	}
	
	public void activarMelod�a( )
	{
		
	}
	
	public void desactivarMelod�a( )
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
	
	
}
