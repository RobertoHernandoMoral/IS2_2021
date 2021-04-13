package es.unican.is2.alarmas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class GUI {

	private JFrame frame;

	private JTextField textID;

	private Alarmas alarmas = new Alarmas();


	/**
	 * Metodo main que lanza la ventana principal de la GUI
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					GUI ventana = new GUI();
					ventana.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Crea la aplicacion
	 */
	public GUI() {
		arrancar();
	}

	
	
	/**
	 * Inicia los datos
	 */
	private void arrancar() {
		
		//Inicia el panel principal
		frame = new JFrame();
		
		frame.setBounds(150, 150, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);

		//Panel de texto
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 197, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		
		
		//Etiquita de la ID
		JLabel lblId = new JLabel("ID ALARMA");
		
		lblId.setBounds(25, 23, 46, 14);
		panel.add(lblId);
		

		//Cuadro de texto para la id
		textID = new JTextField();
		
		textID.setBounds(87, 18, 87, 21);
		panel.add(textID);
		textID.setColumns(12);

		//Etiqueta de la alarma
		JLabel lblAlarma = new JLabel("HORA DE ALARMA");
		
		lblAlarma.setBounds(28, 53, 71, 16);
		panel.add(lblAlarma);

		//Boton de nueva alarma
		JButton btnNuevaAlarma = new JButton("NUEVA ALARMA");
		
		btnNuevaAlarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//alarmas.anhadeAlarma(new Alarma(id, date))
			}
		});
		btnNuevaAlarma.setBounds(35, 80, 133, 23);
		panel.add(btnNuevaAlarma);

		//Boton de apagado de la alarma
		JButton btnApagar = new JButton("APAGAR ALARMA");
		
		btnApagar.setBounds(28, 125, 140, 42);
		panel.add(btnApagar);

		
		Date date = new Date();
		
		/*SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(93, 51, 104, 20);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "hh:mm");
		spinner.setEditor(de);
		panel.add(spinner);*/

		//Etique de alarmas activas
		JLabel lblAlarmasActivas = new JLabel("Alarmas Activas");
		
		lblAlarmasActivas.setBounds(275, 10, 117, 24);
		frame.getContentPane().add(lblAlarmasActivas);

		//Etique de alarmas desactivas
		JLabel lblAlarmasDesactivadas = new JLabel("Alarmas Desactivas");
		
		lblAlarmasDesactivadas.setBounds(275, 10, 117, 24);
		frame.getContentPane().add(lblAlarmasDesactivadas);

		//Cuadro de texto con las alarmas activas
		JTextPane textpnActivas = new JTextPane();
		
		textpnActivas.setEditable(false);
		textpnActivas.setBounds(265, 30, 100, 60);
		frame.getContentPane().add(textpnActivas);

		//Cuadro de texto con las alarmasa inactivas
		final JTextPane textpndesactivadas = new JTextPane();
		
		textpndesactivadas.setEditable(false);
		textpndesactivadas.setBounds(265, 30, 100, 60);
		frame.getContentPane().add(textpndesactivadas);
		
		//Boton de activar alarma
		JButton btnOn = new JButton("ON");
		btnOn.setBounds(276, 195, 60, 20);
		frame.getContentPane().add(btnOn);
		btnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Alarma en ON");

				try {
					//textpndesactivadas.insertString(textpndesactivadas.getLength, id + "\n", null);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		//Boton para desactivar la alarma
		JButton btnOff = new JButton("OFF");
		btnOff.setBounds(346, 195, 60, 21);
		frame.getContentPane().add(btnOff);
		btnOff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//
			}
		});


		JButton btnEliminar = new JButton("ELIMINAR ALARMA");
		btnEliminar.setBounds(286, 226, 113, 23);
		frame.getContentPane().add(btnEliminar);


	}
}
