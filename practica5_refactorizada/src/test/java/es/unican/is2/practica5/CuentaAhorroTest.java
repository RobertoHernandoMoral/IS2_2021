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
		assertEquals(cuentaAhorro.getCaducidadDebito(), (LocalDate.now().plusYears(3)));
		assertEquals(cuentaAhorro.getCaducidadCredito(), (LocalDate.now().plusYears(4)));
		assertEquals(cuentaAhorro.getLimiteDebito(), 1000, DELTA);
		assertEquals(cuentaAhorro.getMovimientos().size(), 0, DELTA);
		assertEquals(cuentaAhorro.getNumCuenta(), ("794311"));
	}
	
	@Test
	public void testGetSaldoYAddMovimiento() {
		assertEquals(cuentaAhorro.getSaldo(), 0, DELTA);	

		cuentaAhorro.addMovimiento(movimiento1);
		assertEquals(cuentaAhorro.getSaldo(), 100, DELTA);
		
		cuentaAhorro.addMovimiento(movimiento2);
		cuentaAhorro.addMovimiento(movimiento3);
		assertEquals(cuentaAhorro.getSaldo(),1800,DELTA);
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
			assertEquals(cuentaAhorro.getSaldo(),50,DELTA);
			assertEquals(cuentaAhorro.getMovimientos().size(),2, DELTA);
			assertEquals(cuentaAhorro.getMovimientos().get(1).getConcepto(), ("Retirada de efectivo"));
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
			assertEquals(cuentaAhorro.getSaldo(), 0.01, DELTA);
			assertEquals(cuentaAhorro.getMovimientos().size(),1);
			assertEquals(cuentaAhorro.getMovimientos().get(0).getConcepto(), ("Ingreso en efectivo"));
			
			cuentaAhorro.ingresar(100);
			assertEquals(cuentaAhorro.getSaldo(),100.01, DELTA);
			assertEquals(cuentaAhorro.getMovimientos().size(),2);
			
		} catch (datoErroneoException e) {					//+1
			fail("No debería lanzar la excepción");
		}
		
	}

	
}
