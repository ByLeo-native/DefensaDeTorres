package logica.juego.visitor;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.blindaje.Blindaje;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.entidad.proyectil.Proyectil;
import logica.juego.estrategia.enemigo.Caminar;
import logica.juego.estrategia.enemigo.Comer;

public class VisitorColisionEnemigo implements Visitor {
	
	protected VisitorTimer visitorTimerRemover; 
	protected Enemigo enemigo;
	
	public VisitorColisionEnemigo(Enemigo e) {
		this.enemigo = e;
		this.visitorTimerRemover = new VisitorRemoverTimer(this.enemigo.getMapa().getJuego());
	}

	@Override
	public void visit(Entidad e) {}

	@Override
	public void visit(Aliado a) {
		this.enemigo.getEstrategia().accept(visitorTimerRemover);
		this.enemigo.setEstrategia(new Comer(this.enemigo, a));
		this.enemigo.getMapa().getJuego().getMovimientoEnemigo().eliminarEnemigo(enemigo);
		this.enemigo.getMapa().getJuego().getAtaqueEnemigo().agregarEnemigo(enemigo);
	}

	@Override
	public void visit(Enemigo e) {}

	@Override
	public void visit(Proyectil p) {
		if(this.enemigo.tieneBlindaje()) {
			Blindaje b = this.enemigo.getBlindaje();
			b.setVida(b.getVida() - p.getDanio());
			if(b.getVida() <= 0) {
				b.kill();
				this.enemigo.eliminarBlindaje();
			}
		} else {
			this.enemigo.setVida(this.enemigo.getVida() - p.getDanio());
			System.out.println("Vida actual: "+this.enemigo.getVida());
			if(this.enemigo.getVida() <= 0) {
				this.enemigo.getMapa().removerEntidad(enemigo);
				this.enemigo.getMapa().getJuego().getAtaqueAliado().disminuirCantidad(this.enemigo.getPosicionY());
				this.enemigo.getEstrategia().accept(visitorTimerRemover);
				//this.enemigo.getMapa().getJuego().getMovimientoEnemigo().eliminarEnemigo(enemigo);
				this.enemigo.kill();
			}
		}
		//impactar proyectil
		p.impactar();
		if(p.getCantidadDeImpactos() <= 0) {
			p.getMapa().removerEntidad(p);
			p.getEstrategia().accept(visitorTimerRemover);
			//p.getMapa().getJuego().getMovimientoDeProyectiles().eliminarProyectil(p);
			p.kill();
		}
	}
	
	public void kill() {
		this.enemigo = null;
	}
	
}
