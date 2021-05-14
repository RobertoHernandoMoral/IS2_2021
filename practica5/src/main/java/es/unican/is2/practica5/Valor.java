package es.unican.is2.practica5;

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