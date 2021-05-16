package es.unican.is2.practica5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/*
 * METRICAS:
 * 
 * WMC: 5 (notas en el codigo)
 * CBO: -AFF (Número de clases que dependen de la clase analizada):0
 * 		-EFF (Número de clases de los que la clase depende):1
 * DIT (En una jerarquía de clases, longitud máxima desde una subclase hasta la clase raíz): 1
 * NOC (Número de subclases inmediatas de una clase dada): 0
 * CCog: 6 (notas en el codigo)
 */

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> mMovimientos;
	private LocalDate mFechaDeCaducidadTarjetaDebito;
	private LocalDate mFechaDeCaducidadTarjetaCredito;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta, LocalDate date, LocalDate date2) {
		super(numCuenta);
		this.mFechaDeCaducidadTarjetaDebito = date;
		this.mFechaDeCaducidadTarjetaCredito = date2;
		mMovimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}

	public void ingresar(double x) throws datoErroneoException { //CC=1 CCog=1
		if (x <= 0) //+1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Ingreso en efectivo");
		m.setI(x);
		this.mMovimientos.add(m);
	}

	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException { //CC=1 CCog=1
		if (x <= 0) //+1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		if (getSaldo() < x) //+1
			throw new saldoInsuficienteException("Saldo insuficiente");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Retirada de efectivo");
		m.setI(-x);
		this.mMovimientos.add(m);
	}

	public void ingresar(String concepto, double x) throws datoErroneoException { //CC=1 CCog=1
		if (x <= 0) //+1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC(concepto);
		m.setI(x);
		this.mMovimientos.add(m);
	}

	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException { //CC=1 CCog=2
		if (getSaldo() < x) //+1
			throw new saldoInsuficienteException("Saldo insuficiente");
		if (x <= 0) //+1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC(concepto);
		m.setI(-x);
		this.mMovimientos.add(m);
	}

	public double getSaldo() { //CC=1 CCog=1
		double r = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) { //+1
			Movimiento m = (Movimiento) mMovimientos.get(i);
			r += m.getI();
		}
		return r;
	}

	public void addMovimiento(Movimiento m) {
		mMovimientos.add(m);
	}

	public List<Movimiento> getMovimientos() {
		return mMovimientos;
	}

	public LocalDate getCaducidadDebito() {
		return this.mFechaDeCaducidadTarjetaDebito;
	}

	public LocalDate getCaducidadCredito() {
		return this.mFechaDeCaducidadTarjetaCredito;
	}

	public double getLimiteDebito() {
		return limiteDebito;
	}

}