package logica.juego.entidad.aliado;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.proyectil.Proyectil;
import logica.juego.estrategia.Estrategia;
import logica.juego.estrategia.aliado.EstrategiaAliado;
import logica.juego.mapa.Mapa;
import logica.juego.visitor.Visitor;
import logica.juego.visitor.VisitorColisionAliado;

public class Aliado extends Entidad {
	
	protected int soles, precio;
	protected EstrategiaAliado estrategia;
	protected Visitor visitorColisionAliado;
	protected Proyectil proyectil;

	public Aliado(int x, int y, int dx, int dy, Mapa m) {
		super(x, y, dx, dy, m);
		this.danio = 0;
		this.soles = 0;
		this.precio = 0;
		this.estrategia = null;
		this.proyectil = null;
		this.visitorColisionAliado = new VisitorColisionAliado(this);
	}
	
	public void actuar() {
		this.estrategia.actuar();
	}
	
	public Estrategia getEstrategia() {
		return this.estrategia;
	}
	
	public void setEstrategia(EstrategiaAliado e) {
		this.estrategia = e;
	}
	
	public int getSoles() {
		return this.soles;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	public void setSoles(int s) {
		this.soles = s;
	}
	
	public void setPrecio(int p) {
		this.precio = p;
	}
	
	public void setProyectil(Proyectil p) {
		this.proyectil = p;
	}
	
	public Visitor getColisionAliado() {
		return this.visitorColisionAliado;
	}
	
	public void setPosicion(int x, int y) {
		super.setPosicion(x, y);
		if(this.proyectil != null) {
			this.proyectil.setPosicion(x, y);
		}
	}
	
	public Proyectil getProyectil() {
		return this.proyectil.clone();
	}
	
	public void kill() {
		super.kill();
		this.estrategia = null;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
