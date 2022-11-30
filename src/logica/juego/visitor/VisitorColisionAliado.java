package logica.juego.visitor;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.entidad.proyectil.Proyectil;

public class VisitorColisionAliado implements Visitor {
	
	protected Aliado aliado;

	public VisitorColisionAliado(Aliado aliado) {
		this.aliado = aliado;
	}

	@Override
	public void visit(Entidad e) {}

	@Override
	public void visit(Aliado a) {
		this.aliado.getMapa().getJuego().noPermitirAgregarAliado();
	}

	@Override
	public void visit(Enemigo e) {}

	@Override
	public void visit(Proyectil p) {}
	
	public void kill() {
		this.aliado = null;
	}

}
