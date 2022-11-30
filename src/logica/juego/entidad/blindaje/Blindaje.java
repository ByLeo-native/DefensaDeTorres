package logica.juego.entidad.blindaje;

import logica.juego.entidad.Entidad;

public class Blindaje {

	protected int vida;
	protected int vidaMaxima;
	protected Entidad portador;
	
	public Blindaje(int v, Entidad portador) {
		this.vidaMaxima = this.vida = v;
		this.portador = portador;
	}
	
	public void setVida(int v) {
		this.vida = v;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void kill() {
		this.portador = null;
	}
}
