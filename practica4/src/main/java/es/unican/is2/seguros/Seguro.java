package es.unican.is2.seguros;

import java.time.LocalDate;

public class Seguro {
	
	//ATRIBUTOS
	private  LocalDate fechaUltimoSiniestro;


	private int potenciaCV;
	private Cliente tomadorSeguro;
	private Cobertura cobertura;
	
	private static final double PRECIOBASE_TERCEROS= 400;
	private static final double PRECIOBASE_TERCEROS_LUNAS= 600;
	private static final double PRECIOBASE_TODO_RIESGO= 1000;
	
	private static final double PORCENTAJE1= 0.05; //Comprendido entre los rangos de 90 a 100 CV ambos inclusives
	private static final double PORCENTAJE2= 0.20; //Para mas de 110
	
	private static final double PORCENTAJE_DESCUENTO_MINUSVALIA=0.25;
	
	private static final double NIVEL_DE_SINIESTRALIDAD1 = 0.0;   //€ que se suman al precio del seguro
	private static final double NIVEL_DE_SINIESTRALIDAD2 = 50.0;  //€ que se suman al precio del seguro
	private static final double NIVEL_DE_SINIESTRALIDAD3 = 200.0; //€ que se suman al precio del seguro
	
	
	//EXCEPCIONES

	@SuppressWarnings("serial")
	public static class DatoIncorrectoException extends RuntimeException {
	}

	//public enum Cobertura {TERCEROS, TODORIESGO, TERCEROSLUNAS};
	
	
	
	
	//CONSTRUCTOR
	public Seguro(int potencia, Cliente cliente, Cobertura cobertura) throws  DatoIncorrectoException  {
		if(potencia<=0) {
			throw new DatoIncorrectoException();
		}
		if(cliente == null) {
			throw new DatoIncorrectoException();
		}
		
		this.potenciaCV=potencia;
		this.tomadorSeguro=cliente;
		this.cobertura=cobertura;
		
		//para simular la fecha de un siniestro hace mas de 3 años
		LocalDate fechaActual = LocalDate.now();
		this.fechaUltimoSiniestro = fechaActual.minusYears(100);
	
	}
	
	//METODOS
	public double precio() {
		
		double precioBase;
		double porcentajePotencia;
		double descuentoMinusvalia;
		double nivelSiniestralidad;
		
		//Asignación del valor base del seguro
		switch(cobertura){
			case TERCEROS:
				precioBase=PRECIOBASE_TERCEROS;
				break;
			case TERCEROS_LUNAS:
				precioBase=PRECIOBASE_TERCEROS_LUNAS;
				break;
			case TODO_RIESGO:
				precioBase=PRECIOBASE_TODO_RIESGO;
				break;
			default:
				precioBase=PRECIOBASE_TERCEROS;
				break;
		}
		
		//Asignacion del porcentaje por potencia del coche
		if (potenciaCV<90) {
			porcentajePotencia=1.0;
		}else if(potenciaCV<=110) {
			porcentajePotencia=1.0+PORCENTAJE1;
		}else {
			porcentajePotencia=1.0+PORCENTAJE2;
		}
		
		//Asignacion de nivel de siniestralidad
		LocalDate fechaActual = LocalDate.now();
		if(fechaUltimoSiniestro.isBefore(fechaActual.minusYears(3))) {
			nivelSiniestralidad= NIVEL_DE_SINIESTRALIDAD1;
		}else if(fechaUltimoSiniestro.isBefore(fechaActual.minusYears(1))){
			nivelSiniestralidad= NIVEL_DE_SINIESTRALIDAD2;			
		}else {
			nivelSiniestralidad= NIVEL_DE_SINIESTRALIDAD3;
		}
		
		//Asignacion de porcentaje de descuento por minusvalia
		if(tomadorSeguro.isMinusvalia()) {
			descuentoMinusvalia=1.0-PORCENTAJE_DESCUENTO_MINUSVALIA;
		} else {
			descuentoMinusvalia=1.0;
		}
		 
		return ((precioBase*porcentajePotencia)+nivelSiniestralidad)*descuentoMinusvalia;
	}

	/**
	 * @return the potenciaCV
	 */
	public int getPotenciaCV() {
		return potenciaCV;
	}

	/**
	 * @return the tomadorSeguro
	 */
	public Cliente getTomadorSeguro() {
		return tomadorSeguro;
	}

	/**
	 * @return the cobertura
	 */
	public Cobertura getCobertura() {
		return cobertura;
	}

	/**
	 * @return the fechaUltimoSiniestro
	 */
	public LocalDate getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}

	/**
	 * @param fechaUltimoSiniestro the fechaUltimoSiniestro to set
	 */
	public void setFechaUltimoSiniestro(LocalDate fechaUltimoSiniestro) {
		this.fechaUltimoSiniestro = fechaUltimoSiniestro;
	}
	
}
