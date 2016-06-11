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
	private JButton a�adir;

	
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
		
		a�adir = new JButton("A\u00F1adir coche");
		
		GridBagConstraints gbc_a�adir = new GridBagConstraints();
		gbc_a�adir.fill = GridBagConstraints.HORIZONTAL;
		gbc_a�adir.insets = new Insets(0, 0, 5, 0);
		gbc_a�adir.gridx = 6;
		gbc_a�adir.gridy = 3;
		panel.add(a�adir, gbc_a�adir);
		
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
		
		public JButton geta�adir () {
			return this.a�adir;
		}
		
	}
