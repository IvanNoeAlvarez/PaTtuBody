package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vehiculos extends JPanel {
	private JTable table;
	private JTextField buscarT;
	
	private JButton suministro;
	private JPanel panel_1;
	private JButton Atras;

	/**
	 * Create the panel.
	 */
	public Vehiculos() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		buscarT = new JTextField();
		panel.add(buscarT);
		buscarT.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		panel.add(buscar);
		
		 suministro = new JButton("A\u00F1ade suministro");
		 
		panel.add(suministro);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		Atras = new JButton("Atr\u00E1s");
		Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(Atras);

	}
	
	public JButton getsuministro () {
		return this.suministro;
	}

	
	public JButton getAtras() {
		return this.Atras;
		
	}
}
