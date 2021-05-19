package es.unican.is2.practica5;

import static org.junit.Assert.assertEquals;



import java.util.LinkedList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;



public class CuentaValoresTest {
	private CuentaValores sut;

	@Before
	public void inicializa() throws Exception {
		List<Valor> valores = new LinkedList<Valor>();
		valores.add(new Valor("BBVA", 100, 1.20));
		valores.add(new Valor("BancoSantander", 200, 3.45));
		sut = new CuentaValores("794311", valores);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(("794311"), sut.getNumCuenta());
		assertEquals(2, sut.getValores().size());
	}
	
	@Test
	public void testAnhadeValor() {
		sut.anhadeValor(new Valor("Telepizza", 25, 1.05));
		assertEquals(3, sut.getValores().size());
	}
}
