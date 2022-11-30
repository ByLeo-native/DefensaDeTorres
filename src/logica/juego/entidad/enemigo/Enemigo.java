package logica.juego.entidad.enemigo;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.blindaje.Blindaje;
import logica.juego.estrategia.Estrategia;
import logica.juego.estrategia.enemigo.EstrategiaEnemigo;
import logica.juego.mapa.Mapa;
import logica.juego.visitor.Visitor;
import logica.juego.visitor.VisitorColisionEnemigo;

public class Enemigo extends Entidad implements Cloneable {
	
	protected int velocidad;
	protected Blindaje blindaje;
	protected Visitor visitorColision;
	protected EstrategiaEnemigo estrategia;
	
	public Enemigo(int x, int y, int dx, int dy, Mapa m) {
		super(x, y, dx, dy, m);
		this.blindaje = null;
		this.estrategia = null;
		this.velocidad = 0;
		this.visitorColision = new VisitorColisionEnemigo(this);
	}
	
	public void actuar() {
		this.estrategia.actuar();
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public void setVelocidad(int v) {
		this.velocidad = v;
	}
	
	public void setEstrategia(EstrategiaEnemigo e) {
		this.estrategia = e;
	}
	
	public Blindaje getBlindaje() {
		return this.blindaje;
	}
	
	public void setBlidanje(Blindaje b) {
		this.blindaje = b;
	}
	
	public void eliminarBlindaje() {
		this.blindaje = null;
	}
	
	public boolean tieneBlindaje() {
		return this.blindaje != null;
	}
	
	public Visitor getVisitorColision() {
		return this.visitorColision;
	}
	
	public boolean estaVivo() {
		return this.vida > 0;
	}
	
	public void kill() {
		super.kill();
		this.estrategia = null;
		this.blindaje = null;
		this.visitorColision.kill();
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Estrategia getEstrategia() {
		return this.estrategia;
	}
	
}
