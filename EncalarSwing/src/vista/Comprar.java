package vista;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.*;
import Conexiones.Conexion;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.SystemColor;

public class Comprar extends JPanel {

	// BOTONES
	private JTable table;
	private JButton atras;
	private JButton factura;
	private JButton act;
	private JButton borrar;

	// LLAMARLO EN SU PROPIA CLASE PARA ACTUALIZAR LA TABLA
	private Comprar esteObjecto = this;

	// ACCIONES SOBRE LA BASE DE DATOS
	ResultSet rs = null;
	Conexion conex = Conexion.LlamarInst();
	DefaultTableModel dtmC;

	// CLASES PARA EL PDF
	Document Documento;
	Image imagen;
	PdfWriter leerP;
	PdfContentByte contenidoP;
	FileOutputStream fichero;
	BaseFont tipografia;
	private JPanel panel_1;
	private JTextField Total;
	private JButton btnTotal;

	/**
	 * Create the panel.
	 */
	public Comprar() {

		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		panel_1 = new JPanel();
		scrollPane.setRowHeaderView(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		Total = new JTextField();
		Total.setForeground(SystemColor.windowBorder);
		Total.setText("Total...");
		panel_1.add(Total, BorderLayout.SOUTH);
		Total.setColumns(10);

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

		borrar = new JButton("Borrar Seleccion");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int lineas = table.getRowCount();
				int fila;
				String matricula;

				fila = table.getSelectedRow();
				matricula = (String) table.getValueAt(fila, 1);

				conex.borrarcocheL(matricula);

				for (int i = 0; i < lineas; i++) {
					dtmC.removeRow(0);

				}

				tabla();

			}
		});
		panel.add(borrar);

		factura = new JButton("Generar Factura");
		factura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int fila;
				fila = table.getSelectedRow();

				String coche = (String) table.getValueAt(fila, 0);
				String matriculaC = (String) table.getValueAt(fila, 1);
				String TipoDeposito = (String) table.getValueAt(fila, 2);
				Double consumo = (Double) table.getValueAt(fila, 3);
				Integer cantidadDeposito = (Integer) table.getValueAt(fila, 4);
				Integer precio = (Integer) table.getValueAt(fila, 5);

				GenerarFactura(coche, matriculaC, TipoDeposito, consumo, cantidadDeposito, precio);

				System.out.println(coche);
				System.out.println(matriculaC);

			}
		});
		
		btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumaFactura();
			}
		});
		panel.add(btnTotal);
		panel.add(factura);

	}

	public JButton getAtras() {
		return atras;
	}

	public void tabla() {
		dtmC = new DefaultTableModel();

		table.setModel(dtmC);

		dtmC.setColumnIdentifiers(new Object[] { "Coche", "matricula", "Deposito", "Consumo", "Cantidad", "Precio €" });

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

	public void GenerarFactura(String coche, String matriculaC, String TipoDeposito, Double consumo,
			int cantidadDeposito, int precio) {

		try {
			fichero = new FileOutputStream("C:\\Users\\Alvar_000\\Desktop\\Factura.pdf");

			leerP = PdfWriter.getInstance(Documento, fichero);

			Documento.open();

			// imagen = Image.getInstance("Imagenes/logo.png");

			contenidoP = leerP.getDirectContent();

			tipografia = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

			contenidoP.setFontAndSize(tipografia, 12);
			contenidoP.beginText();

			contenidoP.setTextMatrix(50, 590);
			contenidoP.showText("Coche: " + coche);

			contenidoP.setTextMatrix(50, 560);
			contenidoP.showText("Matricula: " + matriculaC);

			contenidoP.setTextMatrix(50, 530);
			contenidoP.showText("Tipo deposito: " + TipoDeposito);

			contenidoP.setTextMatrix(50, 500);
			contenidoP.showText("Consumo: " + consumo);

			contenidoP.setTextMatrix(50, 470);
			contenidoP.showText("Cantidad de deposito: " + cantidadDeposito);

			contenidoP.setTextMatrix(50, 440);
			contenidoP.showText("Precio: " + precio);

			contenidoP.endText();

			Documento.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void sumaFactura() {

		int total = 0;
		// recorrer todas las filas de la segunda columna y va sumando las
		// cantidades
		for (int i = 0; i < dtmC.getRowCount(); i++) {
			int numero = 0;
			try {
				// capturamos valor de celda
				numero = Integer.valueOf(dtmC.getValueAt(i, 5).toString());
			} catch (NumberFormatException nfe) { // si existe un error se
													// coloca 0 a la celda
				numero = 0;
				dtmC.setValueAt(0, i, 1);
			}
			total += numero;
		}
		Total.setText(String.valueOf(total));
	}
}
