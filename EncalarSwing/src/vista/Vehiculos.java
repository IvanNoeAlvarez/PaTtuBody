package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Conexiones.Conexion;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Vehiculos extends JPanel {
	private JTable table;
	private JTextField buscarT;
	DefaultTableModel dtm;
	DefaultTableModel dtmC;
	private JButton suministro;
	private JPanel panel_1;
	private JButton Atras;
	ResultSet rs= null;

	añadeSuministro sum = new añadeSuministro();

	Conexion conex = Conexion.LlamarInst();
	private JButton comprar;

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
		 suministro.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		sum.setVisible(true);
		 	}
		 });
		 
		 
		panel.add(suministro);
		
		comprar = new JButton("Comprar");
		comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila;
				String dni;
				
				
				fila = table.getSelectedRow();
				dni = (String) table.getValueAt(fila, 0);
				
				dtmC = new DefaultTableModel();
				table.setModel(dtmC);
				
				dtmC.setColumnIdentifiers(new Object[] {"Coche","matricula", "Deposito", "Consumo", "Cantidad"});

				
				conex.borrarC(dni);
				
				try{
					
					while (rs.next()) {
						dtmC.addRow(new Object[] {rs.getString("coche"), rs.getString("matriculaC"), rs.getString("TipoDeposito"), rs.getDouble("consumo"), rs.getInt("cantidadDeposito")});
						
						JOptionPane.showInternalConfirmDialog(null, "LLAMANOS PARA NEGOCIAR EL PRECIO");
					}
					
					
					
				}catch(Exception ex) {
					ex.getMessage();
				}
				
				
			}
		});
		panel.add(comprar);
	
		
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		Atras = new JButton("Atr\u00E1s");
		
		panel_1.add(Atras);
		
		tabla();

	}
	
	
	public void tabla () {

		dtm = new DefaultTableModel();

		
		table.setModel(dtm);
		
		dtm.setColumnIdentifiers(new Object[] {"Coche","matricula", "Deposito", "Consumo", "Cantidad"});
		
		rs = conex.verClientes();
		
		try{
			
			while (rs.next()) {
				dtm.addRow(new Object[] {rs.getString("coche"), rs.getString("matriculaC"), rs.getString("TipoDeposito"), rs.getDouble("consumo"), rs.getInt("cantidadDeposito")});
			}
			
			
			
		}catch(Exception e) {
			e.getMessage();
		}
		
	}
	
	public JButton getsuministro () {
		return this.suministro;
	}

	
	public JButton getAtras() {
		return this.Atras;
		
	}
}
