package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Conexiones.Conexion_Consultas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarConcesionario extends JPanel {
	// BOTON-CAMPO DE TEXTO Y TABLA
	private JTable table;
	private JTextField busquedaT;
	private JButton Atras;
	
	// VARIABLES SOBRE ACCIONES DE LA BASE DE DATOS
	ResultSet rs = null;
	DefaultTableModel dtm;
	DefaultTableModel dtmB;
	Conexion_Consultas conex = Conexion_Consultas.LlamarInst();

	/**
	 * Create the panel.
	 */
	public BuscarConcesionario() {
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
		busqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion_Consultas.LlamarInst();
				String nombre = busquedaT.getText().toString();
				rs = conex.buscarConcesionario(nombre);
				
				// DECLARAR UNA NUEVA TABLA DE BUSQUEDA QUE SOLAPARA LA TABLA QUE MUESTRA TODA LA LISTA
				dtmB = new DefaultTableModel();
				table.setModel(dtmB);
				
				dtmB.setColumnIdentifiers(new Object[] { "id", "nombre", "localidad" });
				
				try {

					while (rs.next()) {
						dtmB.addRow(new Object[] { rs.getInt("id_concesionario"), rs.getString("nombre"),
								rs.getString("Localidad") });
					}

				} catch (Exception e) {
					e.getMessage();
				}


				
			}
		});
		panel.add(busqueda);
		tabla();

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		Atras = new JButton("Atr\u00E1s");
		panel_1.add(Atras);

	}

	// METODO QUE MOSTRARA TODO EL CONTENIDO DE LA CONSULTA
	public void tabla() {
		
		dtm = new DefaultTableModel();

		table.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[] { "id", "nombre", "localidad" });

		rs = conex.verConcesionario();

		try {

			while (rs.next()) {
				dtm.addRow(new Object[] { rs.getInt("id_concesionario"), rs.getString("nombre"),
						rs.getString("Localidad") });
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public JButton getAtras() {
		return this.Atras;
	}

}
