package practica4;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.seguros.SegurosGUI;

public class SeguroSGUITest {

	private FrameFixture demo;

	@Before
	public void setUp() {
		SegurosGUI gui = new SegurosGUI();
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}

	@After
	public void tearDown() {
		demo.cleanUp();
	}


	/*
	@Test
	public void testMinusvalia() {
		//comprobamos que funciona con el boton minusvalia desactivado
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("50");

		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("10-01-2000");

		//el 0 corresponde con TODO_RIESGO
		demo.comboBox("comboCobertura").selectItem(0);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("1000.0");	

		//////////

		//comprobamos que funciona con el boton minusvalia activado

		demo.radioButton("btnMinusvalia").click();

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("750.0");	
	}
	 */



	@Test
	public void testPotencia() {
<<<<<<< HEAD
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//NO NOS CALCULA BIEN LA SINIESTRABILIDAD, NO LO SUMA AL PRECIO, EN SEGURO SI QUE SE CALCULA BIEN
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("10-01-2021");

		//comprobamos que funciona el campo potencia para un valor intermedio (100)
=======
		//comprobamos que funciona el campo potencia para un valor en el intervalo bajo (50)
>>>>>>> 5f2430e5d1ea4fadec477f847d0d64a17a795de8
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("50");

		//el 0 corresponde con TODO_RIESGO
		demo.comboBox("comboCobertura").selectItem(0);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("1050.0");	
		
		//Hacemos otra prueba para comprobar que funciona el enumerado TERCEROS
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("10-01-2012");

		//comprobamos que funciona el campo potencia para un valor intermedio (100)
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("50");

		//el 0 corresponde con TERCEROS
		demo.comboBox("comboCobertura").selectItem(2);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("400.0");	

		//Hacemos otra prueba para comprobar una potencia negativa
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("10-01-2001");
		
		//comprobamos que funciona el campo potencia para un valor NEGATIVO coge la excepcion
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("-50");

		//el 0 corresponde con TODO_RIESGO
		demo.comboBox("comboCobertura").selectItem(0);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("Potencia incorrecta (potencia <= 0)");	


		/*
		//comprobamos que funciona el campo potencia para un valor intermedio (100)
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("100");

		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("01-01-2000");

		//el 0 corresponde con TODO_RIESGO
		demo.comboBox("comboCobertura").selectItem(0);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("1050.0");	
		 */
	}


	@Test
	public void testFecha() {
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("01012000");

		//el 0 corresponde con TODO_RIESGO
		demo.comboBox("comboCobertura").selectItem(0);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("La fecha no se pudo parsear");	
	}


	// Comprobamos que la interfaz tiene el aspecto deseado y que el boton Minusvalia funciona correctamente
	@Test
	public void testAspectoInterfaz() {
		//comprueba que el campo Precio este vacio
		demo.textBox("txtPrecio").requireEmpty();

		//Comprueba que el valor por defecto en el campo Ultimo Siniestro sea dd-mm-yyyy
		demo.textBox("txtFechaUltimoSiniestro").requireText("dd-mm-yyyy");

		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("01-01-2000");

		//Comprueba que el valor por defecto en el campo Cobertura sea TODO_RIESGO
		demo.comboBox("comboCobertura").requireSelection(0);

		//el 1 corresponde con TERCEROS_LUNAS
		demo.comboBox("comboCobertura").selectItem(1);

		//Comprueba que el valor por defecto en el campo Potencia sea 75
		demo.textBox("txtPotencia").requireText("75");

		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("120");

		//comprueva que el boton Minusvalia este desactivado por defecto
		demo.radioButton("btnMinusvalia").requireNotSelected();
		demo.radioButton("btnMinusvalia").click();

		// Comprobamos que el boton btnCalcular tenga el String CALCULAR
		demo.button("btnCalcular").requireText("CALCULAR");
		demo.button("btnCalcular").click();

<<<<<<< HEAD
		demo.textBox("txtPrecio").requireText("540.0");	
=======
		demo.textBox("txtPrecio").requireText("1000.0");
		
		//comprobamos que funciona el campo potencia para un valor intermedio (100)
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("100");

		//demo.radioButton("btnMinusvalia").click();

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("1050.0");
		
		//comprobamos que funciona el campo potencia para un valor alto (120)
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("120");

		//demo.radioButton("btnMinusvalia").click();

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("1200.0");			
	}
	
	@Test
	public void testCobertura() {
		//comprobamos que funciona el campo de cobertura con TODO_RIESGO
				demo.textBox("txtPotencia").deleteText();
				demo.textBox("txtPotencia").enterText("50");

				demo.textBox("txtFechaUltimoSiniestro").deleteText();
				demo.textBox("txtFechaUltimoSiniestro").enterText("10-01-2000");

				//el 0 corresponde con TODO_RIESGO
				demo.comboBox("comboCobertura").selectItem(0);

				demo.button("btnCalcular").click();

				demo.textBox("txtPrecio").requireText("1000.0");
				
				//comprobamos que funciona el campo de cobertura con TERCEROS_LUNAS


				demo.comboBox("comboCobertura").selectItem("TERCEROS_LUNAS");


				demo.button("btnCalcular").click();

				demo.textBox("txtPrecio").requireText("600.0");
				
				//comprobamos que funciona el campo de cobertura con TERCEROS


				demo.comboBox("comboCobertura").selectItem("TERCEROS");


				demo.button("btnCalcular").click();

				demo.textBox("txtPrecio").requireText("400.0");		
		
>>>>>>> 5f2430e5d1ea4fadec477f847d0d64a17a795de8
	}
}
