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
import Conexiones.Conexion_Consultas;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	Conexion_Consultas conex = Conexion_Consultas.LlamarInst();
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
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{86, 0};
		gbl_panel_1.rowHeights = new int[]{245, 20, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
				
				btnTotal = new JButton("Total");
				btnTotal.setVerticalAlignment(SwingConstants.BOTTOM);
				GridBagConstraints gbc_btnTotal = new GridBagConstraints();
				gbc_btnTotal.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnTotal.anchor = GridBagConstraints.SOUTH;
				gbc_btnTotal.insets = new Insets(0, 0, 5, 0);
				gbc_btnTotal.gridx = 0;
				gbc_btnTotal.gridy = 0;
				panel_1.add(btnTotal, gbc_btnTotal);
				btnTotal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sumaFactura();
					}
				});
		
				Total = new JTextField();
				Total.setForeground(SystemColor.windowBorder);
				Total.setText("Total...");
				GridBagConstraints gbc_Total = new GridBagConstraints();
				gbc_Total.anchor = GridBagConstraints.NORTH;
				gbc_Total.gridx = 0;
				gbc_Total.gridy = 1;
				panel_1.add(Total, gbc_Total);
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

				// VARIABLE QUE ACTUARA SOBRE EL CONTENIDO DE LA TABLA
				int fila;
				fila = table.getSelectedRow();

				// VARIABLE SOBRE LA QUE SELECCIONARA DE LA TABLA SEGUN LA POSICION Y AÑADIRLA
				String coche = (String) dtmC.getValueAt(fila, 0);
				String matriculaC = (String) dtmC.getValueAt(fila, 1);
				String TipoDeposito = (String) dtmC.getValueAt(fila, 2);
				Double consumo = (Double) dtmC.getValueAt(fila, 3);
				Integer cantidadDeposito = (Integer) dtmC.getValueAt(fila, 4);
				Integer precio = (Integer) dtmC.getValueAt(fila, 5);

				GenerarFactura(coche, matriculaC, TipoDeposito, consumo, cantidadDeposito, precio);

				

			}
		});
		panel.add(factura);

	}

	
// METODO QUE MOSTRARA LA TABLA CON LA COMPRA SOLAPANDO LA TABLA CON TODOS LOS DATOS
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

	
	// METODO QUE GENERARA UN PDF
	public void GenerarFactura(String coche, String matriculaC, String TipoDeposito, Double consumo,
			int cantidadDeposito, int precio) {

		String ruta = "C:\\Users\\Alvar_000\\git\\swingFinal\\EncalarSwing\\src\\Imagenes\\logo.png";

		try {
			fichero = new FileOutputStream("C:\\Users\\Alvar_000\\Desktop\\Factura.pdf");

			leerP = PdfWriter.getInstance(Documento, fichero);

			Documento.open();
			


		//	 imagen = Image.getInstance(ruta);

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
			
			contenidoP.setTextMatrix(50, 410);
			contenidoP.showText("Total"+Total.getText().toString());

			contenidoP.endText();
			
			
	
			
			Documento.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	// SUMATORIO DEL NUMERO TOTAL DE DATOS EN LA TABLA
	public void sumaFactura() {

		//VARIABLE QUE ALMACENARA TODA LA SUMA
		int total = 0;
		
		
		// RECORRER TANTAS FILAS TENGA LA TABLA
		for (int i = 0; i < dtmC.getRowCount(); i++) {
			int numero = 0;
			try {
				// CAPTURAR EL VALOR QUE QUERAMOS -ESTE CASO POSICION 5- EN UNA NUEVA VARIABLE
				numero = Integer.valueOf(dtmC.getValueAt(i, 5).toString());
			} catch (NumberFormatException nfe) { 
				nfe.getMessage();
			}
			total += numero;
		}
		Total.setText(String.valueOf(total+" €"));
	}
	
	public JButton getAtras() {
		return atras;
	}
}


