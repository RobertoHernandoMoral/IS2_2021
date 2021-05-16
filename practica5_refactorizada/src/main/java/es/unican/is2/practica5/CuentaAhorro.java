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

	public CuentaAhorro(String numCuenta, LocalDate mFechaDeCaducidadTarjetaDebito, LocalDate mFechaDeCaducidadTarjetaCredito) {
		super(numCuenta);
		this.mFechaDeCaducidadTarjetaDebito = mFechaDeCaducidadTarjetaDebito;
		this.mFechaDeCaducidadTarjetaCredito = mFechaDeCaducidadTarjetaCredito;
		mMovimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}

	public void ingresar(double importe) throws datoErroneoException { //CC=1 CCog=1
		if (importe <= 0) //+1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento movimiento = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		movimiento.setFecha(now);
		movimiento.setConcepto("Ingreso en efectivo");
		movimiento.setImporte(importe);
		this.mMovimientos.add(movimiento);
	}

	public void retirar(double importe) throws saldoInsuficienteException, datoErroneoException { //CC=1 CCog=1
		if (importe <= 0) //+1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		if (getSaldo() < importe) //+1
			throw new saldoInsuficienteException("Saldo insuficiente");
		Movimiento movimiento = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		movimiento.setFecha(now);
		movimiento.setConcepto("Retirada de efectivo");
		movimiento.setImporte(-importe);
		this.mMovimientos.add(movimiento);
	}

	public void ingresar(String concepto, double importe) throws datoErroneoException { //CC=1 CCog=1
		if (importe <= 0) //+1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento movimiento = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		movimiento.setFecha(now);
		movimiento.setConcepto(concepto);
		movimiento.setImporte(importe);
		this.mMovimientos.add(movimiento);
	}

	public void retirar(String concepto, double importe) throws saldoInsuficienteException, datoErroneoException { //CC=1 CCog=2
		if (getSaldo() < importe) //+1
			throw new saldoInsuficienteException("Saldo insuficiente");
		if (importe <= 0) //+1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		Movimiento movimiento = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		movimiento.setFecha(now);
		movimiento.setConcepto(concepto);
		movimiento.setImporte(-importe);
		this.mMovimientos.add(movimiento);
	}

	public double getSaldo() { //CC=1 CCog=1
		double total = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) { //+1
			Movimiento movimiento = (Movimiento) mMovimientos.get(i);
			total += movimiento.getImporte();
		}
		return total;
	}

	public void addMovimiento(Movimiento movimiento) {
		mMovimientos.add(movimiento);
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