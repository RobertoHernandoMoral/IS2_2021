package Modelo_de_Implementación;


/**
 * @(#) Alarma.java
 */

//prueba3
//prueba5

import java.util.*;

public class Alarma
{
	private String id;
	
	private Date hora;
	
	//constructor
	public Alarma(String id, Date hora) {
		this.id = id;
		this.hora = hora;
	}
	
	//metodos
	public String getId() {
		return id;
	}

	public Date getHora() {
		return hora;
	}

}
