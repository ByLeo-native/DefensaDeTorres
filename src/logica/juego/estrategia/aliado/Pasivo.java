package logica.juego.estrategia.aliado;

import logica.juego.entidad.aliado.Aliado;
import logica.juego.visitor.VisitorTimer;

public class Pasivo extends EstrategiaAliado {

	public Pasivo(Aliado a) {
		super(a);
	}

	@Override
	public void actuar() {}

	@Override
	public void accept(VisitorTimer v) {
		v.visit(this);
	}
}
