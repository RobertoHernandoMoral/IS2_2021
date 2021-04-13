/**
 * @(#) Programado.java
 */

package es.unican.is2.alarmas;

import java.util.*;

/**
*
* @author Roberto Hernando y Eduardo Llamosas
*
*/
public class Programado extends AlarmasEstado
{	
	
	/**
	 * Anhade una alarma 
	 * @param id
	 * @param hora
	 * @param contexto
	 */
	public void nuevaAlarma( String id, Date hora, Alarmas contexto )
	{
		Alarma a = new Alarma(id, hora);
		if(a != null) {
			contexto.anhadeAlarma(a);
		}
	}
	/**
	 * Borra una alarma 
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
				if (contexto.alarmasActivas() == null ) {
					contexto.getEstado().exitAction(contexto);
					contexto.setEstado(desprogramado);;
					contexto.getEstado().entryAction(contexto);
					contexto.getEstado().doAction(contexto);
				}
	}
	
	/**
	 * Activa una alarma
	 */
	public void alarmaOn( String id, Alarmas contexto )
	{
		Alarma a = contexto.buscaIdAlarmaDesactiva(id);
		if (a != null) {
			contexto.activaAlarma(a);
		}
	}
	
	
	/**
	 * Desctiva una alarma
	 */
	public void alarmaOff( String id, Alarmas contexto )
	{
		Alarma a = contexto.buscaIdAlarmaActiva(id);
		if (a != null) {
			contexto.desactivaAlarma(a);
		}
		contexto.getEstado().exitAction(contexto);
		contexto.setEstado(desprogramado);;
		contexto.getEstado().entryAction(contexto);
		contexto.getEstado().doAction(contexto);
	}
	
	
}
