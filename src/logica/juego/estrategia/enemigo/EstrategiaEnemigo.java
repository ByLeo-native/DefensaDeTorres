package logica.juego.estrategia.enemigo;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.estrategia.Estrategia;
import music.Player;

public abstract class EstrategiaEnemigo implements Estrategia {
	
	protected Player player;
	protected Enemigo enemigo;
	
	public EstrategiaEnemigo(Enemigo e) {
		this.enemigo = e;
		this.player = new Player();
	}
	
	public void kill() {
		this.enemigo = null;
		this.player.kill();
		this.player = null;
	}
	
	@Override
	public Entidad getEntidad() {
		return this.enemigo;
	}
}
