package es.unican.is2.practica5;

/*
 * METRICAS:
 * 
 * CBO: -AFF (Número de clases que dependen de la clase analizada):4
 * 		-EFF (Número de clases de los que la clase depende):0
 */


@SuppressWarnings("serial")
public class datoErroneoException extends RuntimeException {
	
	public datoErroneoException (String mensaje) {
		super(mensaje);
	}

}
