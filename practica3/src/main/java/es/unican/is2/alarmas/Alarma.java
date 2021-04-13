package es.unican.is2.alarmas;


/**
 * @(#) Alarma.java
 */

//prueba3
//prueba5
/**
*
* @author Roberto Hernando y Eduardo Llamosas
*
*/
import java.util.*;

public class Alarma
{
	private String id;
	
	private Date date;
	
	//constructor
	public Alarma(String id, Date date) {
		this.id = id;
		this.date = date;
	}
	
	//observadores
	public String getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

}
