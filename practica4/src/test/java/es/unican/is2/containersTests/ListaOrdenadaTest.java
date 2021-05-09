package es.unican.is2.containersTests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.*;

import es.unican.is2.containers.ListaOrdenada;
import es.unican.is2.seguros.Cliente;
import es.unican.is2.seguros.Cobertura;
import es.unican.is2.seguros.Seguro;
import es.unican.is2.seguros.Seguro.DatoIncorrectoException;


public class ListaOrdenadaTest {

	private ListaOrdenada<Integer> listaVacia;
	private ListaOrdenada<Integer> lista;
	
	@Before
	public void setup() {
		
		listaVacia= new ListaOrdenada<Integer>();
		redefineLista();
		
	}
	

	@Test
	public void testGet() {
		
		//Prueba a que devuelva el valor correcto con indice valido
		assertTrue(lista.get(2)==5);
		
		//Prueba valores de indices no validos
		try {
			lista.get(-2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La prueba get del indice erroneo es correcta.");
		}
		try {
			lista.get(3);
			fail();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La prueba get 2 del indice erroneo es correcta.");
		}
		
		//Prueba a ejecutarlo si la lista estuviese vacia
		
		try {
			listaVacia.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La prueba get 3 del indice erroneo es correcta.");
		}
		
	}
	
	@Test
	public void testAdd() {
		//Anadimos el tres a la lista, y se tiene que colocar en el indice 2
		lista.add(3);
		assertTrue(lista.get(2)==3);
		
		
		
		//Anadimos el 3 a la lista vacia
		listaVacia.add(3);
		assertTrue(listaVacia.get(0)==3);
		
		
		//Redefinimos la lista para su uso en otros metodos
		redefineLista();
		//limpiamos la lista vacia para su uso en otros test
		listaVacia= new ListaOrdenada<Integer>();
		
	}
	
	@Test
	public void testRemove() {
		//eliminamos un elemento de la lista y comprobamos que el metodo devuelva el que hemos eliminado
		assertTrue(lista.remove(0)==1);
		
		//Comprobamos que la lista ahora no contenga el elemento
		assertTrue(lista.get(0)==2 && lista.get(1)==5);
		
		
		
		try {
			redefineLista();
			lista.remove(-2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La prueba remove del indice erroneo es correcta.");
		}
		try {
			redefineLista();
			lista.remove(3);
			fail();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La prueba remove 2 del indice erroneo es correcta.");
		}
		
		//Prueba a ejecutarlo si la lista estuviese vacia
		
		try {
			listaVacia.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La prueba remove 3 del indice erroneo es correcta.");
		}
		
		//Redefinimos la lista para su uso en otros metodos
		redefineLista();
		//limpiamos la lista vacia para su uso en otros test
		listaVacia= new ListaOrdenada<Integer>();
	}
	
	@Test
	public void testSize() {
		
		assertTrue(lista.size()==3);
		
	}
	
	@Test
	public void testClear() {
		redefineLista();
		lista.clear();
		assertTrue(lista.size()==0);
		
		
	}
	/**
	 * Metodo privado de los test que redefine el ejemplo con el que vamos a trabajar
	 */
	private void redefineLista() {
		lista = new ListaOrdenada<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(5);
	}


}
