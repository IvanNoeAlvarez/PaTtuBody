package Modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import vista.*;

public class Ventana extends JFrame {

	private JPanel contentPane = new JPanel();
	
	
// DECLARAR CONSTANTES TANTAS COMO JPANELS HAYA
	final static String Principal = "Principal";
	final static String Vehiculos = "Vehiculos";
	final static String Buscar = "Buscar";
	final static String Vender = "vender";
	final static String Comprar = "comprar";
	
// INSTANCIAR CADA JPANEL
	Principal v0 = new Principal();
	Vehiculos v1 = new Vehiculos();
	BuscarConcesionario v2 = new BuscarConcesionario();
	Añade v3 = new Añade();
	Comprar v4 = new Comprar();

	CardLayout c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Ventana frame = new Ventana();
					frame.setSize(400, 300);
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
	public Ventana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// DECLARAR UN CardLayout y AÑADIR LOS PANELES
		c1 = new CardLayout();
		contentPane.setLayout(c1);

		contentPane.add(v0, Principal);
		contentPane.add(v1, Vehiculos);
		contentPane.add(v2, Buscar);
		contentPane.add(v3, Vender);
		contentPane.add(v4, Comprar);

		CardLayout c1 = (CardLayout) (contentPane.getLayout());
		c1.show(contentPane, Principal);

		// LLAMANDO A LOS GETTERS CAMBIAR SEGUN EL PANEL QUE QUIERAS MOSTRAR
		v0.getañadir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, Vender);
			}
		});

		v0.getbuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				c1.show(contentPane, Buscar);
			}
		});

		v0.getdisponible().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.show(contentPane, Vehiculos);

			}
		});

		v1.getAtras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				c1.show(contentPane, Principal);
			}
		});
		
		
		v1.getlistaC().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, Comprar);
			}
		});

		v2.getAtras().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, Principal);

			}
		});

		v3.getatras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				c1.show(contentPane, Principal);
			}
		});

		v4.getAtras().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, Principal);

			}
		});

	}

}
