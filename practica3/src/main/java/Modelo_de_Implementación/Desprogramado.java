/**
 * @(#) Desprogramado.java
 */

package Modelo_de_Implementación;

import java.util.*;


public class Desprogramado extends AlarmasEstado
{
	public void nuevaAlarma( String id, Date hora, Alarmas contexto )
	{
		Alarma a = new Alarma(id, hora);
		if (a != null) {
			contexto.anhadeAlarma(a);
		}
	}
	
	public void alarmaOn( String id, Alarmas contexto )
	{	
		Alarma a = contexto.buscaIdAlarmaDesactiva(id);
		if (a != null) {
			contexto.activaAlarma(a);
		}
	}
	
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
