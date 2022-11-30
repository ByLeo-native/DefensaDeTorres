package grafica.entidadGrafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGrafica {
	
	protected int alturaDeCadaFila = Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("alturaDeCadaFila"));
	protected int anchoDeCadaColumna = Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("anchoDeCadaColumna"));
	protected int cantidadDeColumnas = Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("cantidadDeColumnas"));
	protected Point p;
	protected JLabel imagen;
	protected int dimensionX;
	protected int dimensionY;
	protected String ruta;
	protected String dir = "src/assets/";
	protected String s;
	
	public EntidadGrafica() {
		this.p = new Point(0,0);
		this.imagen = new JLabel();
		this.dimensionX = 0;
		this.dimensionY = 0;
		this.ruta = "";
	}
	
	public void alinearConEntidad(int x, int y, int dx, int dy) {
		this.p.setLocation(x* anchoDeCadaColumna, y* alturaDeCadaFila);
		this.dimensionX = dx * anchoDeCadaColumna;
		this.dimensionY = dy * alturaDeCadaFila;
		this.imagen.setBounds(this.p.x, this.p.y, this.dimensionX, this.dimensionY);
	}
	
	public void setPosicion(int x, int y) {
		this.p.setLocation(x,y);
	}
	
	public void setDimension(int dx, int dy) {
		this.dimensionX = dx;
		this.dimensionY = dy;
		this.imagen.setBounds(this.p.x, this.p.y, this.dimensionX, this.dimensionY);
	}
	
	public Point getPunto() {
		return this.p;
	}
	
	public JLabel getImagen() {
		return this.imagen;
	}
	
	public void setRuta(String s) {
		this.s = s;
		this.ruta = dir+s;
	}
	
	public int getDimensionX() {
		return this.dimensionX;
	}
	
	public int getDimensionY() {
		return this.dimensionY;
	}
	
	public void actualizarImagen() {
		ImageIcon imgIcon = new ImageIcon(this.ruta);
        Image imgEscalada = imgIcon.getImage().getScaledInstance(this.dimensionX,
                this.dimensionY, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        this.imagen.setIcon(iconoEscalado);
	}
	
	public void cambiarDePosicion(int x, int y) {
		this.p.setLocation(x, y);
		this.imagen.setBounds(this.p.x, this.p.y, this.dimensionX, this.dimensionY);
	}

	public void agregarGraficosAsociados() {
		
	}
	
	public EntidadGrafica clone() {
		EntidadGrafica e = new EntidadGrafica();
		e.setPosicion(this.p.x, this.p.y);
		e.setDimension(this.dimensionX, this.dimensionY);
		e.setRuta(s);
		e.actualizarImagen();
		return e;
	}
}
