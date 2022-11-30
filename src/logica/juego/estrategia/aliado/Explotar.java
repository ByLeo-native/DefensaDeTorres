package logica.juego.estrategia.aliado;

import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.visitor.VisitorTimer;

public class Explotar extends EstrategiaAliado {

	public Explotar(Aliado a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actuar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entidad getEntidad() {
		return this.aliado;
	}
	
	@Override
	public void accept(VisitorTimer v) {
		v.visit(this);
	}

}
