package grafico.mapaGrafico;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import grafica.entidadGrafica.EntidadGrafica;
import logica.juego.mapa.Mapa;

public class MapaGrafico extends JPanel {
	
	protected Image fondo;
	protected Mapa mapa;
	protected String dir = "src/assets/";
	
	public MapaGrafico() {
		super();
		this.addMouseListener(new OyenteMouse());
	}
	
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public void agregarEntidadGrafica(EntidadGrafica e) {
		this.add(e.getImagen());
		this.repaint();
	}
	
	public void removerEntidadGrafica(EntidadGrafica e) {
		this.remove(e.getImagen());
		this.repaint();
	}
	
	public int getAlto() {
		return this.getHeight();
	}
	
	public int getAncho() {
		return this.getWidth();
	}
	
	public void paint(Graphics g){
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	private class OyenteMouse implements MouseListener {
		public void mouseClicked(MouseEvent e){}
		
		public void mouseEntered(MouseEvent e){}
		
		public void mouseExited(MouseEvent e){}
		
		public void mousePressed(MouseEvent e){
			int x= e.getX() / Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("anchoDeCadaColumna"));
			int y= e.getY();
			if(y>=40){
				y = (y)/ Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("alturaDeCadaFila"));
				System.out.println("( "+x+", "+y+")");
				mapa.getJuego().ejecutarAccion(x, y);
			}
		}
		
		public void mouseReleased(MouseEvent e){}
	}

	public void setFondo(String s) {
		JLabel l = new JLabel();
		l.setBounds(0, 0, this.getWidth(), this.getHeight());
		fondo = new ImageIcon(dir+s).getImage();
		System.out.println(dir+s);
		this.add(l);
		repaint();
	}
	
}
