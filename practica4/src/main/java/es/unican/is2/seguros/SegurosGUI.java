package es.unican.is2.seguros;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class SegurosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaUltimoSiniestro;
	private JRadioButton btnMinusvalia;
	private JComboBox<String> comboCobertura;
	private JTextField txtPotencia;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegurosGUI frame = new SegurosGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SegurosGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFechaUltimoSiniestro = new JTextField();
		txtFechaUltimoSiniestro.setText("dd-mm-yyyy");
		txtFechaUltimoSiniestro.setName("txtFechaUltimoSiniestro");
		txtFechaUltimoSiniestro.setBounds(124, 8, 86, 20);
		contentPane.add(txtFechaUltimoSiniestro);
		txtFechaUltimoSiniestro.setColumns(10);
		
		JLabel lblSueldo = new JLabel("PRECIO");
		lblSueldo.setBounds(10, 192, 126, 17);
		contentPane.add(lblSueldo);
		
		txtPrecio = new JTextField();
		txtPrecio.setName("txtPrecio");
		txtPrecio.setBounds(109, 191, 208, 18);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setName("btnCalcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				double precio=0.0;
				try {
					LocalDate fechaUltimoSiniestro = LocalDate.parse(txtFechaUltimoSiniestro.getText(), formatter);
					boolean minusvalia = btnMinusvalia.isSelected();
					int potencia = Integer.parseInt(txtPotencia.getText());
			    	Cobertura cobertura = Cobertura.valueOf(comboCobertura.getSelectedItem().toString());
			    	Seguro seguro = new Seguro(potencia, new Cliente("Pepe", "12345678A", minusvalia), cobertura);
			    	precio = seguro.precio();
			    	txtPrecio.setText(Double.toString(precio));
			    	
				} catch (es.unican.is2.seguros.Seguro.DatoIncorrectoException e) {
					if (precio <= 0) {
						txtPrecio.setText("Potencia incorrecta (potencia <= 0)");
					}
					else {
						txtPrecio.setText(Double.toString(precio));
					}
					
				} catch (DateTimeParseException e) {
					txtPrecio.setText("La fecha no se pudo parsear");
				}
				
			}
		});
		btnCalcular.setBounds(134, 144, 126, 29);
		contentPane.add(btnCalcular);
		
		btnMinusvalia = new JRadioButton("Minusval\u00EDa");
		btnMinusvalia.setBounds(243, 93, 109, 23);
		btnMinusvalia.setName("btnMinusvalia");
		contentPane.add(btnMinusvalia);
		
		comboCobertura = new JComboBox();
		comboCobertura.setName("comboCobertura");
		comboCobertura.setModel(new DefaultComboBoxModel(new String[] {"TODO_RIESGO", "TERCEROS_LUNAS", "TERCEROS"}));
		comboCobertura.setBounds(124, 44, 188, 23);
		contentPane.add(comboCobertura);
		
		JLabel lblCobertura = new JLabel("Cobertura");
		lblCobertura.setBounds(10, 50, 114, 14);
		contentPane.add(lblCobertura);
		
		JLabel lblPotencia = new JLabel("Potencia");
		lblPotencia.setBounds(10, 104, 114, 17);
		contentPane.add(lblPotencia);
		
		txtPotencia = new JTextField();
		txtPotencia.setText("75");
		txtPotencia.setName("txtPotencia");
		txtPotencia.setColumns(10);
		txtPotencia.setBounds(124, 101, 86, 20);
		contentPane.add(txtPotencia);
		
		JLabel lblUltimoSiniestro = new JLabel("Ultimo Siniestro");
		lblUltimoSiniestro.setBounds(10, 11, 114, 17);
		contentPane.add(lblUltimoSiniestro);
		
	}
}