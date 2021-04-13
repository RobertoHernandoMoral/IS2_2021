package Modelo_de_Implementación;

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
import javax.swing.text.BadLocationException;

public class GUI {

	private JFrame frame;
	private JTextField textID;
	private Alarmas alarmas = new Alarmas();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 197, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblID = new JLabel("Id Alarma");
		lblID.setBounds(25, 23, 46, 14);
		panel.add(lblID);

		textID = new JTextField();
		textID.setBounds(93, 20, 86, 20);
		panel.add(textID);
		textID.setColumns(10);

		JLabel lblAlarma = new JLabel("Hora Alarma");
		lblAlarma.setBounds(25, 54, 72, 14);
		panel.add(lblAlarma);

		JButton btnNuevaAlarma = new JButton("Nueva Alarma");
		btnNuevaAlarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevaAlarma.setBounds(35, 80, 133, 23);
		panel.add(btnNuevaAlarma);

		JButton btnApagar = new JButton("¡APAGAR!");
		btnApagar.setBounds(28, 125, 140, 42);
		panel.add(btnApagar);

		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(93, 51, 104, 20);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "hh:mm");
		spinner.setEditor(de);
		panel.add(spinner);

		JLabel lblAlarmasActivas = new JLabel("Alarmas Activas");
		lblAlarmasActivas.setBounds(276, 11, 113, 21);
		frame.getContentPane().add(lblAlarmasActivas);

		JLabel lblAlarmasDesactivadas = new JLabel("Alarmas desactivadas");
		lblAlarmasDesactivadas.setBounds(276, 101, 113, 21);
		frame.getContentPane().add(lblAlarmasDesactivadas);

		JTextPane textpnActivadas = new JTextPane();
		textpnActivadas.setEditable(false);
		textpnActivadas.setBounds(276, 32, 113, 62);
		frame.getContentPane().add(textpnActivadas);

		final JTextPane textpndesactivadas = new JTextPane();
		textpndesactivadas.setEditable(false);
		textpndesactivadas.setBounds(276, 122, 113, 62);
		frame.getContentPane().add(textpndesactivadas);

		JButton btnOn = new JButton("ON");
		btnOn.setBounds(276, 195, 60, 20);
		frame.getContentPane().add(btnOn);
		btnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = textID.getSelectedText();

				int J1 = textID.getSelectionStart();
				int J2 = textID.getSelectedText().length();

				try {
					textID.getDocument().addDocumentListener(listener);

				} catch (BadLocationException e2) {
					e2.printStackTrace();
				}
				alarmas.alarmaOff(id);
				System.out.println("Borramos la alarma");

				try {
					//textpndesactivadas.insertString(textpndesactivadas.getLength, id + "\n", null);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		JButton btnOff = new JButton("OFF");
		btnOff.setBounds(346, 195, 60, 21);
		frame.getContentPane().add(btnOff);
		btnOff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String id = textID.getSelectedText();

				int J1 = textID.getSelectionStart();
				int J2 = textID.getSelectedText().length();

				try {
					textID.getDocument().remove(J1, J2);

				} catch (BadLocationException e2) {
					e2.printStackTrace();
				}
				alarmas.alarmaOff(id);
				System.out.println("Borramos la alarma");

				try {
					//textpndesactivadas.insertString(textpndesactivadas.getLength(), id + "\n", null);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});


		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(286, 226, 113, 23);
		frame.getContentPane().add(btnEliminar);


		//Nueva Alarma
		//		btnNuevaAlarma.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//			}
		//		});
		//		btnNuevaAlarma.addMouseListener(new MouseAdapter() {
		//			@SuppressWarnings("deprecation")
		//			public void mouseClicked(ActionEvent e) {
		//				String id = textID.getText();
		//				Date date = (Date)spinner.getValue();
		//				Calendar calendar = Calendar.getInstance();
		//				calendar.set(Calendar.HOUR, date.getHours() -12);
		//				calendar.set(Calendar.MINUTE, date.getMinutes());
		//				date = calendar.getTime();
		//				if (alarmas.size() > 0) {
		//					if (alarmas.busca) {
		//					}
		//				}
		//			});
		//
		//		}

	}
}
