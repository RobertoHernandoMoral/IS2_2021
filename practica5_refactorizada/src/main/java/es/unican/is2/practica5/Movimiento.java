package es.unican.is2.practica5;

import java.time.LocalDateTime;

/*
 * METRICAS:
 * 
 * WMC: 0 (notas en el codigo)
 * CBO: -AFF (N�mero de clases que dependen de la clase analizada):0
 * 		-EFF (N�mero de clases de los que la clase depende):0
 * DIT (En una jerarqu�a de clases, longitud m�xima desde una subclase hasta la clase ra�z): 0
 * NOC (N�mero de subclases inmediatas de una clase dada): 0
 * CCog: 0 (notas en el codigo)
 */

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	public double getImporte() {
		return mImporte;
	}

	public String getConcepto() {
		return mConcepto;
	}

	public void setConcepto(String newMConcepto) {
		mConcepto = newMConcepto;
	}

	public LocalDateTime getFecha() {
		return mFecha;
	}

	public void setFecha(LocalDateTime newMFecha) {
		mFecha = newMFecha;
	}

	public void setImporte(double newMImporte) {
		mImporte = newMImporte;
	}
}