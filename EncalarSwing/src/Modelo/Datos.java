package Modelo;

public class Datos {
	int dni;
	String nombre;
	String coche;
	String matriculaC;
	String TipoDeposito;
	Double consumo;
	int cantidadDeposito;
	int id_concesionario;
	String Localidad;
	String cocheC;
	int precio;
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCoche() {
		return coche;
	}
	public void setCoche(String coche) {
		this.coche = coche;
	}
	public String getMatriculaC() {
		return matriculaC;
	}
	public void setMatriculaC(String matriculaC) {
		this.matriculaC = matriculaC;
	}
	public String getTipoDeposito() {
		return TipoDeposito;
	}
	
	public Double getConsumo() {
		return consumo;
	}
	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	
	public void setTipoDeposito(String tipoDeposito) {
		TipoDeposito = tipoDeposito;
	}
	public int getCantidadDeposito() {
		return cantidadDeposito;
	}
	public void setCantidadDeposito(int cantidadDeposito) {
		this.cantidadDeposito = cantidadDeposito;
	}
	public int getId_concesionario() {
		return id_concesionario;
	}
	public void setId_concesionario(int id_concesionario) {
		this.id_concesionario = id_concesionario;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getCocheC() {
		return cocheC;
	}
	public void setCocheC(String cocheC) {
		this.cocheC = cocheC;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Datos [dni=" + dni + ", nombre=" + nombre + ", coche=" + coche + ", matriculaC=" + matriculaC
				+ ", TipoDeposito=" + TipoDeposito + ", cantidadDeposito=" + cantidadDeposito + ", id_concesionario="
				+ id_concesionario + ", Localidad=" + Localidad + ", cocheC=" + cocheC + ", precio=" + precio + "]";
	}
	

}
