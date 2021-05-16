package es.unican.is2.practica5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/*
 * METRICAS:
 * 
 * WMC: 3 (notas en el codigo)
 * CBO: -AFF (Número de clases que dependen de la clase analizada):1
 * 		-EFF (Número de clases de los que la clase depende):1
 * DIT (En una jerarquía de clases, longitud máxima desde una subclase hasta la clase raíz): 1
 * NOC (Número de subclases inmediatas de una clase dada): 0
 * CCog: 3 (notas en el codigo)
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

	public void ingresar(double importe) throws datoErroneoException { //CC=0 CCog=0
		compruebaImporteNegativo(importe);

		this.mMovimientos.add(new Movimiento("Ingreso en efectivo", LocalDateTime.now(),importe));
	}

	public void retirar(double importe) throws saldoInsuficienteException, datoErroneoException { //CC=0 CCog=0
		compruebaImporteNegativo(importe);
		compruebaSaldoInsuficiente(importe);
		

		this.mMovimientos.add(new Movimiento("Retirada de efectivo",LocalDateTime.now(),importe));
	}

	public void ingresar(String concepto, double importe) throws datoErroneoException { //CC=0 CCog=0
		compruebaImporteNegativo(importe);
		
		this.mMovimientos.add(new Movimiento(concepto,LocalDateTime.now(),importe));
	}

	public void retirar(String concepto, double importe) throws saldoInsuficienteException, datoErroneoException { //CC=0 CCog=0
		compruebaSaldoInsuficiente(importe);
		compruebaImporteNegativo(importe);
		
		this.mMovimientos.add(new Movimiento(concepto,LocalDateTime.now(),importe));
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

	/**
	 * Comprueba si el importe es negativo y lanza una excepcion si es asi
	 * @param importe
	 * @throws datoErroneoException
	 */
	private void compruebaImporteNegativo(double importe) throws datoErroneoException{ //CC=1 Ccog=1
		if (importe <= 0) //+1
			throw new datoErroneoException("No se puede operar con una cantidad negativa");
	}
	
	private void compruebaSaldoInsuficiente(double saldo) throws saldoInsuficienteException{ //CC=1 Ccog=1
		if (getSaldo() < saldo) //+1
			throw new saldoInsuficienteException("Saldo insuficiente");
	}
}