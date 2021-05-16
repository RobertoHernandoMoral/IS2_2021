package es.unican.is2.practica5;

/*
 * METRICAS:
 * WMC: 0 (notas en el codigo)
 * CBO: -AFF (N�mero de clases que dependen de la clase analizada):0
 * 		-EFF (N�mero de clases de los que la clase depende):0
 * DIT (En una jerarqu�a de clases, longitud m�xima desde una subclase hasta la clase ra�z): 1
 * NOC (N�mero de subclases inmediatas de una clase dada): 0
 * CCog: 0 (notas en el codigo)
 */

@SuppressWarnings("serial")
public class saldoInsuficienteException extends RuntimeException {

	public saldoInsuficienteException (String mensaje) {
		super(mensaje);
	}
}
