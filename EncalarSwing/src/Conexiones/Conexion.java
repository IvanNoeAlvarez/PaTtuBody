package Conexiones;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Conexion {

	static Connection con; // ATRIBUTO PARA GUARDAR EL OBJETO CONEXION
	private static Conexion INSTANCE = null;

	private Conexion() {
		datosConexion();

	}

	private synchronized static void crearInstancia() { // SI NO EXISTE UNA
														// INSTANCE CREARLA
		if (INSTANCE == null) {
			INSTANCE = new Conexion();

		}
	}

	public static Conexion LlamarInst() { // LLAMAR A LA INSTANCE CREADA
		if (INSTANCE == null)
			crearInstancia();
		return INSTANCE;
	}

	public static void borrarInst() { // BORRAR LA INSTANCE
		INSTANCE = null;
		cerrarC();

	}

	public void datosConexion() {
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost/Concesionario?user=root&password=");
			// Otros y operaciones sobre la base de datos...
		} catch (SQLException ex) {
			// Mantener el control sobre el tipo de error
			System.out.println("SQLException: " + ex.getMessage());
		}
		// Registrar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Conexión exitosa");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void cerrarC() {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR EN LA CONEXION");
		}

	}

	//////////////////////////// CONSULTAS/////////////////////////////////////////////////////
	
	
	
	// SELECTS

	public ResultSet verConcesionario() {

		Conexion conex = Conexion.LlamarInst();

		java.sql.Statement st;

		ResultSet rs = null;

		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM concesionario;");

		} catch (SQLException e) {
			e.getMessage();

		}
		return rs;
	}

	public ResultSet verClientes() {

		Conexion conex = Conexion.LlamarInst();

		java.sql.Statement st;

		ResultSet rs = null;

		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM coches;");

		} catch (SQLException e) {
			e.getMessage();

		}
		return rs;
	}
	
	public ResultSet verCompra() {

		Conexion conex = Conexion.LlamarInst();

		java.sql.Statement st;

		ResultSet rs = null;

		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM listaCompra;");

		} catch (SQLException e) {
			e.getMessage();

		}
		return rs;
	}
	
	
	public ResultSet verSumaFactura (int precio) {
		Conexion conex = Conexion.LlamarInst();

		java.sql.Statement st;

		ResultSet rs = null;
		
		try{
			
			st = con.createStatement();
			rs = st.executeQuery("SELECT SUM(precio) AS Total FROM listaCompra;");
			
			
		}catch (SQLException e){
			e.getMessage();
		}
		
		return rs;
	}

	// BUSCADORES
	
	public ResultSet buscarConcesionario(String nombre) {
		Conexion.LlamarInst();
		PreparedStatement pst;
		ResultSet rs = null;
	
		try {
			   if (!nombre.isEmpty()) {
			    pst = con.prepareStatement("SELECT * FROM concesionario WHERE nombre like ? or id_concesionario=? or Localidad like ?");
			    pst.setString(1, nombre+"%");
			    pst.setString(2, nombre+"%");
			    pst.setString(3, nombre+"%");
			    System.out.println(pst.toString());
			    rs = pst.executeQuery();
			   }else{
			    pst = con.prepareStatement("SELECT * FROM concesionario");
			    rs = pst.executeQuery();
			   
		}
		}catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}

	public ResultSet buscarCoche(String coche) {
		Conexion.LlamarInst();
		PreparedStatement pst;
		ResultSet rs = null;
		

		try {
			   if (!coche.isEmpty()) {
			    pst = con.prepareStatement("SELECT * FROM coches WHERE  coche like ? or TipoDeposito like ? or precio < ?");
			    pst.setString(1, coche+"%");
			    pst.setString(2, coche+"%");
			    pst.setString(3, coche+"%");
			    System.out.println(pst.toString());
			    rs = pst.executeQuery();
			   }else{
			    pst = con.prepareStatement("SELECT * FROM coches");
			    rs = pst.executeQuery();
			   }

		} catch (Exception e) {
			e.getMessage();
		}

		return rs;
	}

	
	//INSERTS
	
	public void añadeCoche(String coche, String matriculaC, String TipoDeposito, Double consumo, int cantidadDeposito,
			int precio) {
		Conexion.LlamarInst();
		PreparedStatement pst;

		try {
			pst = con.prepareStatement(
					"INSERT INTO coches ( coche, matriculaC, tipoDeposito,consumo, cantidadDeposito,precio) VALUES (?,?,?,?,?,?)");

			pst.setString(1, coche);
			pst.setString(2, matriculaC);
			pst.setString(3, TipoDeposito);
			pst.setDouble(4, consumo);
			pst.setInt(5, cantidadDeposito);
			pst.setInt(6, precio);
			pst.execute();

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	public void compraCoche(String coche, String matriculaC, String TipoDeposito, Double consumo, int cantidadDeposito,
			int precio) {
		Conexion.LlamarInst();
		PreparedStatement pst;

		try {
			pst = con.prepareStatement(
					"INSERT INTO listaCompra ( coche, matriculaC, tipoDeposito,consumo, cantidadDeposito,precio) VALUES (?,?,?,?,?,?)");

			pst.setString(1, coche);
			pst.setString(2, matriculaC);
			pst.setString(3, TipoDeposito);
			pst.setDouble(4, consumo);
			pst.setInt(5, cantidadDeposito);
			pst.setInt(6, precio);
			pst.execute();

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	
	// UPDATE

	public void ActualizarS(String matricula, int cantidad) {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("UPDATE coches SET cantidadDeposito=? WHERE matriculaC =?");
			pst.setInt(1, cantidad);
			pst.setString(2, matricula);
			pst.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	// BORRADOS

	public void borrarC(String matricula) {
		PreparedStatement pst;

		try {

			pst = con.prepareStatement("DELETE FROM coches WHERE matriculaC =?");
			pst.setString(1, matricula);
			pst.execute();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	
	public void borrarcocheL(String matricula) {
		PreparedStatement pst;

		try {

			pst = con.prepareStatement("DELETE FROM listaCompra WHERE matriculaC =?");
			pst.setString(1, matricula);
			pst.execute();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	
	
}
