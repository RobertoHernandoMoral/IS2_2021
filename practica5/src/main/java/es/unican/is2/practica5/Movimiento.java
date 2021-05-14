package es.unican.is2.practica5;

import java.time.LocalDateTime;

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