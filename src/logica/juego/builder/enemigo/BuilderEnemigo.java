package logica.juego.builder.enemigo;

import logica.juego.builder.Builder;
import logica.juego.entidad.blindaje.Blindaje;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.estrategia.enemigo.EstrategiaEnemigo;
import logica.juego.mapa.Mapa;

public class BuilderEnemigo implements Builder {
	
	protected Mapa mapa;
	protected Enemigo resultado;
	
	public BuilderEnemigo(Mapa m) {
		this.mapa = m;
		this.resultado = new Enemigo(0, 0, 0, 0, this.mapa);
	}

	@Override
	public void resetear() {
		this.resultado = new Enemigo(0, 0, 0, 0, this.mapa);
	}
	
	public void setDimensiones(int x, int y) {
		this.resultado.setDimensionX(x);
		this.resultado.setDimensionY(y);
	}

	@Override
	public void setPosicion(int x, int y) {
		this.resultado.setPosicion(x, y);
	}

	@Override
	public void setMapa(Mapa m) {
		this.resultado.setMapa(m);
	}

	@Override
	public void setVidaMaxima(int v) {
		this.resultado.setVidaMaxima(v);
	}

	@Override
	public void setVida(int v) {
		this.resultado.setVida(v);
	}
	
	public void setVelocidad(int v) {
		this.resultado.setVelocidad(v);
	}
	
	public void setBlindaje(Blindaje b) {
		this.resultado.setBlidanje(b);
	}
	
	public void setEstrategia(EstrategiaEnemigo e) {
		this.resultado.setEstrategia(e);
	}

	@Override
	public void setEntidadGrafica(String ruta) {
		this.resultado.setEntidadGrafica(ruta);
	}
	
	@Override
	public void setDanio(int d) {
		this.resultado.setDanio(d);
	}

	public Enemigo getResultado() {
		return this.resultado;
	}

}
