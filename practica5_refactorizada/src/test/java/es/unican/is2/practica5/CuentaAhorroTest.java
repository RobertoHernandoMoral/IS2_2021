package es.unican.is2.practica5;

import java.time.LocalDate;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;





public class CuentaAhorroTest {
	private CuentaAhorro cuentaAhorro;
	private static Movimiento movimiento1, movimiento2, movimiento3;
	private static final double DELTA = 1e-15;
	
	@BeforeClass
	public static void inicializarMovimientos() {
		movimiento1 = new Movimiento();
		movimiento1.setImporte(100);
		movimiento2 = new Movimiento();
		movimiento2.setImporte(200);
		movimiento3 = new Movimiento();
		movimiento3.setImporte(1500);
	}

	@Before
	public void setUpBeforeClass() throws Exception {
		cuentaAhorro = new CuentaAhorro("794311", LocalDate.now().plusYears(3), LocalDate.now().plusYears(4));
	}

	@Test
	public void testConstructor() {
		assertEquals(LocalDate.now().plusYears(3), cuentaAhorro.getCaducidadDebito());
		assertEquals(LocalDate.now().plusYears(4), cuentaAhorro.getCaducidadCredito());
		assertEquals( 1000, cuentaAhorro.getLimiteDebito(), DELTA);
		assertEquals( 0, cuentaAhorro.getMovimientos().size(), DELTA);
		assertEquals(("794311"), cuentaAhorro.getNumCuenta());
	}
	
	@Test
	public void testGetSaldoYAddMovimiento() {
		assertEquals( 0,cuentaAhorro.getSaldo(), DELTA);	

		cuentaAhorro.addMovimiento(movimiento1);
		assertEquals(100, cuentaAhorro.getSaldo(), DELTA);
		
		cuentaAhorro.addMovimiento(movimiento2);
		cuentaAhorro.addMovimiento(movimiento3);
		assertEquals(1800,cuentaAhorro.getSaldo(),DELTA);
	}
	
	@Test
	public void testRetirarSinConcepto() { //CC=1 CCog=9
		
		try { 									//+1
			cuentaAhorro.retirar(-10);
			fail("Debería lanzar DatoErroneoException");
		} catch (datoErroneoException e) {		//+1
		} catch (saldoInsuficienteException e) {	//+1
			fail("Debería lanzar DatoErroneoException");
		}
		
		cuentaAhorro.addMovimiento(movimiento1);
		
		try { 								//+1
			cuentaAhorro.retirar(50);
			assertEquals(50, cuentaAhorro.getSaldo(),DELTA);
			assertEquals(2, cuentaAhorro.getMovimientos().size(), DELTA);
			assertEquals(("Retirada de efectivo"), cuentaAhorro.getMovimientos().get(1).getConcepto());
		} catch (datoErroneoException e) {			//+1
			fail("No debería lanzar DatoErroneoException");
		} catch (saldoInsuficienteException e) {	//+1
			fail("No debería lanzar SaldoInsuficienteException");
		}
		
		
		try {												//+1
			cuentaAhorro.retirar(100);
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
			cuentaAhorro.ingresar(-1);
			fail("Debería lanzar DatoErroneoException");
		} catch (datoErroneoException e) {					//+1
		}

		// Test ingresar el limite
		try {												//+1
			cuentaAhorro.ingresar(0.01);
			assertEquals(0.01 ,cuentaAhorro.getSaldo(), DELTA);
			assertEquals(1, cuentaAhorro.getMovimientos().size());
			assertEquals(("Ingreso en efectivo"), cuentaAhorro.getMovimientos().get(0).getConcepto());
			
			cuentaAhorro.ingresar(100);
			assertEquals(100.01,cuentaAhorro.getSaldo(), DELTA);
			assertEquals(2, cuentaAhorro.getMovimientos().size());
			
		} catch (datoErroneoException e) {					//+1
			fail("No debería lanzar la excepción");
		}
		
	}

	
}
