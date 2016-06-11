package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.xml.bind.ParseConversionEvent;

import Conexiones.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Añade extends JPanel {
	private JTextField cocheT;
	private JTextField matriculaT;
	private JTextField tipoT;
	private JTextField cantT;
	
	private JButton atras;
	private JButton add;
	private JTextField consumoT;
	private JTextField precioT;

	/**
	 * Create the panel.
	 */
	public Añade() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelD = new JPanel();
		add(panelD, BorderLayout.CENTER);
		GridBagLayout gbl_panelD = new GridBagLayout();
		gbl_panelD.columnWidths = new int[]{97, 86, 86, 0};
		gbl_panelD.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelD.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelD.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelD.setLayout(gbl_panelD);
		
		JLabel coche_1 = new JLabel("coche");
		GridBagConstraints gbc_coche_1 = new GridBagConstraints();
		gbc_coche_1.insets = new Insets(0, 0, 5, 5);
		gbc_coche_1.gridx = 0;
		gbc_coche_1.gridy = 2;
		panelD.add(coche_1, gbc_coche_1);
		
		cocheT = new JTextField();
		GridBagConstraints gbc_cocheT = new GridBagConstraints();
		gbc_cocheT.insets = new Insets(0, 0, 5, 5);
		gbc_cocheT.anchor = GridBagConstraints.NORTHWEST;
		gbc_cocheT.gridx = 1;
		gbc_cocheT.gridy = 2;
		panelD.add(cocheT, gbc_cocheT);
		cocheT.setColumns(10);
		
		JLabel matricula = new JLabel("matricula");
		GridBagConstraints gbc_matricula = new GridBagConstraints();
		gbc_matricula.insets = new Insets(0, 0, 5, 5);
		gbc_matricula.gridx = 0;
		gbc_matricula.gridy = 3;
		panelD.add(matricula, gbc_matricula);
		
		matriculaT = new JTextField();
		GridBagConstraints gbc_matriculaT = new GridBagConstraints();
		gbc_matriculaT.insets = new Insets(0, 0, 5, 5);
		gbc_matriculaT.fill = GridBagConstraints.HORIZONTAL;
		gbc_matriculaT.gridx = 1;
		gbc_matriculaT.gridy = 3;
		panelD.add(matriculaT, gbc_matriculaT);
		matriculaT.setColumns(10);
		
		JLabel tipo = new JLabel("Tipo de deposito");
		GridBagConstraints gbc_tipo = new GridBagConstraints();
		gbc_tipo.insets = new Insets(0, 0, 5, 5);
		gbc_tipo.gridx = 0;
		gbc_tipo.gridy = 4;
		panelD.add(tipo, gbc_tipo);
		
		tipoT = new JTextField();
		GridBagConstraints gbc_tipoT = new GridBagConstraints();
		gbc_tipoT.insets = new Insets(0, 0, 5, 5);
		gbc_tipoT.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipoT.gridx = 1;
		gbc_tipoT.gridy = 4;
		panelD.add(tipoT, gbc_tipoT);
		tipoT.setColumns(10);
		
		JLabel consumo_1 = new JLabel("consumo");
		GridBagConstraints gbc_consumo_1 = new GridBagConstraints();
		gbc_consumo_1.insets = new Insets(0, 0, 5, 5);
		gbc_consumo_1.gridx = 0;
		gbc_consumo_1.gridy = 5;
		panelD.add(consumo_1, gbc_consumo_1);
		
		consumoT = new JTextField();
		GridBagConstraints gbc_consumoT = new GridBagConstraints();
		gbc_consumoT.insets = new Insets(0, 0, 5, 5);
		gbc_consumoT.fill = GridBagConstraints.HORIZONTAL;
		gbc_consumoT.gridx = 1;
		gbc_consumoT.gridy = 5;
		panelD.add(consumoT, gbc_consumoT);
		consumoT.setColumns(10);
		
		JLabel cant = new JLabel("cantidad");
		GridBagConstraints gbc_cant = new GridBagConstraints();
		gbc_cant.insets = new Insets(0, 0, 5, 5);
		gbc_cant.gridx = 0;
		gbc_cant.gridy = 6;
		panelD.add(cant, gbc_cant);
		
		cantT = new JTextField();
		GridBagConstraints gbc_cantT = new GridBagConstraints();
		gbc_cantT.insets = new Insets(0, 0, 5, 5);
		gbc_cantT.fill = GridBagConstraints.HORIZONTAL;
		gbc_cantT.gridx = 1;
		gbc_cantT.gridy = 6;
		panelD.add(cantT, gbc_cantT);
		cantT.setColumns(10);
		
		JLabel precio = new JLabel("precio");
		GridBagConstraints gbc_precio = new GridBagConstraints();
		gbc_precio.insets = new Insets(0, 0, 0, 5);
		gbc_precio.gridx = 0;
		gbc_precio.gridy = 7;
		panelD.add(precio, gbc_precio);
		
		precioT = new JTextField();
		GridBagConstraints gbc_precioT = new GridBagConstraints();
		gbc_precioT.insets = new Insets(0, 0, 0, 5);
		gbc_precioT.fill = GridBagConstraints.HORIZONTAL;
		gbc_precioT.gridx = 1;
		gbc_precioT.gridy = 7;
		panelD.add(precioT, gbc_precioT);
		precioT.setColumns(10);
		
		JPanel panelInf = new JPanel();
		add(panelInf, BorderLayout.SOUTH);
		
		atras = new JButton("Atr\u00E1s");
		
		panelInf.add(atras);
		
		 add = new JButton("A\u00F1adir");
		 add.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		Conexion conex = Conexion.LlamarInst();
		 		
		 	
		 		String coche = cocheT.getText().toString();
		 		String matriculaC = matriculaT.getText().toString();
		 		String TipoDeposito= tipoT.getText().toString();
		 		Double consumo = Double.parseDouble(consumoT.getText().toString());
		 		Integer cantidadDeposito = Integer.parseInt(cantT.getText().toString());
		 		Integer precio = Integer.parseInt(precioT.getText().toString());
		 		conex.añadeCoche( coche, matriculaC, TipoDeposito,consumo, cantidadDeposito,precio);
		 			
		 		JOptionPane.showMessageDialog(null, "COCHE AÑADIDO CORRECTAMENTE");
		 	}
		 });
		panelInf.add(add);

	}
	
	public JButton getvender () {
		return this.add;
	}

	public JButton getatras () {
		return this.atras;
	}
}
