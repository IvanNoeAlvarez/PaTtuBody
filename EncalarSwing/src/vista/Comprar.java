package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexiones.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Comprar extends JPanel {
	private JTable table;
	private JButton atras;
	private JButton factura;
	
	// LLAMARLO EN SU PROPIA CLASE PARA ACTUALIZAR LA TABLA
	private Comprar esteObjecto= this;
	
	ResultSet rs = null;
	Conexion conex = Conexion.LlamarInst();
	DefaultTableModel dtmC;
	private JButton act;

	/**
	 * Create the panel.
	 */
	public Comprar() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		atras = new JButton("Atr\u00E1s");
		panel.add(atras);
		
		act = new JButton("Actualizar");
		panel.add(act);
		act.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabla();
				
			}
		});
		
		factura = new JButton("Generar Factura");
		panel.add(factura);
		

	}

	public JButton getAtras() {
		return atras;
	}
	
	public void tabla() {
		dtmC = new DefaultTableModel();
		/*int fila;
		fila = table.getSelectedRow();		
		
		String coche = (String) dtmC.getValueAt(fila, 0);
		String matriculaC = (String) dtmC.getValueAt(fila, 1);
		String TipoDeposito = (String) dtmC.getValueAt(fila, 2);
		Double consumo = (Double) dtmC.getValueAt(fila, 3);
		Integer cantidadDeposito = (Integer) dtmC.getValueAt(fila, 4);
		Integer precio = (Integer) dtmC.getValueAt(fila, 5);
		
		*/
		
		table.setModel(dtmC);

		dtmC.setColumnIdentifiers(new Object[] { "Coche", "matricula", "Deposito", "Consumo", "Cantidad", "Precio �" });

		rs = conex.verCompra();

		try {

			while (rs.next()) {
				dtmC.addRow(
						new Object[] { rs.getString("coche"), rs.getString("matriculaC"), rs.getString("TipoDeposito"),
								rs.getDouble("consumo"), rs.getInt("cantidadDeposito"), rs.getInt("precio") });
			}

		} catch (Exception e) {
			e.getMessage();
		}
		esteObjecto.updateUI();

	}

}
