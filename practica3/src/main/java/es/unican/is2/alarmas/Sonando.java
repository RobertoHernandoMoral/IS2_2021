/**
 * @(#) Sonando.java
 */

package es.unican.is2.alarmas;
import java.util.Timer;

/**
 *
 * @author Roberto Hernando y Eduardo Llamosas
 *
 */
public class Sonando extends AlarmasEstado
{	
	Timer timer = new Timer();
	
	/**
	 * Apaga una alarma
	 */
	public void apagar( Alarmas contexto ) {
		timer.cancel();
		this.exitAction(contexto);
		contexto.setEstado(getEstadoProgramado());
		getEstadoProgramado().entryAction(contexto);
		getEstadoProgramado().doAction(contexto);
	}
	
	/**
	 * 
	 */
	public void entryAction ( Alarmas contexto ) {
		timer = new Timer();
		contexto.activarMelodía();
		timer.schedule(new RemindTask(contexto), contexto.getINTERVALO_SONAR()*1000);
	}
	
	/**
	 * 
	 */
	public void exitAction ( Alarmas contexto ) {
		contexto.desactivarMelodía();
	}
	

	
	
}
