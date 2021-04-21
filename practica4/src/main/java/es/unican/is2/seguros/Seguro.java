package es.unican.is2.seguros;

import java.time.LocalDate;

public class Seguro {
	
	

	@SuppressWarnings("serial")
	public static class ClienteNoValidoException extends RuntimeException {
	}
	
	@SuppressWarnings("serial")
	public static class PotenciaIncorrectaException extends RuntimeException {
	}

	public enum Cobertura {TERCEROS, TODORIESGO, TERCEROSLUNAS};
	
	//atributos
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
	
	private static final double NIVEL_DE_SINIESTRALIDAD1=200.0;
	private static final double NIVEL_DE_SINIESTRALIDAD2=50.0;
	
	
	
	
	
	//constructor
	public Seguro(int potencia, Cliente cliente, Cobertura cobertura) throws ClienteNoValidoException, PotenciaIncorrectaException  {
		if(potencia<=0) {
			throw new PotenciaIncorrectaException();
		}
		if(cliente==null) {
			throw new ClienteNoValidoException();
		}
		
		this.potenciaCV=potencia;
		this.tomadorSeguro=cliente;
		this.cobertura=cobertura;
		
	
	}
	
	//metodos
	public double precio() {
		
		
		switch(cobertura){
		case TERCEROS:
			
		}
		return 1.1;
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
	
}
