package logica.juego.estrategia;

import grafica.entidadGrafica.EntidadGrafica;
import logica.juego.Juego;
import logica.juego.entidad.Entidad;
import logica.juego.entidad.proyectil.Proyectil;
import logica.juego.mapa.fila.Fila;
import logica.juego.visitor.VisitorTimer;

public class Desplazamiento implements Estrategia {
	
	protected Juego juego;
	protected Proyectil proyectil;
	
	public Desplazamiento(Proyectil p) {
		this.proyectil = p;
		this.juego = this.proyectil.getMapa().getJuego();
	}

	@Override
	public void actuar() {
		EntidadGrafica grafico = this.proyectil.getEntidadGrafica();
		int posX = grafico.getPunto().x;
		int posY = grafico.getPunto().y;
		int dimensionY = grafico.getDimensionY();
		if(posX == this.proyectil.getMapa().getFila(this.proyectil.getPosicionY()).getDimensionX()) {
			this.juego.getMovimientoDeProyectiles().eliminarProyectil(proyectil);
			this.proyectil.kill();
		}
		grafico.cambiarDePosicion(grafico.getPunto().x + this.proyectil.getVelocidad(), grafico.getPunto().y); //Cambia la posicion del grafico desplazandolo utilizando la velocidad
	}

	@Override
	public void kill() {
		this.juego = null;
		this.proyectil = null;
	}

	@Override
	public Entidad getEntidad() {
		return this.proyectil;
	}

	@Override
	public void accept(VisitorTimer v) {
		v.visit(this);
	}
}
