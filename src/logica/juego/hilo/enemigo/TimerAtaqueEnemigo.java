package logica.juego.hilo.enemigo;

import java.util.ArrayList;
import java.util.List;

import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.nivel.Nivel;

public class TimerAtaqueEnemigo extends TimerEnemigo {
	
	protected boolean execute;
	protected Nivel nivelActual;
	protected List<Enemigo> enEjecucion, paraInsertar, paraEliminar;
	
	public TimerAtaqueEnemigo() {
		super();
		this.tiempo = 1000;
	}
	
}
