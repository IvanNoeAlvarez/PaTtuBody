package Modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class Fondo extends javax.swing.JPanel {
public Fondo(){
this.setSize(400,280);
}
@Override
public void paintComponent (Graphics g){
Dimension tamanio = getSize();
ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
setOpaque(false);
super.paintComponent(g);
}
}