package logica.juego.hilo.aliado;

import logica.juego.mapa.Mapa;

public class TimerAtaqueAliado extends TimerAliado {
	
	protected volatile int [] filasConEnemigos;
	
	public TimerAtaqueAliado(Mapa m) {
		this.filasConEnemigos = new int [m.getCantidadDeFilas()];
		for(int i = 0; i < this.filasConEnemigos.length; i++) {
			this.filasConEnemigos[i] = 0;
		}
		this.tiempo = 7000;
	}
	
	public void agregarCantidad(int fila) {
		this.filasConEnemigos[fila]++;
	}
	
	public void disminuirCantidad(int fila) {
		this.filasConEnemigos[fila]--;
	}
	
	public boolean hayEnemigosEnLaFila(int fila) {
		return this.filasConEnemigos[fila] > 0;
	}

	@Override
	public void generarSonido() {}
}
