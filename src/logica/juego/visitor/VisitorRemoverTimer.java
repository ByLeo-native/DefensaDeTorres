package logica.juego.visitor;

import logica.juego.Juego;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.entidad.proyectil.Proyectil;
import logica.juego.estrategia.Desplazamiento;
import logica.juego.estrategia.aliado.Disparar;
import logica.juego.estrategia.aliado.Explotar;
import logica.juego.estrategia.aliado.GenerarSoles;
import logica.juego.estrategia.aliado.Pasivo;
import logica.juego.estrategia.enemigo.Caminar;
import logica.juego.estrategia.enemigo.Comer;

public class VisitorRemoverTimer implements VisitorTimer {
	
	protected Juego juego;
	
	public VisitorRemoverTimer(Juego j) {
		this.juego = j;
	}

	@Override
	public void visit(GenerarSoles g) {
		this.juego.getGeneracionDeSoles().eliminarAliado((Aliado) g.getEntidad());
	}

	@Override
	public void visit(Explotar e) {
		//
	}

	@Override
	public void visit(Pasivo p) {}

	@Override
	public void visit(Disparar d) {
		this.juego.getAtaqueAliado().eliminarAliado((Aliado) d.getEntidad());
	}

	@Override
	public void visit(Caminar c) {
		this.juego.getMovimientoEnemigo().eliminarEnemigo((Enemigo) c.getEntidad());
	}

	@Override
	public void visit(Comer c) {
		this.juego.getAtaqueEnemigo().eliminarEnemigo((Enemigo) c.getEntidad());
	}

	@Override
	public void visit(Desplazamiento d) {
		this.juego.getMovimientoDeProyectiles().eliminarProyectil((Proyectil) d.getEntidad());
	}

}
