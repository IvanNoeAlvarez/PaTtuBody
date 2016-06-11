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

import Conexiones.Conexion;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Vehiculos extends JPanel {
	private JTable table;
	private JTextField buscarT;
	DefaultTableModel dtm;
	private JButton suministro;
	private JPanel panel_1;
	private JButton Atras;
	ResultSet rs = null;

	Conexion conex = Conexion.LlamarInst();
	private JButton borrar;
	private JPanel panelCentro;
	private JButton comprar;
	private JButton listaC;

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
				DefaultTableModel dtmB = new DefaultTableModel();
				String coche = buscarT.getText().toString();
				Conexion.LlamarInst();
				rs = conex.buscarCoche(coche);

				table.setModel(dtmB);
				dtmB.setColumnIdentifiers(
						new Object[] { "Coche", "matricula", "Deposito", "Consumo", "Cantidad", "Precio €" });

				try {

					while (rs.next()) {
						dtmB.addRow(new Object[] { rs.getString("coche"), rs.getString("matriculaC"),
								rs.getString("TipoDeposito"), rs.getDouble("consumo"), rs.getInt("cantidadDeposito"),
								rs.getInt("precio") });

					}

				} catch (Exception ex) {
					ex.getMessage();
				}

			}
		});
		panel.add(buscar);

		comprar = new JButton("Comprar");
		comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		panel.add(comprar);

		listaC = new JButton("Lista de Compra");
		panel.add(listaC);
		listaC.disable();
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		borrar = new JButton("Borrar");
		panel_1.add(borrar);
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lineas = table.getRowCount();
				int fila;
				String matricula;

				fila = table.getSelectedRow();
				matricula = (String) table.getValueAt(fila, 1);

				conex.borrarC(matricula);

				for (int i = 0; i < lineas; i++) {
					dtm.removeRow(0);

				}

				tabla();

				JOptionPane.showMessageDialog(null, "COCHE BORRADO CON EXITO");

			}
		});

		Atras = new JButton("Atr\u00E1s");

		panel_1.add(Atras);

		suministro = new JButton("A\u00F1ade suministro");
		panel_1.add(suministro);
		suministro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int cantidad;
				String matricula;

				int fila = table.getSelectedRow();

				matricula = (String) table.getValueAt(fila, 1);
				cantidad = (Integer) table.getValueAt(fila, 4);
				int lineas = table.getRowCount();

				int cant = Integer.parseInt(JOptionPane.showInputDialog("cantidad", cantidad));

				Conexion conex = Conexion.LlamarInst();

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

	public JButton getsuministro() {
		return this.suministro;
	}

	public JButton getComprar() {
		return comprar;
	}

	public JButton getAtras() {
		return this.Atras;

	}
}
