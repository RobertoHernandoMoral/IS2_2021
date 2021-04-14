package es.unican.is2.alarmas;

import java.util.TimerTask;

/**
*
* @author Roberto Hernando y Eduardo Llamosas
*
*/
public class RemindTask extends TimerTask {
	//atributo
	private Alarmas contexto;
	
	/**
	 * 
	 * @param contexto
	 */
	public RemindTask(Alarmas contexto) {
		this.contexto = contexto;
	}

	@Override
	public void run() {
		contexto.apagar();

	}

}
