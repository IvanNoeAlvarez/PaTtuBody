package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class añadeSuministro extends JPanel {
	private JTextField matriculaT;
	private JTextField modeloT;
	private JTextField cantT;

	/**
	 * Create the panel.
	 */
	public añadeSuministro() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel Matricula = new JLabel("Matricula");
		GridBagConstraints gbc_Matricula = new GridBagConstraints();
		gbc_Matricula.insets = new Insets(0, 0, 5, 5);
		gbc_Matricula.gridx = 3;
		gbc_Matricula.gridy = 1;
		panel.add(Matricula, gbc_Matricula);
		
		matriculaT = new JTextField();
		GridBagConstraints gbc_matriculaT = new GridBagConstraints();
		gbc_matriculaT.insets = new Insets(0, 0, 5, 0);
		gbc_matriculaT.fill = GridBagConstraints.HORIZONTAL;
		gbc_matriculaT.gridx = 5;
		gbc_matriculaT.gridy = 1;
		panel.add(matriculaT, gbc_matriculaT);
		matriculaT.setColumns(10);
		
		JLabel Modelo = new JLabel("Modelo");
		GridBagConstraints gbc_Modelo = new GridBagConstraints();
		gbc_Modelo.insets = new Insets(0, 0, 5, 5);
		gbc_Modelo.gridx = 3;
		gbc_Modelo.gridy = 3;
		panel.add(Modelo, gbc_Modelo);
		
		modeloT = new JTextField();
		GridBagConstraints gbc_modeloT = new GridBagConstraints();
		gbc_modeloT.insets = new Insets(0, 0, 5, 0);
		gbc_modeloT.fill = GridBagConstraints.HORIZONTAL;
		gbc_modeloT.gridx = 5;
		gbc_modeloT.gridy = 3;
		panel.add(modeloT, gbc_modeloT);
		modeloT.setColumns(10);
		
		JLabel Cantidad = new JLabel("Cantidad");
		GridBagConstraints gbc_Cantidad = new GridBagConstraints();
		gbc_Cantidad.insets = new Insets(0, 0, 5, 5);
		gbc_Cantidad.gridx = 3;
		gbc_Cantidad.gridy = 5;
		panel.add(Cantidad, gbc_Cantidad);
		
		cantT = new JTextField();
		GridBagConstraints gbc_cantT = new GridBagConstraints();
		gbc_cantT.insets = new Insets(0, 0, 5, 0);
		gbc_cantT.fill = GridBagConstraints.HORIZONTAL;
		gbc_cantT.gridx = 5;
		gbc_cantT.gridy = 5;
		panel.add(cantT, gbc_cantT);
		cantT.setColumns(10);
		
		JButton add = new JButton("A\u00F1adir");
		GridBagConstraints gbc_add = new GridBagConstraints();
		gbc_add.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_add.gridx = 5;
		gbc_add.gridy = 7;
		panel.add(add, gbc_add);

	}

}
