package logica.juego.builder;

import logica.juego.mapa.Mapa;

public interface Builder {
	
	public void resetear();
	
	public void setPosicion(int x, int y);
	
	public void setMapa(Mapa m);
	
	public void setVidaMaxima(int v);
	
	public void setVida(int v);
	
	public void setEntidadGrafica(String ruta);
	
	public void setDanio(int d);
}
