package logica.juego.estrategia.enemigo;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.estrategia.Estrategia;

public abstract class EstrategiaEnemigo implements Estrategia {
	
	protected Enemigo enemigo;
	
	public EstrategiaEnemigo(Enemigo e) {
		this.enemigo = e;
	}
	
	public void kill() {
		this.enemigo = null;
	}
	
	@Override
	public Entidad getEntidad() {
		return this.enemigo;
	}
}
