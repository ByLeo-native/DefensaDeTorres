package logica.juego.estrategia.enemigo;

import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.visitor.VisitorTimer;

public class Comer extends EstrategiaEnemigo {

	protected Aliado aliado;
	
	public Comer(Enemigo e, Aliado a) {
		super(e);
		this.aliado = a;
	}

	@Override
	public void actuar() {
		this.aliado.setVida(this.aliado.getVida() - this.enemigo.getDanio());
		if(this.aliado.getVida() <= 0) {
			this.aliado.getMapa().removerEntidad(aliado);
			this.aliado.kill();
			this.enemigo.setEstrategia(new Caminar(this.enemigo));
			//Ver si es la mejor opcion que este aca el cambio entre los hilos
			this.enemigo.getMapa().getJuego().getAtaqueEnemigo().eliminarEnemigo(enemigo);
			this.enemigo.getMapa().getJuego().getMovimientoEnemigo().agregarEnemigo(enemigo);
		}
	}
	
	public void kill() {
		super.kill();
		this.aliado = null;
	}
	
	@Override
	public void accept(VisitorTimer v) {
		v.visit(this);
	}

}
