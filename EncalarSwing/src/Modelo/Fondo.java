package Modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Fondo extends JPanel {

	// GUARDARA LA IMAGEN
	private Image img;
	
	
	
	// DENTRO DE LA CLASE CREAR UN CONSTRUCTOR QUE SE IGUALA AL QUE TENEMOS EN ELLA
	public Fondo() {
		super();
		this.setOpaque(false);
		
	} 
	
	
	private void imagenFondo (Image img) {
		this.img = img;
	}
	

	public ImageIcon crearImagen (String imagen) {
		
	}
	


	

}
