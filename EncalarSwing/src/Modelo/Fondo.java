package Modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

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

Image imagenFondo = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alvar_000\\git\\swingFinal\\EncalarSwing\\libreria\\fondo.png");
g.drawImage(imagenFondo,0, 0, getWidth(), getHeight(), null);  
setOpaque(false);
super.paintComponents(g);
}
}