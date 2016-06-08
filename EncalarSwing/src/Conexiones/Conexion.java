package Conexiones;

import java.beans.Statement;

import java.sql.*;

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



	public ResultSet verConcesionario() {

		ResultSet rs = null;

		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM concesionario");

			rs = pst.executeQuery();

		} catch (SQLException e) {
			e.getMessage();
		}
		return rs;
	}
}
