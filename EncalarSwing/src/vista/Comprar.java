package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.*;
import Conexiones.Conexion;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

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

		String ruta = "libreria/logo.png";

		try {
			fichero = new FileOutputStream("C:\\Users\\Alvar_000\\Desktop\\Factura.pdf");

			leerP = PdfWriter.getInstance(Documento, fichero);

			Documento.open();
			


			/* imagen = Image.getInstance("\\libreria\\logo.png");

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
			
			
	*/
			
			Documento.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
