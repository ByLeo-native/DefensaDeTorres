package logica.juego.visitor;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.entidad.proyectil.Proyectil;

public interface Visitor {
	public void visit(Entidad e);
	public void visit(Aliado a);
	public void visit(Enemigo e);
	public void visit(Proyectil p);
	public void kill();
}
