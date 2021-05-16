package es.unican.is2.practica5;

/*
 * METRICAS:
 * 
 * WMC: 0 (notas en el codigo)
 * CBO: -AFF (N�mero de clases que dependen de la clase analizada):1
 * 		-EFF (N�mero de clases de los que la clase depende):0
 * DIT (En una jerarqu�a de clases, longitud m�xima desde una subclase hasta la clase ra�z): 0
 * NOC (N�mero de subclases inmediatas de una clase dada): 2
 * CCog: 0 (notas en el codigo)
 */

public abstract class Cuenta {
	
	private String numCuenta;

	
	public Cuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}
	
	
}
