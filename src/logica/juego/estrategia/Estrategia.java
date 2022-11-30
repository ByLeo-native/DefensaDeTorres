package logica.juego.estrategia;

import logica.juego.entidad.Entidad;
import logica.juego.visitor.VisitorTimer;

public interface Estrategia {
	public void actuar();
	public void kill();
	public Entidad getEntidad();
	public void accept(VisitorTimer v);
}
