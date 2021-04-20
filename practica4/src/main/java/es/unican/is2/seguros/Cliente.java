package es.unican.is2.seguros;

public class Cliente {
	
	//atributos
	private String nombre;
	private String dni;
	private boolean minusvalia;
	
	//constructor
	public Cliente(String nombre, String dni, boolean minusvalia) {
		this.dni = dni;
		this.nombre = nombre;
		this.minusvalia = minusvalia;
	}
}
