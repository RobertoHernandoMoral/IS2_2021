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

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return the minusvalia
	 */
	public boolean isMinusvalia() {
		return minusvalia;
	}
}
