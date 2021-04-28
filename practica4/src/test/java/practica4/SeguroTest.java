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
		
		assertTrue(s1.precio()==400.0);

		//90<potencia<110
		Seguro s2= new Seguro(100, cliente, Cobertura.TERCEROS);
		
		assertTrue(s2.precio()==420.0);
		//110<potencia
		Seguro s3= new Seguro(120, cliente, Cobertura.TERCEROS);
		
		assertTrue(s3.precio()==480.0);
		//simple+lunas
		Seguro s4= new Seguro(120, cliente, Cobertura.TERCEROS_LUNAS);
		
		assertTrue(s4.precio()==720.0);
		//a todo riesgo
		Seguro s5= new Seguro(120, cliente, Cobertura.TODO_RIESGO);
		
		assertTrue(s5.precio()==1200.0);
		//minusv=true
		Cliente clienteMinus = new Cliente("pepe", "72688339J", true);

		Seguro s6= new Seguro(120, clienteMinus, Cobertura.TERCEROS);
		
		assertTrue(s6.precio()==360.0);
		//siniestro 2 años
		LocalDate fechaSiniestro= LocalDate.now().minusYears(2).minusMonths(6);
		
		Seguro s7= new Seguro(120, cliente, Cobertura.TERCEROS);
		s7.setFechaUltimoSiniestro(fechaSiniestro);
		assertTrue(s7.precio()==530.0);
		//siniestro < 1 año
		
		LocalDate fechaSiniestro2= LocalDate.now().minusMonths(6);
		Seguro s8= new Seguro(120, cliente, Cobertura.TERCEROS);
		s8.setFechaUltimoSiniestro(fechaSiniestro2);
		assertTrue(s8.precio()==680.0);
		
	}
}
