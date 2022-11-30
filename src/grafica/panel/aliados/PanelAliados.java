package grafica.panel.aliados;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

import logica.juego.Juego;
import logica.juego.accion.CreadorAliado;

public class PanelAliados extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel soles;
	protected final String dir = "src/assets/cartas/";
	protected Juego juego;
	protected HashMap<String, Integer> items;
	protected String c[];
	protected JButton [] colocables;
	
	public PanelAliados( Juego j, int dx, int dy, String [] c) {		
		this.setBounds(0,0,dx,dy);
		this.c = c;
		this.juego = j;
		aniadirContadorSoles();
		//this.crearMapeo();
		this.crearBotones(200, 300);
	}
	
	private void crearMapeo(){
		items = new HashMap<String,Integer>();
		for(int i=10;i<14;i++){
			items.put(c[i], 2);
		}
	}
	
	private void crearBotones(int ancho, int alto){
		colocables = new JButton[c.length];
		OyenteAgregar oyAgr = new OyenteAgregar();
		int[] fila = {0,0,0,1,1,2,2,2,3,3,5,5,6,6,7,7};
		int x=0;
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton();
			colocables[i].setActionCommand(c[i]);
			colocables[i].setBorder(null);
			colocables[i].setBorderPainted(false);
			colocables[i].setContentAreaFilled(false);
			colocables[i].setIcon(new ImageIcon(dir+"Carta"+c[i]+".png"));
			//colocables[i].setPressedIcon(new ImageIcon(dir+"IconosBotones/Des"+c[i]+".png"));
			//colocables[i].setRolloverIcon(new ImageIcon(dir+"IconosBotones/Entered"+c[i]+".png"));
			colocables[i].addActionListener(oyAgr);
			colocables[i].setFocusable(false);
			colocables[i].setBounds(x*65+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45,65,65);
			this.add(colocables[i]);
		}
		int i = 0;
		while(i<3){
			x=x%3;
			colocables[i].setBounds(x*75+(x+1)*4,fila[i]*alto/12+(fila[i])*9+45,75,105);
			this.agregarImagenACarta(i, dir+"Carta"+c[i]+".png");
			i++;
			x++;
		}
	}
	
	public void aniadirContadorSoles() {
		soles = new JLabel();
		soles.setBounds(0,0,1200,50);
		Image iconoSoles = new ImageIcon(dir+"Counter.png").getImage();
		
		soles.setIcon(new ImageIcon(iconoSoles));
		this.add(soles);
		repaint();
	}
	
	public void AliadosDia1() {
		JLabel cartaPeashooter = new JLabel();
		cartaPeashooter.setBounds(0,50,1200,150);
		Image iconoPeashooter = new ImageIcon(dir+"CartaPeashooter.jpeg").getImage();
		cartaPeashooter.setIcon(new ImageIcon(iconoPeashooter));
		this.add(cartaPeashooter);
		
		JLabel cartaCabagge = new JLabel();
		cartaCabagge.setBounds(0,200,1200,150);
		Image iconoCabagge = new ImageIcon(dir+"CartaCabbagePult.jpeg").getImage();
		cartaCabagge.setIcon(new ImageIcon(iconoCabagge));
		this.add(cartaCabagge);
		
		repaint();
	}
	
	public void AliadosDia2() {
		JLabel cartaChomper = new JLabel();
		cartaChomper.setBounds(0,350,1200,150);
		Image iconoChomper = new ImageIcon(dir+"CartaChomper.jpeg").getImage();
		cartaChomper.setIcon(new ImageIcon(iconoChomper));
		this.add(cartaChomper);
		
		repaint();
	}
	
	public void AliadosNoche1() {
		JLabel cartaPuffShroom = new JLabel();
		cartaPuffShroom.setBounds(0, 50, 1200, 150);
		Image iconoPuff = new ImageIcon(dir+"CartaPuffShroom.jpeg").getImage();
		cartaPuffShroom.setIcon(new ImageIcon(iconoPuff));
		this.add(cartaPuffShroom);
		 
		JLabel cartaFumeShroom = new JLabel();
		cartaFumeShroom.setBounds(0,200,1200,150);
		Image iconoFume = new ImageIcon(dir+"CartaFumeShroom.jpeg").getImage();
		cartaFumeShroom.setIcon(new ImageIcon(iconoFume));
		this.add(cartaFumeShroom);
		 
		repaint();
	}
	
	public void AliadosNoche2() {
		JLabel cartaGraveBuster = new JLabel();
		 cartaGraveBuster.setBounds(0,350,1200,150);
		 Image iconoGraveBuster = new ImageIcon(dir+"CartaGraveBuster.jpeg").getImage();
		 cartaGraveBuster.setIcon(new ImageIcon(iconoGraveBuster));
		 this.add(cartaGraveBuster);
		 
		 repaint();
	}
	
	private class OyenteAgregar implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String s =e.getActionCommand();
			switch(s){
				case "LanzaGuisantes" : 
					juego.establecerAccion(new CreadorAliado(juego.getNivel(), "LanzaGuisantes"));
					break;
				case "Nuez" : 
					juego.establecerAccion(new CreadorAliado(juego.getNivel(), "Nuez"));
					break;
				case "Girasol" : 
					juego.establecerAccion(new CreadorAliado(juego.getNivel(), "Girasol"));
					break;
			}
		}
	}
	
	protected void agregarImagenACarta(int i, String s) {
		ImageIcon imgIcon = new ImageIcon(s);
        Image imgEscalada = imgIcon.getImage().getScaledInstance(this.colocables[i].getWidth(),
                this.colocables[i].getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        this.colocables[i].setIcon(iconoEscalado);
	}
}
