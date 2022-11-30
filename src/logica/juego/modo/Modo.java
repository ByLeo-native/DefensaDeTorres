package logica.juego.modo;

import java.util.List;

import logica.juego.builder.aliado.BuilderAliado;
import logica.juego.builder.enemigo.BuilderEnemigo;
import logica.juego.entidad.blindaje.Blindaje;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.entidad.proyectil.DisparoLanzaGuisantes;
import logica.juego.estrategia.aliado.Disparar;
import logica.juego.estrategia.aliado.GenerarSoles;
import logica.juego.estrategia.aliado.Pasivo;
import logica.juego.estrategia.enemigo.Caminar;
import logica.juego.mapa.Mapa;

public abstract class Modo {
	
	protected BuilderEnemigo builderEnemigo;
	protected BuilderAliado builderAliado;
	protected Mapa mapa;
	protected String ruta;
	
	public Modo(BuilderAliado b1, BuilderEnemigo b2, Mapa m) {
		this.builderAliado = b1;
		this.builderEnemigo = b2;
		this.mapa = m;
	}
	
	public void crearEnemigoComun() {
		this.builderEnemigo.resetear();
		this.builderEnemigo.setDanio(15);
		this.builderEnemigo.setDimensiones(1, 1);
		this.builderEnemigo.setVidaMaxima(100);
		this.builderEnemigo.setVida(100);
		this.builderEnemigo.setVelocidad(1);
		this.builderEnemigo.setMapa(mapa);
		this.builderEnemigo.setEstrategia(new Caminar(this.builderEnemigo.getResultado()));
		this.builderEnemigo.setEntidadGrafica("Enemigo.jpg");
	}
	
	public void crearEnemigoReforzado() {
		this.builderEnemigo.resetear();
		this.builderEnemigo.setDanio(15);
		this.builderEnemigo.setDimensiones(1, 1);
		this.builderEnemigo.setVidaMaxima(100);
		this.builderEnemigo.setVida(100);
		this.builderEnemigo.setVelocidad(1);
		this.builderEnemigo.setMapa(mapa);
		this.builderEnemigo.setBlindaje(new Blindaje(40, this.builderEnemigo.getResultado()));
		this.builderEnemigo.setEstrategia(new Caminar(this.builderEnemigo.getResultado()));
		this.builderEnemigo.setEntidadGrafica("EnemigoReforzado.png");
	}
	
	//Aliados
	
	public void crearLanzaguisante() {
		this.builderAliado.resetear();
		this.builderAliado.setDimensiones(1, 1);
		this.builderAliado.setMapa(mapa);
		this.builderAliado.setVidaMaxima(100);
		this.builderAliado.setVida(100);
		this.builderAliado.setPrecio(100);
		this.builderAliado.setSoles(0);
		this.builderAliado.setEstrategia(new Disparar(this.builderAliado.getResultado()));
		this.builderAliado.setProyectil(new DisparoLanzaGuisantes(this.builderAliado.getResultado()));
		this.builderAliado.setEntidadGrafica("Aliado.png");
	}
	
	public void crearAliadoMuralla() {
		this.builderAliado.resetear();
		this.builderAliado.setDimensiones(1, 1);
		this.builderAliado.setMapa(mapa);
		this.builderAliado.setVidaMaxima(300);
		this.builderAliado.setVida(300);
		this.builderAliado.setPrecio(100);
		this.builderAliado.setSoles(0);
		this.builderAliado.setEstrategia(new Pasivo(this.builderAliado.getResultado()));
		this.builderAliado.setEntidadGrafica("Nuez.jpg");
	}
	
	public void crearAliadoExplosivo() {
		this.builderAliado.resetear();
		this.builderEnemigo.setDimensiones(1, 1);
		this.builderAliado.setMapa(mapa);
		this.builderAliado.setVidaMaxima(100);
		this.builderAliado.setVida(100);
		this.builderAliado.setPrecio(150);
		this.builderAliado.setSoles(0);
		this.builderAliado.setEstrategia(null);
		this.builderAliado.setEntidadGrafica(null);
	}
	
	public void crearGirasol() {
		this.builderAliado.resetear();
		this.builderAliado.setDimensiones(1, 1);
		this.builderAliado.setMapa(mapa);
		this.builderAliado.setVidaMaxima(100);
		this.builderAliado.setVida(100);
		this.builderAliado.setPrecio(75);
		this.builderAliado.setSoles(50);
		this.builderAliado.setEstrategia(new GenerarSoles(this.builderAliado.getResultado()));
		this.builderAliado.setEntidadGrafica("Girasol.jpg");
	}
	
	public abstract List<Enemigo> getListaDeEnemigosFaciles();
	
	public abstract List<Enemigo> getListaDeEnemigosModerados();
	
	public abstract List<Enemigo> getListaDeEnemigosDificiles();
	
	public abstract String getRutaDeFondo();
}
