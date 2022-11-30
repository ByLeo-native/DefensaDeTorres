package logica.juego;

import grafica.panel.PanelJuego;
import logica.juego.accion.Accion;
import logica.juego.accion.CreadorAliado;
import logica.juego.hilo.TimerGeneracionDeEnemigo;
import logica.juego.hilo.aliado.TimerAliado;
import logica.juego.hilo.aliado.TimerAtaqueAliado;
import logica.juego.hilo.aliado.TimerGeneracionDeSoles;
import logica.juego.hilo.enemigo.TimerAtaqueEnemigo;
import logica.juego.hilo.enemigo.TimerEnemigo;
import logica.juego.hilo.enemigo.TimerMovimientoEnemigo;
import logica.juego.hilo.proyectil.TimerProyectil;
import logica.juego.horda.Horda;
import logica.juego.mapa.Mapa;
import logica.juego.nivel.Nivel;
import logica.juego.nivel.Nivel1;

public class Juego {

	protected PanelJuego panel;
	protected Mapa mapa;
	protected Nivel nivelActual;
	protected CreadorAliado accion;
	protected TimerGeneracionDeEnemigo generador;
	protected TimerProyectil timerMovimientoDeProyectiles;
	protected TimerAliado timerGeneracionDeSoles;
	protected TimerAtaqueAliado timerAtaqueAliado;
	protected TimerEnemigo timerDeMovimiento, timerDeAtaqueEnemigo;
	protected Thread hiloDeGeneracion, hiloDeMovimiento, hiloDeAtaqueEnemigo, hiloDeAtaqueAliado, hiloDeMovimientoDeProyectiles, hiloDeSoles;
	
	public Juego(PanelJuego p, String modo) {
		this.panel = p;
		this.mapa = new Mapa( this, p.getMapaGrafico(), 6);
		this.nivelActual = new Nivel1(mapa); //Nivel necesita un modo pero modo necesita los builder de Nivel
		this.nivelActual.setModo(modo);
		this.nivelActual.generarHordas();
		this.timerDeMovimiento = new TimerMovimientoEnemigo();
		this.timerDeAtaqueEnemigo = new TimerAtaqueEnemigo();
	}
	
	public void iniciarPartida() {
		this.iniciarGeneracionDeEnemigos();
		this.iniciarGeneracionDeSoles();
		this.iniciarTimerMovimiento();
		this.iniciarAtaqueAliado();
		this.iniciarAtaqueEnemigo();
		this.iniciarMovimientoDeProyectiles();
	}
	
	protected void iniciarTimerMovimiento() {
		this.timerDeMovimiento = new TimerMovimientoEnemigo();
		this.hiloDeMovimiento = new Thread(this.timerDeMovimiento);
		this.hiloDeMovimiento.start();
	}
	
	
	protected void iniciarGeneracionDeEnemigos() {
		this.generador = new TimerGeneracionDeEnemigo(this);
		this.hiloDeGeneracion	= new Thread(this.generador);
		this.hiloDeGeneracion.start();
	}
	
	protected void iniciarAtaqueAliado() {
		this.timerAtaqueAliado = new TimerAtaqueAliado(this.mapa);
		this.hiloDeAtaqueAliado = new Thread(this.timerAtaqueAliado);
		this.hiloDeAtaqueAliado.start();
	}
	
	protected void iniciarAtaqueEnemigo() {
		this.timerDeAtaqueEnemigo = new TimerAtaqueEnemigo();
		this.hiloDeAtaqueEnemigo = new Thread(this.timerDeAtaqueEnemigo);
		this.hiloDeAtaqueEnemigo.start();
	}
	
	protected void iniciarMovimientoDeProyectiles() {
		this.timerMovimientoDeProyectiles = new TimerProyectil();
		this.hiloDeMovimientoDeProyectiles = new Thread(this.timerMovimientoDeProyectiles);
		this.hiloDeMovimientoDeProyectiles.start();
	}
	
	protected void iniciarGeneracionDeSoles() {
		this.timerGeneracionDeSoles = new TimerGeneracionDeSoles(5000);
		this.hiloDeSoles = new Thread(this.timerGeneracionDeSoles);
		this.hiloDeSoles.start();
	}
	
	public void establecerAccion(CreadorAliado a) {
		this.accion = a;
	}

	public void ejecutarAccion(int x, int y) {
		if(this.accion != null) {
			this.accion.ejecutarAccion(x, y, mapa);;
			this.accion = null;
		}
	}

	public Nivel getNivel() {
		return this.nivelActual;
	}

	public void terminarTodosLosHilos() {
		// TODO Auto-generated method stub
		
	}

	public void perder(){
		finalizar();
		//player.playDerrota();
		//this.panel.perder();
		//this.panel.finalizar();
	}
	
	public void finalizar(){
		this.nivelActual.getMapa().limpiar();
		this.terminarTodosLosHilos();;
		generador.terminate();
	}
	
	public void iniciar(){
		if(generador==null){
			this.generador = new TimerGeneracionDeEnemigo(this);
			this.hiloDeGeneracion = new Thread(this.generador);
			this.hiloDeGeneracion.start();
		}
	}
	
	public void ganar(){
		this.generador.terminate();
		this.hiloDeGeneracion.stop();
		//this.panel.finalizar();
		//player.playVictoria();
		//this.panel.ganar();
	}
	
	public PanelJuego getPanel(){
		return panel;
	}

	public TimerEnemigo getMovimientoEnemigo() {
		return this.timerDeMovimiento;
	}
	
	public TimerEnemigo getAtaqueEnemigo() {
		return this.timerDeAtaqueEnemigo;
	}

	public Nivel siguienteNivel(){
		this.nivelActual = this.nivelActual.getSiguienteNivel();
		return this.nivelActual;
	}

	public TimerAtaqueAliado getAtaqueAliado() {
		return this.timerAtaqueAliado;
	}
	
	public TimerProyectil getMovimientoDeProyectiles() {
		return this.timerMovimientoDeProyectiles;
	}
	
	public TimerAliado getGeneracionDeSoles() {
		return this.timerGeneracionDeSoles;
	}
	
	public void noPermitirAgregarAliado() {
		this.accion.setDisponible(false);
	}
	
}
