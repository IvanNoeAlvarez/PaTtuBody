package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vender extends JPanel {
	private JTextField nombreT;
	private JTextField cocheT;
	private JTextField matriculaT;
	private JTextField tipoT;
	private JTextField cantT;
	private JTextField dniT;
	
	private JButton atras;
	private JButton vender;

	/**
	 * Create the panel.
	 */
	public Vender() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelD = new JPanel();
		add(panelD, BorderLayout.CENTER);
		GridBagLayout gbl_panelD = new GridBagLayout();
		gbl_panelD.columnWidths = new int[]{97, 86, 86, 0};
		gbl_panelD.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelD.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelD.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelD.setLayout(gbl_panelD);
		
		JLabel dni = new JLabel("dni");
		GridBagConstraints gbc_dni = new GridBagConstraints();
		gbc_dni.insets = new Insets(0, 0, 5, 5);
		gbc_dni.gridx = 0;
		gbc_dni.gridy = 1;
		panelD.add(dni, gbc_dni);
		
		dniT = new JTextField();
		GridBagConstraints gbc_dniT = new GridBagConstraints();
		gbc_dniT.insets = new Insets(0, 0, 5, 5);
		gbc_dniT.fill = GridBagConstraints.HORIZONTAL;
		gbc_dniT.gridx = 1;
		gbc_dniT.gridy = 1;
		panelD.add(dniT, gbc_dniT);
		dniT.setColumns(10);
		
		JLabel nombre = new JLabel("nombre");
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 0;
		gbc_nombre.gridy = 2;
		panelD.add(nombre, gbc_nombre);
		
		nombreT = new JTextField();
		GridBagConstraints gbc_nombreT = new GridBagConstraints();
		gbc_nombreT.anchor = GridBagConstraints.NORTHWEST;
		gbc_nombreT.insets = new Insets(0, 0, 5, 5);
		gbc_nombreT.gridx = 1;
		gbc_nombreT.gridy = 2;
		panelD.add(nombreT, gbc_nombreT);
		nombreT.setColumns(10);
		
		JLabel coche = new JLabel("coche");
		GridBagConstraints gbc_coche = new GridBagConstraints();
		gbc_coche.insets = new Insets(0, 0, 5, 5);
		gbc_coche.gridx = 0;
		gbc_coche.gridy = 3;
		panelD.add(coche, gbc_coche);
		
		cocheT = new JTextField();
		GridBagConstraints gbc_cocheT = new GridBagConstraints();
		gbc_cocheT.insets = new Insets(0, 0, 5, 5);
		gbc_cocheT.anchor = GridBagConstraints.NORTHWEST;
		gbc_cocheT.gridx = 1;
		gbc_cocheT.gridy = 3;
		panelD.add(cocheT, gbc_cocheT);
		cocheT.setColumns(10);
		
		JLabel matricula = new JLabel("matricula");
		GridBagConstraints gbc_matricula = new GridBagConstraints();
		gbc_matricula.insets = new Insets(0, 0, 5, 5);
		gbc_matricula.gridx = 0;
		gbc_matricula.gridy = 4;
		panelD.add(matricula, gbc_matricula);
		
		matriculaT = new JTextField();
		GridBagConstraints gbc_matriculaT = new GridBagConstraints();
		gbc_matriculaT.insets = new Insets(0, 0, 5, 5);
		gbc_matriculaT.fill = GridBagConstraints.HORIZONTAL;
		gbc_matriculaT.gridx = 1;
		gbc_matriculaT.gridy = 4;
		panelD.add(matriculaT, gbc_matriculaT);
		matriculaT.setColumns(10);
		
		JLabel tipo = new JLabel("Tipo de deposito");
		GridBagConstraints gbc_tipo = new GridBagConstraints();
		gbc_tipo.insets = new Insets(0, 0, 5, 5);
		gbc_tipo.gridx = 0;
		gbc_tipo.gridy = 5;
		panelD.add(tipo, gbc_tipo);
		
		tipoT = new JTextField();
		GridBagConstraints gbc_tipoT = new GridBagConstraints();
		gbc_tipoT.insets = new Insets(0, 0, 5, 5);
		gbc_tipoT.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipoT.gridx = 1;
		gbc_tipoT.gridy = 5;
		panelD.add(tipoT, gbc_tipoT);
		tipoT.setColumns(10);
		
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
		
		JPanel panelInf = new JPanel();
		add(panelInf, BorderLayout.SOUTH);
		
		atras = new JButton("Atr\u00E1s");
		
		panelInf.add(atras);
		
		 vender = new JButton("A\u00F1adir");
		panelInf.add(vender);

	}
	
	public JButton getvender () {
		return this.vender;
	}

	public JButton getatras () {
		return this.atras;
	}
}
