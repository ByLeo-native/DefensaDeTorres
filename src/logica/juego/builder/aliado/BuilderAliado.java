package logica.juego.builder.aliado;

import logica.juego.builder.Builder;
import logica.juego.entidad.Entidad;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.entidad.proyectil.Proyectil;
import logica.juego.estrategia.aliado.EstrategiaAliado;
import logica.juego.mapa.Mapa;

public class BuilderAliado implements Builder {

	protected Mapa mapa;
	protected Aliado resultado;
	
	public BuilderAliado(Mapa m) {
		this.mapa = m;
		this.resultado = new Aliado( 0, 0, 0, 0, m);
	}
	
	public Aliado getResultado() {
		return this.resultado;
	}
	
	public void resetear() {
		this.resultado = new Aliado( 0, 0, 0, 0, this.mapa);
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

	@Override
	public void setEntidadGrafica(String ruta) {
		this.resultado.setEntidadGrafica(ruta);
	}
	
	public void setSoles(int s) {
		this.resultado.setSoles(s);
	}
	
	public void setPrecio(int p) {
		this.resultado.setPrecio(p);
	}
	
	public void setEstrategia(EstrategiaAliado e) {
		this.resultado.setEstrategia(e);
	}
	
	@Override
	public void setDanio(int d) {
		this.resultado.setDanio(d);
	}

	public void setDimensiones(int i, int j) {
		this.resultado.setDimensionX(i);
		this.resultado.setDimensionY(j);
	}
	
	public void setProyectil(Proyectil p) {
		this.resultado.setProyectil(p);
	}
	
}
