package logica.juego.estrategia.aliado;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.estrategia.Estrategia;
import music.Player;

public abstract class EstrategiaAliado implements Estrategia {
	
	protected Player player;
	protected Aliado aliado;
	
	public EstrategiaAliado(Aliado a) {
		this.aliado = a;
		this.player = new Player();
	}
	
	public void kill() {
		this.player.kill();
		this.player = null;
		this.aliado = null;
	}
	
	@Override
	public Entidad getEntidad() {
		return this.aliado;
	}
}
