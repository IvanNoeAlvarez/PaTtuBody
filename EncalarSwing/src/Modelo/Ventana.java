package Modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import vista.*;

public class Ventana extends JFrame {

	private JPanel contentPane;

	final static String Principal = "Principal";
	final static String Vehiculos = "Vehiculos";
	final static String Buscar = "Buscar";
	final static String añadeSuministro = "añadeSuministro";
	final static String Vender = "vender";

	Principal v0 = new Principal();
	Vehiculos v1 = new Vehiculos();
	Buscar v2 = new Buscar();
	añadeSuministro v3 = new añadeSuministro();
	Vender v4 = new Vender();

	CardLayout c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
		c1 = new CardLayout();
		contentPane.setLayout(c1);
		
		contentPane.add(v0, Principal);
		contentPane.add(v1, Vehiculos);
		contentPane.add(v2, Buscar);
		contentPane.add(v3, añadeSuministro);
		contentPane.add(v4, Vender);
		
		
		 CardLayout c1 = (CardLayout)(contentPane.getLayout());
		c1.show(contentPane, Principal);
		
		
		v0.getañadir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, Vender);
			}
		});
		
		v1.getsuministro().addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		c1.show(contentPane, añadeSuministro);
		 	}
		 });
		
		v4.getatras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c1.show(contentPane, Principal);
			}
		});
		
		v0.getbuscar().addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		c1.show(contentPane, Buscar);
		 	}
		 });
		
		v2.getAtras().addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
			c1.show(contentPane, Principal);
				
			}
		});
	}

}
