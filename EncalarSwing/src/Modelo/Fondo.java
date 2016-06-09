package Modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Fondo extends JPanel {
	
	// GUARDARA LA IMAGEN
	private Image img; 
	
	//URL DE LA IMAGEN
	String imgF= "auto.gif";
	
	// METODO QUE ACTUARA AUTOMATICAMENTE CADA VEZ QUE SE LLAME A LA CLASE
	public void paintComponent (Graphics g) {
		
		// EL TAMAÑO SE AJUSTARA AL TAMAÑO DEL PANEL
		int width = this.getSize().width;
		int height = this.getSize().height;
		
		// PINTARA LA IMAGEN
		if (this.img != null) {
			g.drawImage(this.img, 0, 0, height,width,null);
		}
		
		super.paintComponent(g);
		
	}
	
	//METODO PARA AJUSTAR LA IMAGEN VINIENDO DE URL
	public void pintar (String imgF) {
		this.setOpaque(false);
		
	//CONSTRUIR IMAGEN Y SE LE ASIGNA A LA URL
		this.img = new ImageIcon(imgF).getImage();
		repaint();
	}
	
}
