package es.unican.is2.practica5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.is2.practica5.CuentaValores;
import es.unican.is2.practica5.Valor;


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
		assertEquals(sut.getNumCuenta(), ("794311"));
		assertTrue(sut.getValores().size()==2);
	}
	
	@Test
	public void testAnhadeValor() {
		sut.anhadeValor(new Valor("Telepizza", 25, 1.05));
		assertTrue(sut.getValores().size()==3);
	}
}
