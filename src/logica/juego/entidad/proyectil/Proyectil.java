package logica.juego.entidad.proyectil;

import grafica.entidadGrafica.EntidadGrafica;
import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.estrategia.Desplazamiento;
import logica.juego.estrategia.Estrategia;
import logica.juego.mapa.Mapa;
import logica.juego.visitor.Visitor;

public class Proyectil extends Entidad implements Cloneable {
	
	protected int velocidad;
	protected Estrategia estrategia;

	public Proyectil(int x, int y, int dx, int dy, Mapa m ) {
		super( x, y, dx, dy, m);
		this.estrategia = new Desplazamiento(this);
	}
	
	public Proyectil(Aliado a) {
		super(a.getPosicionX(), a.getPosicionY(), a.getDimensionX(), a.getDimensionY(), a.getMapa());
		this.estrategia = new Desplazamiento(this);
	}
	
	public void setVelocidad(int v) {
		this.velocidad = v;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public void kill() {
		super.kill();
		this.estrategia.kill();
		this.estrategia = null;
	}
	
	public void setEntidadGrafica(EntidadGrafica e) {
		this.entidadGrafica = e.clone();
	}
	
	public int getCantidadDeImpactos() {
		return this.vida;
	}
	
	public void impactar() {
		this.vida--;
	}
	
	public Estrategia getEstrategia() {
		return this.estrategia;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}

	public void actuar() {
		this.estrategia.actuar();
	}
	
	public Proyectil clone() {
		Proyectil aux = new Proyectil(this.posicionX,this.posicionY,this.dimensionX,this.dimensionY, this.mapa);
		aux.setDanio(danio);
		aux.setVida(vida);
		aux.setVelocidad(velocidad);
		aux.setMapa(mapa);
		aux.setEntidadGrafica(entidadGrafica);
		return aux;
	}
	
}
