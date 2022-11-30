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

public class VisitorAniadirATimer implements VisitorTimer {
	
	protected Juego juego;
	
	public VisitorAniadirATimer(Juego j) {
		this.juego = j;
	}

	@Override
	public void visit(GenerarSoles g) {
		this.juego.getGeneracionDeSoles().agregarAliado( (Aliado) g.getEntidad());
	}

	@Override
	public void visit(Explotar e) {
		//
	}

	@Override
	public void visit(Pasivo p) {}

	@Override
	public void visit(Disparar d) {
		this.juego.getAtaqueAliado().agregarAliado((Aliado) d.getEntidad());
	}

	@Override
	public void visit(Caminar c) {
		this.juego.getMovimientoEnemigo().agregarEnemigo((Enemigo) c.getEntidad());
	}

	@Override
	public void visit(Comer c) {
		this.juego.getAtaqueEnemigo().agregarEnemigo((Enemigo) c.getEntidad());
	}

	@Override
	public void visit(Desplazamiento d) {
		this.juego.getMovimientoDeProyectiles().agregarProyectil((Proyectil) d.getEntidad());
	}

}
