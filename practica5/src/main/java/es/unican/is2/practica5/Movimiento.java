package es.unican.is2.practica5;

import java.time.LocalDateTime;

/*
 * METRICAS:
 * 
 * WMC: 0 (notas en el codigo)
 * CBO: -AFF (Número de clases que dependen de la clase analizada):2
 * 		-EFF (Número de clases de los que la clase depende):0
 * DIT (En una jerarquía de clases, longitud máxima desde una subclase hasta la clase raíz): 0
 * NOC (Número de subclases inmediatas de una clase dada): 0
 * CCog: 0 (notas en el codigo)
 */

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	public double getI() {
		return mImporte;
	}

	public String getC() {
		return mConcepto;
	}

	public void setC(String newMConcepto) {
		mConcepto = newMConcepto;
	}

	public LocalDateTime getF() {
		return mFecha;
	}

	public void setF(LocalDateTime newMFecha) {
		mFecha = newMFecha;
	}

	public void setI(double newMImporte) {
		mImporte = newMImporte;
	}
}