package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Conexiones.Conexion;

public class Buscar extends JPanel {
	private JTable table;
	private JTextField busquedaT;
	private JButton Atras;
	ResultSet rs = null;
	DefaultTableModel dtm;
	Conexion conex = Conexion.LlamarInst();

	/**
	 * Create the panel.
	 */
	public Buscar() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		busquedaT = new JTextField();
		panel.add(busquedaT);
		busquedaT.setColumns(10);

		JButton busqueda = new JButton("Buscar");
		panel.add(busqueda);

		dtm = new DefaultTableModel();

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		Atras = new JButton("Atr\u00E1s");
		panel_1.add(Atras);
		tabla(dtm);

	}

	public void tabla(DefaultTableModel dtm) {

		table.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[] { "id", "nombre", "localidad" });

		rs = conex.verConcesionario();

		try {

			while (rs.next()) {
				dtm.addRow(new Object[] { rs.getInt("id"), rs.getString("nombre"), rs.getString("localidad") });
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public JButton getAtras() {
		return this.Atras;
	}

}
