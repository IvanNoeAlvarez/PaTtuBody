package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import Conexiones.Conexion_Consultas;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Vehiculos extends JPanel {
	private JTable table;
	private JTextField buscarT;
	private JButton suministro;
	private JPanel panel_1;
	private JButton Atras;
	private JButton borrar;
	private JPanel panelCentro;
	private JButton comprar;
	private JButton listaC;

	// ACCIONES SOBRE LA BASE DE DATOS
	DefaultTableModel dtm;
	ResultSet rs = null;
	Conexion_Consultas conex = Conexion_Consultas.LlamarInst();

	/**
	 * Create the panel.
	 */
	public Vehiculos() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		buscarT = new JTextField();
		panel.add(buscarT);
		buscarT.setColumns(10);



		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarC();

			}
		});
		panel.add(buscar);

		comprar = new JButton("Comprar");
		comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				conex.LlamarInst();

				// VARIABLE QUE ALMACENARA LA SELECCION DE LA TABLA
				int fila;
				fila = table.getSelectedRow();

				// VARIABLES QUE ALMACENARAN EL CONTENIDO DE LA SELECCION Y LA
				// AÑADE
				String coche = (String) dtm.getValueAt(fila, 0);
				String matriculaC = (String) dtm.getValueAt(fila, 1);
				String TipoDeposito = (String) dtm.getValueAt(fila, 2);
				Double consumo = (Double) dtm.getValueAt(fila, 3);
				Integer cantidadDeposito = (Integer) dtm.getValueAt(fila, 4);
				Integer precio = (Integer) dtm.getValueAt(fila, 5);

				conex.compraCoche(coche, matriculaC, TipoDeposito, consumo, cantidadDeposito, precio);

			}
		});
		panel.add(comprar);

		listaC = new JButton("Lista de Compra");

		panel.add(listaC);
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		borrar = new JButton("Borrar");
		panel_1.add(borrar);
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int fila;
				String matricula;

				// SELECCIONA EL DATO SEGUN SU POSICION Y LO BORRA
				fila = table.getSelectedRow();
				matricula = (String) table.getValueAt(fila, 1);

				conex.borrarC(matricula);

				tabla();

				JOptionPane.showMessageDialog(null, "COCHE BORRADO CON EXITO");

			}
		});

		Atras = new JButton("Atr\u00E1s");

		panel_1.add(Atras);

		suministro = new JButton("Modifica suministro");
		panel_1.add(suministro);
		suministro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int cantidad;
				String matricula;

				int fila = table.getSelectedRow();

				// VARIABLE CANTIDAD QUE SE MODIFICARA SELECCIONADO POR PK
				// (matricula)
				matricula = (String) table.getValueAt(fila, 1);
				cantidad = (Integer) table.getValueAt(fila, 4);
				int lineas = table.getRowCount();

				int cant = Integer.parseInt(JOptionPane.showInputDialog("cantidad", cantidad));

				Conexion_Consultas conex = Conexion_Consultas.LlamarInst();

				for (int i = 0; i < lineas; i++) {
					dtm.removeRow(0);

				}

				conex.ActualizarS(matricula, cant);

				tabla();
				JOptionPane.showMessageDialog(null, "SUMINISTRO REALIZADO CON EXITO");

			}

		});

		panelCentro = new JPanel();
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelCentro.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		tabla();

	}

	// METODO QUE MOSTRARA TODO EL CONTENIDO DE LA CONSULTA
	public void tabla() {

		dtm = new DefaultTableModel();

		table.setModel(dtm);

		dtm.setColumnIdentifiers(new Object[] { "Coche", "matricula", "Deposito", "Consumo", "Cantidad", "Precio €" });

		rs = conex.verClientes();

		try {

			while (rs.next()) {
				dtm.addRow(
						new Object[] { rs.getString("coche"), rs.getString("matriculaC"), rs.getString("TipoDeposito"),
								rs.getDouble("consumo"), rs.getInt("cantidadDeposito"), rs.getInt("precio") });
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void buscarC() {
		// TABLA QUE TENDRA LA ACCION QUE HAGAMOS SOPLANDO LA DE TODOS LOS DATOS
		DefaultTableModel dtmB = new DefaultTableModel();
		String coche = buscarT.getText().toString();
		Conexion_Consultas.LlamarInst();
		rs = conex.buscarCoche(coche);

		table.setModel(dtmB);
		dtmB.setColumnIdentifiers(new Object[] { "Coche", "matricula", "Deposito", "Consumo", "Cantidad", "Precio €" });

		try {

			while (rs.next()) {
				dtmB.addRow(
						new Object[] { rs.getString("coche"), rs.getString("matriculaC"), rs.getString("TipoDeposito"),
								rs.getDouble("consumo"), rs.getInt("cantidadDeposito"), rs.getInt("precio") });

			}

		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	public JButton getsuministro() {
		return this.suministro;
	}

	public JButton getlistaC() {
		return this.listaC;
	}

	public JButton getAtras() {
		return this.Atras;

	}
}
