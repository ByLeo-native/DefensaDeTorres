package logica.juego.entidad;

import grafica.entidadGrafica.EntidadGrafica;
import logica.juego.mapa.Mapa;
import logica.juego.visitor.Visitor;

public abstract class Entidad {

	protected int posicionX;
	protected int posicionY;
	protected int dimensionX;
	protected int dimensionY;
	protected int vida;
	protected int vidaMaxima;
	protected int danio;
	protected Mapa mapa;
	protected EntidadGrafica entidadGrafica;
	
	public Entidad( int x, int y, int dx, int dy, Mapa m) {
		this.posicionX = x;
		this.posicionY = y;
		this.dimensionX = dx;
		this.dimensionY = dy;
		this.vidaMaxima = this.vida = 0;
		this.danio = 0;
		this.mapa = m;
		this.entidadGrafica = new EntidadGrafica();
	}
	
	public int getPosicionX() {
		return this.posicionX;
	}
	
	public int getPosicionY() {
		return this.posicionY;
	}
	
	public void setPosicionX( int x ) {
		this.posicionX = x;
	}
	
	public void setPosicionY( int y ) {
		this.posicionY = y;
	}
	
	public int getDimensionX() {
		return this.dimensionX;
	}
	
	public int getDimensionY() {
		return this.dimensionY;
	}
	
	public void setDimensionX(int dx) {
		this.dimensionX = dx;
	}
	
	public void setDimensionY(int dy) {
		this.dimensionY = dy;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public int getVidaMaxima() {
		return this.vidaMaxima;
	}
	
	public void setVida(int v) {
		this.vida = v;
	}
	
	public void setVidaMaxima(int v) {
		this.vidaMaxima = v;
	}
	
	public int getDanio() {
		return this.danio;
	}
	
	public void setDanio(int d) {
		this.danio = d;
	}
	
	public Mapa getMapa() {
		return this.mapa;
	}
	
	public void setMapa(Mapa m) {
		this.mapa = m;
	}
	
	public void kill() {
		this.mapa = null;
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return this.entidadGrafica;
	}
	
	public void setEntidadGrafica(String ruta) {
		this.entidadGrafica.alinearConEntidad(posicionX, posicionY, dimensionX, dimensionY);
		this.entidadGrafica.setRuta(ruta);
		this.entidadGrafica.actualizarImagen();
	}
	
	public void setPosicion(int x, int y) {
		this.posicionX = x;
		this.posicionY = y;
		this.entidadGrafica.alinearConEntidad(x, y, dimensionX, dimensionY);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
