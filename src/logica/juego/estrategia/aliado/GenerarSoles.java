package logica.juego.estrategia.aliado;

import logica.juego.entidad.aliado.Aliado;
import logica.juego.nivel.Nivel;
import logica.juego.visitor.VisitorTimer;

public class GenerarSoles extends EstrategiaAliado {

	public GenerarSoles(Aliado a) {
		super(a);
	}

	@Override
	public void actuar() {
		Nivel n = this.aliado.getMapa().getJuego().getNivel();
		n.setPresupueto( n.getPresupuesto() + this.aliado.getSoles());
		this.player.playGeneracionDeSoles();
		System.out.println("Cantidad de soles disponible: " +this.aliado.getMapa().getJuego().getNivel().getPresupuesto());
	}
	
	@Override
	public void accept(VisitorTimer v) {
		v.visit(this);
	}
	
	public void kill() {
		this.aliado = null;
		this.player.kill();
	}
}
