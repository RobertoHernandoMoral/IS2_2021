package es.unican.is2.seguros;

import java.time.LocalDate;

public class Seguro {

	//atributos
	private  LocalDate fechaUltimoSiniestro;
	private int potenciaCV;
	
	public enum Cobertura {TERCEROS, TODORIESGO, TERCEROSLUNAS};
	
	//constructor
	public Seguro(int potencia, Cliente cliente, Cobertura cobertura) {
		
	}
	
	//metodos
	public double precio() {
		//TODO 
		return 1.1;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}
	
}
