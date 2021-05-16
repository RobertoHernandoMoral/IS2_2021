package es.unican.is2.practica5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/*
 * METRICAS:
 * 
 * WMC: 4 (notas en el codigo)
 * CBO: -AFF (Número de clases que dependen de la clase analizada):0
 * 		-EFF (Número de clases de los que la clase depende):1
 * DIT (En una jerarquía de clases, longitud máxima desde una subclase hasta la clase raíz): 1
 * NOC (Número de subclases inmediatas de una clase dada): 0
 * CCog: 5 (notas en el codigo)
 */

public class Credito extends Tarjeta {
	
	private static final double  COMISION= 0.05;
	private double mCredito;
	private List<Movimiento> mMovimientosMensuales;
	private List<Movimiento> mhistoricoMovimientos;
	
	
	public Credito(String numero, String titular, CuentaAhorro cuentaAhorro, double credito) {
		super(numero, titular, cuentaAhorro);
		mCredito = credito;
		mMovimientosMensuales = new LinkedList<Movimiento>();
		mhistoricoMovimientos = new LinkedList<Movimiento>();
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param importe Cantidad a retirar. Se aplica una comisión del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	@Override
	public void retirarDinero(double importe) throws saldoInsuficienteException, datoErroneoException { //CC=1 CCog=1
		if (importe<0) //+1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		
		Movimiento movimiento = new Movimiento("Retirada en cajero automático", LocalDateTime.now(), -importe );
		
		importe += importe * COMISION; // Añadimos una comisión de un 5%

		
		if (getGastosAcumulados()+importe > mCredito) //+1
			throw new saldoInsuficienteException("Crédito insuficiente");
		else { //+1
			mMovimientosMensuales.add(movimiento);
		}
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double importe) throws saldoInsuficienteException, datoErroneoException { //CC=1 CCog=1
		if (importe<0) { //+1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		}
		if (getGastosAcumulados() + importe > mCredito) { //+1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		Movimiento movimiento = new Movimiento("Compra a crédito en: " + datos, LocalDateTime.now(), importe);
		mMovimientosMensuales.add(movimiento);
	}
	
    public double getGastosAcumulados() { //CC=1 CCog=1
		double total = 0.0;
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) { //+1
			Movimiento movimiento = (Movimiento) mMovimientosMensuales.get(i);
			total += movimiento.getImporte();
		}
		return -total;
	}
	
	
	public LocalDate getCaducidadCredito() {
		return this.mCuentaAsociada.getCaducidadCredito();
	}

	/**
	 * Método que se invoca automáticamente el día 1 de cada mes
	 */
	public void liquidar() { //CC=1 CCog=2
		
		double total= -this.getGastosAcumulados();
		Movimiento liquidacion = new Movimiento("Liquidación de operaciones tarjeta crédito", LocalDateTime.now(), total);
	
		if (total != 0) { //+1
			mCuentaAsociada.addMovimiento(liquidacion);
		}
		mhistoricoMovimientos.addAll(mMovimientosMensuales);
		mMovimientosMensuales.clear();
	}

	public List<Movimiento> getMovimientosUltimoMes() {
		return mMovimientosMensuales;
	}
	
	public Cuenta getCuentaAsociada() {
		return mCuentaAsociada;
	}
	
	public List<Movimiento> getMovimientos() {
		return mhistoricoMovimientos;
	}

}