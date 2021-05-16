package es.unican.is2.practica5;

/*
 * METRICAS:
 * 
 * WMC: 0 (notas en el codigo)
 * CBO: -AFF (N�mero de clases que dependen de la clase analizada):1
 * 		-EFF (N�mero de clases de los que la clase depende):0
 * DIT (En una jerarqu�a de clases, longitud m�xima desde una subclase hasta la clase ra�z): 0
 * NOC (N�mero de subclases inmediatas de una clase dada): 0
 * CCog: 0 (notas en el codigo)
 */

public class Valor {
	
	private String entidad;	
	private int numValores;
	private double cotizacionActual;
	
	public Valor(String entidad, int numValores, double cotizacionActual) {
		super();
		this.entidad = entidad;
		this.numValores = numValores;
		this.cotizacionActual = cotizacionActual;
	}
	
	public int getNumValores() {
		return numValores;
	}

	public void setNumValores(int numValores) {
		this.numValores = numValores;
	}

	public double getCotizacionActual() {
		return cotizacionActual;
	}

	public void setCotizacionActual(double cotizacionActual) {
		this.cotizacionActual = cotizacionActual;
	}

	public String getEntidad() {
		return entidad;
	}


}