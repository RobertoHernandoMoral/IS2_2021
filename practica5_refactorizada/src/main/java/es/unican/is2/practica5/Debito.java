package es.unican.is2.practica5;

import java.time.LocalDate;

/*
 * METRICAS:
 * 
 * WMC: 2 (notas en el codigo)
 * CBO: -AFF (Número de clases que dependen de la clase analizada):0
 * 		-EFF (Número de clases de los que la clase depende):1
 * DIT (En una jerarquía de clases, longitud máxima desde una subclase hasta la clase raíz): 1
 * NOC (Número de subclases inmediatas de una clase dada): 0
 * CCog: 2 (notas en el codigo)
 */

public class Debito extends Tarjeta {
	
	private double saldoDiarioDisponible;

	public Debito(String numero, String titular, CuentaAhorro cuentaAhorro) {
		super(numero, titular, cuentaAhorro);
	}
	
	
	@Override
	public void retirarDinero(double importe) throws saldoInsuficienteException, datoErroneoException { //CC=1 CCog=1
		if (saldoDiarioDisponible<importe) { //+1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Retirada en cajero automático", importe);
		saldoDiarioDisponible-=importe;
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double importe) throws saldoInsuficienteException, datoErroneoException { //CC=1 CCog=1
		if (saldoDiarioDisponible<importe) { //+1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Compra en : " + datos, importe);
		saldoDiarioDisponible-=importe;
	}
	
	public LocalDate getCaducidadDebito() {
		return this.mCuentaAsociada.getCaducidadDebito();
	}
	
	/**
	 * Método invocado automáticamente a las 00:00 de cada día
	 */
	public void restableceSaldo() {
		saldoDiarioDisponible = mCuentaAsociada.getLimiteDebito();
	}
	
	public CuentaAhorro getCuentaAsociada() {
		return mCuentaAsociada;
	}

}