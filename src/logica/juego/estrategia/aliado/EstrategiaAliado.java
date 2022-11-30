package logica.juego.estrategia.aliado;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.estrategia.Estrategia;

public abstract class EstrategiaAliado implements Estrategia {
	
	protected Aliado aliado;
	
	public EstrategiaAliado(Aliado a) {
		this.aliado = a;
	}
	
	public void kill() {
		this.aliado = null;
	}
	
	@Override
	public Entidad getEntidad() {
		return this.aliado;
	}
}
