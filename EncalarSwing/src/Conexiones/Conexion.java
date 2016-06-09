package Conexiones;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			System.out.println("Conexi�n exitosa");
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
				rs = st.executeQuery("SELECT * FROM cliente;");


			} catch (SQLException e) {
				e.getMessage();
				
			}
			return rs;
		}
	
	public ResultSet buscar (String nombre) {
		Conexion.LlamarInst();
		PreparedStatement pst;
		ResultSet rs = null;
		
		try {
			
			pst= con.prepareStatement("SELECT * FROM concesionario WHERE nombre=?");
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			
		}catch(Exception e) {
			e.getMessage();
		}
		
		
		return rs;
	}
	
	
	public void venderCoche (String dni, String nombre, String coche, String matriculaC, String TipoDeposito,Double consumo, int cantidadDeposito) {
		Conexion.LlamarInst();
		PreparedStatement pst;
		
		
		try{
			pst = con.prepareStatement("INSERT INTO cliente (dni, nombre, coche, matriculaC, tipoDeposito,consumo, cantidadDeposito) VALUES (?,?,?,?,?,?)");
			pst.setString(1, dni);
			pst.setString(2, nombre);
			pst.setString(3,coche);
			pst.setString(4, matriculaC);
			pst.setString(5, TipoDeposito);
			pst.setDouble(6, consumo);
			pst.setInt(7, cantidadDeposito);
			pst.execute();
			
		}catch(Exception e) {
			e.getMessage();
		}
		
		
		
	}

	
	public void borrarC (String dni) {
		PreparedStatement pst;
		
		try{
			
			pst = con.prepareStatement("DELETE FROM cliente WHERE dni =?" );
			pst.setString(1, dni);
			
			pst.execute();
		}catch(Exception e) {
			e.getMessage();
		}
		
		
		
	}

	
}
