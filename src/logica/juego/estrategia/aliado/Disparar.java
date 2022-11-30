package logica.juego.estrategia.aliado;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.proyectil.Proyectil;
import logica.juego.visitor.VisitorTimer;

public class Disparar extends EstrategiaAliado {
	
	public Disparar(Aliado a) {
		super(a);
	}

	@Override
	public void actuar() {
		if(this.aliado.getMapa().getJuego().getAtaqueAliado().hayEnemigosEnLaFila(this.aliado.getPosicionY())) {
			Proyectil disparo = this.aliado.getProyectil();
			this.aliado.getMapa().agregarEntidad(disparo);
			this.aliado.getMapa().getJuego().getMovimientoDeProyectiles().agregarProyectil(disparo);
		}
	}
	
	@Override
	public void accept(VisitorTimer v) {
		v.visit(this);
	}

}
