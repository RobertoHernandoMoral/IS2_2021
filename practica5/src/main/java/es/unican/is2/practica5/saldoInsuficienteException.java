package es.unican.is2.practica5;

/*
 * METRICAS:
 * 
 * CBO: -AFF (Número de clases que dependen de la clase analizada):4
 * 		-EFF (Número de clases de los que la clase depende):0
 */

@SuppressWarnings("serial")
public class saldoInsuficienteException extends RuntimeException {

	public saldoInsuficienteException (String mensaje) {
		super(mensaje);
	}
}
