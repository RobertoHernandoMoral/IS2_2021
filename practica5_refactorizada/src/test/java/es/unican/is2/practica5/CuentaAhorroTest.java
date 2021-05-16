package es.unican.is2.practica5;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.is2.practica5.*;


/*
 * METRICAS:
 * WMC: 2 (notas en el codigo)
 * CBO: -AFF (Número de clases que dependen de la clase analizada):0
 * 		-EFF (Número de clases de los que la clase depende):3
 * DIT (En una jerarquía de clases, longitud máxima desde una subclase hasta la clase raíz): 0
 * NOC (Número de subclases inmediatas de una clase dada): 0
 * CCog: 13 (notas en el codigo)
 */

public class CuentaAhorroTest {
	private CuentaAhorro cuentaAhorro;
	private static Movimiento movimiento1, movimiento2, movimiento3;
	
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
		assertTrue(cuentaAhorro.getCaducidadDebito().equals(LocalDate.now().plusYears(3)));
		assertTrue(cuentaAhorro.getCaducidadCredito().equals(LocalDate.now().plusYears(4)));
		assertTrue(cuentaAhorro.getLimiteDebito()==1000);
		assertTrue(cuentaAhorro.getMovimientos().size()==0);
		assertTrue(cuentaAhorro.getNumCuenta().equals("794311"));
	}
	
	@Test
	public void testGetSaldoYAddMovimiento() {
		assertTrue(cuentaAhorro.getSaldo()==0);	

		cuentaAhorro.addMovimiento(movimiento1);
		assertTrue(cuentaAhorro.getSaldo() == 100);
		
		cuentaAhorro.addMovimiento(movimiento2);
		cuentaAhorro.addMovimiento(movimiento3);
		assertTrue(cuentaAhorro.getSaldo()==1800);
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
			assertTrue(cuentaAhorro.getSaldo()==50);
			assertTrue(cuentaAhorro.getMovimientos().size()==2);
			assertTrue(cuentaAhorro.getMovimientos().get(1).getConcepto().equals("Retirada de efectivo"));
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
			assertTrue(cuentaAhorro.getSaldo()==0.01);
			assertTrue(cuentaAhorro.getMovimientos().size()==1);
			assertTrue(cuentaAhorro.getMovimientos().get(0).getConcepto().equals("Ingreso en efectivo"));
			
			cuentaAhorro.ingresar(100);
			assertTrue(cuentaAhorro.getSaldo()==100.01);
			assertTrue(cuentaAhorro.getMovimientos().size()==2);
			
		} catch (datoErroneoException e) {					//+1
			fail("No debería lanzar la excepción");
		}
		
	}

	
}
