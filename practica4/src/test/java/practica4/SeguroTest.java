package practica4;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import es.unican.is2.seguros.Cliente;
import es.unican.is2.seguros.Seguro;

public class SeguroTest {
	//@Setup
	
	
	@Test
	public void testSeguro() {
		Cliente cliente = new Cliente("pepe", "72088339J", false);
		
		assertTrue(new Seguro(0, cliente, Seguro.Cobertura.TERCEROS) != null);
		assertTrue(new Seguro(10, cliente, Seguro.Cobertura.TERCEROS) != null);
		assertTrue(new Seguro(110, cliente, Seguro.Cobertura.TERCEROS) != null);
		assertTrue(new Seguro(120, cliente, Seguro.Cobertura.TERCEROS) != null);
		/*
		try {
			Seguro s = new Seguro(90, null, Seguro.Cobertura.TERCEROS);
			fail();
		} catch (s) {}
		*/
		
		assertTrue(Double precio > 0);
		
	}
}
