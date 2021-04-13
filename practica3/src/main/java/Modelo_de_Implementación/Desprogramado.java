/**
 * @(#) Desprogramado.java
 */

package Modelo_de_Implementación;

import java.util.*;

/**
 * Clase que programa el estado "Desprogramado" del contexto "Alarmas"
 * 
 * @author Roberto Hernando y Eduardo Llamosas
 *
 */
public class Desprogramado extends AlarmasEstado
{
	/**
	 * Crea una nueva alarma en el contexto
	 * @param id
	 * @param hora
	 * @param contexto
	 */
	public void nuevaAlarma( String id, Date hora, Alarmas contexto )
	{
		Alarma a = new Alarma(id, hora);
		if (a != null) {
			contexto.anhadeAlarma(a);
		}
	}
	
	/**
	 * Activa una alarma de la lista de desactivas
	 */
	public void alarmaOn( String id, Alarmas contexto )
	{	
		Alarma a = contexto.buscaIdAlarmaDesactiva(id);
		if (a != null) {
			contexto.activaAlarma(a);
		}
	}
	
	/**
	 * Borra una alarma de la lista de desactivas
	 */
	public void borraAlarma( String id, Alarmas contexto )
	{	
		//busca la alarma en las alarmas descativadas
		Alarma a = contexto.buscaIdAlarmaDesactiva(id);
		if (a != null) {
			contexto.eliminaAlarma(a);
		}
		else {
			//si la alarma no esta desactivada la busca en las alarmas activas
			a = contexto.buscaIdAlarmaActiva(id);
			if (a != null) {
				contexto.eliminaAlarma(a);
			}
			
		}
	}
	
	
}
