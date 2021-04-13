/**
 * @(#) Alarmas.java
 */

package Modelo_de_Implementación;

import java.util.*;
//prueba2
//prueba4
public class Alarmas
{
	public static class idYaExistente extends RuntimeException{}
	public static class noExisteLaAlarmaABorrar extends RuntimeException{}
	private PriorityQueue<Alarma> alarmasActivas = new PriorityQueue<Alarma>();
	private ArrayList<Alarma> alarmasDesactivas = new ArrayList<Alarma>();
	private AlarmasEstado estado;
	private int INTERVALO_SONAR;
	
	/*private Alarma alarmasDesactivas;*/
	
	/*private Alarma alarmasActivas;*/
	
	public Alarma alarma( String id )
	{

		return null;
	}
	
	/**
	 * Añade una nueva alarma preparada para sonar. Retorna true si ese añade y false si no se añade porque ya existe una alarma para la misma Date.
	 * @param alarma - Objeto de la clase alarma
	 * @return booleano que indica si la operación se realizó con exito
	 */
	public boolean anhadeAlarma( Alarma alarma )
	{	
		if (getAlarma(alarma) == false) {
			alarmasActivas.add(alarma);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Elimina una alarma. Retorna true si se eliminó con éxito y false si no se encontró la alarma proporcionada entre las existentes
	 * @param alarma - Objeto de la clase alarma
	 * @return booleano que indica si la operación se realizó con exito
	 */
	//si existe la alarma elimina y devuelve true, sino false
	public boolean eliminaAlarma( Alarma alarma )
	{	
		//busca en alarmas activadas
		if (buscaIdAlarmaActiva(alarma.getId()) == alarma) {
			alarmasActivas.remove(alarma);
			return true;
		}
		//busca en alarmas desactivadas
		else if (buscaIdAlarmaDesactiva(alarma.getId()) == alarma) {
			alarmasDesactivas.remove(alarma);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Devuelve la alarma mas proxima segun su fecha de entre todad las activas o null si no hay alarmas activas
	 * @return La alarma mas proxima o null en caso de no haber ninguna activa
	 */
	@SuppressWarnings("deprecation")
	public Alarma alarmaMasProxima( )				
	{

		Alarma aux= new Alarma("aux", new Date(Integer.MAX_VALUE, 12, 31)); 		//elemento auxiliar
		Alarma proximaAlarma= aux; //elemento auxiliar que guarda la alarma mas proxima en cada vuelta del bucle
		
		//recorrido de la lista en busca de la alarma con el date más bajo
		for(Alarma o: alarmasActivas) {
			if(o.getDate().compareTo(proximaAlarma.getDate())>0) {
				proximaAlarma=o;
			}
		}
		//Si no ha encontrado ninguna más proxima que la mas lejana posible, retorna null
		if(proximaAlarma.equals(aux)) {
			return null;
		}
		
		return proximaAlarma;
	}
	
	
	/**
	 * Desactiva una alarma que se encuentra entre las activas
	 * @param alarma - alarma a desactivar
	 */
	public void desactivaAlarma( Alarma alarma )
	{
		if (alarmasActivas.contains(alarma)) {
			alarmasActivas.remove(alarma);
			alarmasDesactivas.add(alarma);
		}
	}
	
	/**
	 * Activa una alarma que se encuentra entre las desactivas
	 * @param alarma - alarma a activar
	 */
	public void activaAlarma( Alarma alarma )
	{
		if (alarmasDesactivas.contains(alarma)) {
			alarmasDesactivas.remove(alarma);
			alarmasActivas.add(alarma);
		}
	}
	
	/**
	 * Metodo observador de la lista alarmasActivas
	 * @return alarmasActivas
	 */
	public PriorityQueue<Alarma> alarmasActivas( )
	{
		return alarmasActivas;
	}
	
	/**
	 * Metodo observador de la lista alarmasActivas
	 * @return alarmasDesActivas
	 */
	public ArrayList<Alarma> alarmasDesactivas( )
	{
		return alarmasDesactivas;
	}
	
	
	public void activarMelodía( )
	{
		//TODO
	}
	
	public void desactivarMelodía( )
	{
		//TODO
	}
	

	
	 /**
	  * Crea una alarma y la activa por defecto
	  * @param id - String que indica la id de la alarma a crear
	  * @param date - Fecha de la alarma
	  * @param contexto
	  */
	public void nuevaAlarma( String id, Date date) throws idYaExistente
	{
		
		
		//booleano que indica si ya existe otra alarma con esa id
		boolean existe=false;
				
		for(Alarma o: alarmasActivas) {
			if(o.getId().equals(id)) {
				existe=true;
			}
		}
		for(Alarma o: alarmasDesactivas) {
			if(o.getId().equals(id)) {
				existe=true;
			}
		}
		if(!existe) {
			Alarma alarma= new Alarma(id, date);
			alarmasActivas.add(alarma);
		}else {
			throw new idYaExistente();
		}
	
		
	}
	
	/**
	 * Borra la alarma correspondiente a el id otorgado
	 * @param id - String que indica la id de la alarma a borrar
	 * @param contexto
	 */
	public void borraAlarma( String id) throws noExisteLaAlarmaABorrar
	{
		boolean borrado= false;
		for(Alarma o: alarmasActivas) {
			if(o.getId().equals(id)) {

				borrado=alarmasActivas.remove(o);
			}
		}
		if(!borrado) {
			for(Alarma o: alarmasDesactivas) {
				if(o.getId().equals(id)) {
					borrado=alarmasDesactivas.remove(o);
				}
			}
		}
		if(!borrado) {
			throw new noExisteLaAlarmaABorrar();
		}
		
	}
	
	public void alarmaOn( String id)
	{
		//TODO
	}
	
	public void alarmaOff( String id)
	{
		//TODO
	}
	
	public void apagar()
	{
		//TODO
	}
	
	public void setEstado(AlarmasEstado estado) {
		this.estado=estado;
	}
	
	
	//busca si hay una alarma a la Date de la Alarma "a"
	private boolean getAlarma(Alarma a) {
		//busco en las alarmas activas
		for (Alarma o : alarmasActivas) {
			if (a.getDate().equals(o.getDate())) {
				return true;
			}
		}
		//busco en las alarmas desactivas
		for (Alarma o : alarmasDesactivas) {
			if (a.getDate().equals(o.getDate())) {
				return true;
			}
		}
		
		return false;
	}
	
	//busca el id de "a" en "alarmas"
	public Alarma buscaIdAlarmaActiva(String id) {
		for (Alarma o : alarmasActivas) {
			if (id.equals(o.getId())) {
				return o;
			}
		}
		return null;
	}
	
	public Alarma buscaIdAlarmaDesactiva(String id) {
		//busco en las alarmas desactivas
		for (Alarma o : alarmasDesactivas) {
			if (id.equals(o.getId())) {
				return o;
			}
		}
		return null;
	}
	/**
	 * Metodo observador del atributo INTERVALO_SONAR
	 * @return INTERVALO_SONAR
	 */
	public int getINTERVALO_SONAR() {
		return INTERVALO_SONAR;
	}
}
