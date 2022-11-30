package logica.juego.nivel;

import java.util.List;

import logica.juego.builder.aliado.BuilderAliado;
import logica.juego.builder.enemigo.BuilderEnemigo;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.horda.Horda;
import logica.juego.mapa.Mapa;
import logica.juego.modo.Modo;
import logica.juego.modo.ModoDia;
import logica.juego.modo.ModoNoche;

public abstract class Nivel {
	
	protected int presupuesto;
	protected Mapa mapa;
	protected Modo modo;
	protected Horda [] hordas;
	protected int hordaActual;
	protected BuilderAliado builderAliado;
	protected BuilderEnemigo builderEnemigo;
	protected List<Aliado> aliadosDisponibles;
	protected List<Enemigo> enemigosDisponibles;
	
	public Nivel(Mapa m) {
		this.mapa = m;
		this.builderAliado = new BuilderAliado(this.mapa);
		this.builderEnemigo = new BuilderEnemigo(this.mapa);
		this.hordas = new Horda [5];
		for(int i = 0; i < this.hordas.length; i++) {
			this.hordas[i] = new Horda();
		}
		this.hordaActual = 0;
	}
	
	public void setModo(String s) {
		if(s == "Dia") {
			this.modo = new ModoDia(builderAliado, builderEnemigo, mapa);
		} else if(s == "Noche") {
			this.modo = new ModoNoche(builderAliado, builderEnemigo, mapa);
		}
		this.mapa.setFondo(this.modo.getRutaDeFondo());
	}
	
	/**
	 * Devuelve la cantidad de presupuesto disponible.
	 * @return int entero correspondiente a la cantidad de presupuesto disponible.
	 */
	public int getPresupuesto() {
		return this.presupuesto;
	}
	
	/**
	 * Establece la cantidad de presupuesto disponible.
	 * @param p int entero del presupuesto a actualizar.
	 */
	public void setPresupueto(int p){
		if(p<0)
			presupuesto=0;
		else
			presupuesto = p;
	}

	public int getCantEnemigosTotal() {
		int cant=0;
		for(int i=0;i<hordas.length;i++)
			cant+=hordas[i].cantEnemigos();
		return cant;
	}

	/**
	 * Devuelve la horda actual, si no hay devuelve null.
	 * @return Horda.
	 */
	public Horda getHordaActual(){
		if(hordaActual<hordas.length)
			return hordas[hordaActual];
		else
			return null;
	}

	/**
	 * Si queda una siguiente horda
	 */
	public void siguienteHorda() {
		if(hordaActual<hordas.length)
			hordaActual++;
	}

	public Mapa getMapa() {
		return this.mapa;
	}
	
	public void generarHordas() {
		this.generarPrimeraHorda();
		this.generarSegundaHorda();
		this.generarTerceraHorda();
		this.generarCuartaHorda();
		this.generarQuintaHorda();
	}
	
	public Aliado crearLanzaguisantes() {
		this.modo.crearLanzaguisante();
		return this.builderAliado.getResultado();
	}
	
	public Aliado crearAliadoMuralla() {
		this.modo.crearAliadoMuralla();
		return this.builderAliado.getResultado();
	}
	
	public Aliado crearAliadoExplosivo() {
		this.modo.crearAliadoExplosivo();
		return this.builderAliado.getResultado();
	}
	
	public Aliado crearGirasol() {
		this.modo.crearGirasol();
		return this.builderAliado.getResultado();
	}
	
	public abstract Nivel getSiguienteNivel();
	
	protected abstract void generarPrimeraHorda();
	
	protected abstract void generarSegundaHorda();
	
	protected abstract void generarTerceraHorda();
	
	protected abstract void generarCuartaHorda();
	
	protected abstract void generarQuintaHorda();
	
	public abstract String[] generarComandosDeAliadosDisponibles();
	
	public abstract String[] generarComandosDeEnemigosDisponibles();
	
}
