package practica4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.*;
import es.unican.is2.seguros.Cliente;
import es.unican.is2.seguros.Cobertura;
import es.unican.is2.seguros.Seguro;
import es.unican.is2.seguros.Seguro.*;

public class SeguroTest {
	
	private Cliente cliente = new Cliente("Paco", "72688339J", false);
	
	@Before
	public void setup() {
		Cliente cliente = new Cliente("pepe", "72688339J", false);
		
	}
	
	@Test
	public void testSeguro() {
		
		
		
		Seguro s1= new Seguro(10, cliente, Cobertura.TERCEROS);
		assertTrue(s1.getPotenciaCV()==10 && s1.getTomadorSeguro().equals(cliente) && s1.getCobertura()== Cobertura.TERCEROS);
		
		
		try {
			Seguro s = new Seguro(0, null, Cobertura.TERCEROS);
			fail("Deberia de haberse lanzado la excepcion DatoIncorrectoException");
		} catch (DatoIncorrectoException e) {
			System.out.println("Potencia introducida no valida: Valor cero");
		}
		
		try {
			Seguro s = new Seguro(-180, null, Cobertura.TERCEROS);
			fail("Deberia de haberse lanzado la excepcion DatoIncorrectoException");
			
		} catch(DatoIncorrectoException e){
			System.out.println("Potencia introducida no valida: Valor negativo");
		}
		
		try {
			Seguro s = new Seguro(90, null, Cobertura.TERCEROS);
			fail("Deberia de haberse lanzado la excepcion DatoIncorrectoException");
		} catch (DatoIncorrectoException e) {
			System.out.println("El cliente proporcionado no es válido");
		}
		
		
		
		
	}
	
	@Test
	public void testPrecio() {
		
		Seguro s= new Seguro(10, cliente, Cobertura.TERCEROS);
		
		LocalDate fechaActual = LocalDate.now();
		//1 o -1?????
		assertTrue(s.getFechaUltimoSiniestro().compareTo(fechaActual)<=0);
		
		assertTrue(s.getFechaUltimoSiniestro()!=null);
		
		try{
			Double.parseDouble(""+s.precio()+"");
			assertTrue(true);
		} catch (NumberFormatException e) {
			System.out.println("El método precio no devuelve un double");
			fail();
		}
		
		//Caja Blanca
		
		//0<potencia<90
		Seguro s1= new Seguro(50, cliente, Cobertura.TERCEROS);

		//90<potencia<110
		//110<potencia
		//simple+lunas
		//a todo riesgo
		//minusv=true
		//siniestro 2 años
		//siniestro < 1 año
		
	}
}
