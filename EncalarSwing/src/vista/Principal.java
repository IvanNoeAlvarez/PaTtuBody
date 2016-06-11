package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modelo.Fondo;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Principal extends JPanel {

	private JPanel contentPane;
	private JButton disponible;
	private JButton buscar;
	private JButton añadir;

	
	public Principal() {
		
	
		
		
		setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panel = new JPanel();

		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
; 
		
		añadir = new JButton("A\u00F1adir coche");
		
		GridBagConstraints gbc_añadir = new GridBagConstraints();
		gbc_añadir.fill = GridBagConstraints.HORIZONTAL;
		gbc_añadir.insets = new Insets(0, 0, 5, 0);
		gbc_añadir.gridx = 6;
		gbc_añadir.gridy = 3;
		panel.add(añadir, gbc_añadir);
		
		disponible = new JButton("vehiculos disponibles");
		
		GridBagConstraints gbc_disponible = new GridBagConstraints();
		gbc_disponible.insets = new Insets(0, 0, 5, 0);
		gbc_disponible.gridx = 6;
		gbc_disponible.gridy = 5;
		panel.add(disponible, gbc_disponible);
		
		 buscar = new JButton("Buscar concesionario");
		
		GridBagConstraints gbc_buscar = new GridBagConstraints();
		gbc_buscar.gridx = 6;
		gbc_buscar.gridy = 7;
		panel.add(buscar, gbc_buscar);
	}
		public JButton getdisponible () {
			return this.disponible;
		}
		
		public JButton getbuscar () {
			return this.buscar;
		}
		
		public JButton getañadir () {
			return this.añadir;
		}
		
	}
