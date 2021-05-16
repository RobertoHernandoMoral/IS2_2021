package es.unican.is2.practica5;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.is2.practica5.*;




public class CuentaAhorroTest {
	private CuentaAhorro sut;
	private static Movimiento m1, m2, m3;
	
	@BeforeClass
	public static void inicializarMovimientos() {
		m1 = new Movimiento();
		m1.setI(100);
		m2 = new Movimiento();
		m2.setI(200);
		m3 = new Movimiento();
		m3.setI(1500);
	}

	@Before
	public void setUpBeforeClass() throws Exception {
		sut = new CuentaAhorro("794311", LocalDate.now().plusYears(3), LocalDate.now().plusYears(4));
	}

	@Test
	public void testConstructor() {
		assertTrue(sut.getCaducidadDebito().equals(LocalDate.now().plusYears(3)));
		assertTrue(sut.getCaducidadCredito().equals(LocalDate.now().plusYears(4)));
		assertTrue(sut.getLimiteDebito()==1000);
		assertTrue(sut.getMovimientos().size()==0);
		assertTrue(sut.getNumCuenta().equals("794311"));
	}
	
	@Test
	public void testGetSaldoYAddMovimiento() {
		assertTrue(sut.getSaldo()==0);	

		sut.addMovimiento(m1);
		assertTrue(sut.getSaldo() == 100);
		
		sut.addMovimiento(m2);
		sut.addMovimiento(m3);
		assertTrue(sut.getSaldo()==1800);
	}
	
	@Test
	public void testRetirarSinConcepto() { //CC=1 CCog=9
		
		try { 									//+1
			sut.retirar(-10);
			fail("Debería lanzar DatoErroneoException");
		} catch (datoErroneoException e) {		//+1
		} catch (saldoInsuficienteException e) {	//+1
			fail("Debería lanzar DatoErroneoException");
		}
		
		sut.addMovimiento(m1);
		
		try { 								//+1
			sut.retirar(50);
			assertTrue(sut.getSaldo()==50);
			assertTrue(sut.getMovimientos().size()==2);
			assertTrue(sut.getMovimientos().get(1).getC().equals("Retirada de efectivo"));
		} catch (datoErroneoException e) {			//+1
			fail("No debería lanzar DatoErroneoException");
		} catch (saldoInsuficienteException e) {	//+1
			fail("No debería lanzar SaldoInsuficienteException");
		}
		
		
		try {												//+1
			sut.retirar(100);
			fail("Debería lanzar SaldoInsuficienteException");
		} catch (datoErroneoException e) {								//+1
			fail("Debería lanzar SaldoInsuficienteException");
		} catch (saldoInsuficienteException e) {						//+1
			
		}
	
	}
	
	@Test
	public void testIngresarSinConcepto () { //CC=1 Ccog= 4
	
		// Test ingresar negativo
		try {												//+1
			sut.ingresar(-1);
			fail("Debería lanzar DatoErroneoException");
		} catch (datoErroneoException e) {					//+1
		}

		// Test ingresar el limite
		try {												//+1
			sut.ingresar(0.01);
			assertTrue(sut.getSaldo()==0.01);
			assertTrue(sut.getMovimientos().size()==1);
			assertTrue(sut.getMovimientos().get(0).getC().equals("Ingreso en efectivo"));
			
			sut.ingresar(100);
			assertTrue(sut.getSaldo()==100.01);
			assertTrue(sut.getMovimientos().size()==2);
			
		} catch (datoErroneoException e) {					//+1
			fail("No debería lanzar la excepción");
		}
		
	}

	
}
