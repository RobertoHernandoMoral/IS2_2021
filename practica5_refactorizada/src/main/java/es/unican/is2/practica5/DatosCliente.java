package es.unican.is2.practica5;

public class DatosCliente {

	public String nombre;
	public String calle;
	public String zip;
	public String localidad;
	public String telefono;
	public String dni;
	
	
	public DatosCliente(String titular, String calle, String zip, String localidad, 
 			String telefono, String dni) {  
		this.nombre = titular;
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	public void cambiaDireccion(String calle, String zip, String localidad) {
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
}
