package logica.juego.hilo.aliado;

import logica.juego.Juego;

public class TimerGeneracionDeSoles extends TimerAliado {
	
	public TimerGeneracionDeSoles(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public void generarSonido() {
		this.player.playGeneracionDeSoles();
	}
}
