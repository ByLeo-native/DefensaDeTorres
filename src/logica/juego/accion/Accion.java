package logica.juego.accion;

import logica.juego.mapa.Mapa;

public interface Accion {
	public void ejecutarAccion(int x, int y, Mapa m);
}
