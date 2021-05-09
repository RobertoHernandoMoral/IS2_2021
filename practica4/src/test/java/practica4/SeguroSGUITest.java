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



	@Test
	public void testPotenciaNegativa() {
		//borramos los valores introducidos por defecto e introducimos otros de prueba
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("10-01-2015");

		//comprobamos que funciona el campo potencia para un valor NEGATIVO coge la excepcion
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("-50");

		//el 0 corresponde con TODO_RIESGO
		demo.comboBox("comboCobertura").selectItem(0);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("Potencia incorrecta (potencia <= 0)");
	}


	@Test
	public void testValorPotencia() {
		//comprobamos que funcione bien para un valor de potencia intermedio, en este caso 100
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("10-01-2021");

		//comprobamos que funciona el campo potencia para un valor intermedio (100)
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("100");

		//el 0 corresponde con TODO_RIESGO
		demo.comboBox("comboCobertura").selectItem(0);

		//comprueva que el boton Minusvalia este desactivado por defecto
		demo.radioButton("btnMinusvalia").requireNotSelected();
		demo.radioButton("btnMinusvalia").click();

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("787.5");	
	}



	@Test
	public void testFecha() {
		//comprobamos que se coge la excepcion al introducir unos valores incorrectos para el campo fecha
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("01012000");

		//el 0 corresponde con TODO_RIESGO
		demo.comboBox("comboCobertura").selectItem(0);

		demo.button("btnCalcular").click();

		demo.textBox("txtPrecio").requireText("La fecha no se pudo parsear");	
	}
}
