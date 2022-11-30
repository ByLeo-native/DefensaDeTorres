package logica.juego.hilo;

import logica.juego.Juego;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.horda.Horda;
import logica.juego.nivel.Nivel;

public class TimerGeneracionDeEnemigo implements Runnable {
	
	private Juego juego;
	private Nivel nivelActual;
	private Horda hordaActual;
	private int tiempo, numEne, cantDeEnemigos;
	private int tiempoInicialEspera;
	private volatile boolean execute;
	protected boolean pausa=false;
	
	public TimerGeneracionDeEnemigo(Juego j){
		this.juego = j;
		this.nivelActual = juego.getNivel();
		if(nivelActual!=null) { this.cantDeEnemigos = nivelActual.getCantEnemigosTotal();}
		this.numEne=0;
		this.hordaActual=nivelActual.getHordaActual();
		this.execute=true;
		this.tiempo=0;
		this.tiempoInicialEspera=0;
	}
	public void pausar(){
		pausa=true;
	}
	public void reanudar(){
		pausa=false;
	}
	
	public void terminate(){
		execute=false;
	}
	public void run(){
		while(execute){
			if(!pausa){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
				}
				if(tiempoInicialEspera<7){
					tiempoInicialEspera++;
				}
				else{
					if(hordaActual==null){
						nivelActual = juego.siguienteNivel();
						//juego.getGui().getPanelSuperior().actualizarNumHordas();
						if(nivelActual==null)
							juego.ganar();
						else{
							hordaActual=nivelActual.getHordaActual();
							cantDeEnemigos=nivelActual.getCantEnemigosTotal();
							numEne=0;
							//juego.getGui().getPanelSuperior().actualizarLevelProgress(numEne, cantDeEnemigos);
							//juego.getGui().getPanelSuperior().nextNumLevel();
						}
						//juego.getGui().repaint();
						tiempoInicialEspera=0;
					}
					else{
						if(hordaActual.estaCompleta()){
							nivelActual.siguienteHorda();
							hordaActual=nivelActual.getHordaActual();
							if(hordaActual!=null){
								//nivelActual.getMapa().agregarObstaculos(3, 3);
								if(execute) {
									//juego.getGui().getPanelSuperior().actualizarNumHordas();
								}
							}
						}
						else if(hordaActual.hayEnemigos()){
							tiempo++;
							if(hordaActual.getTiempoCreacional()==tiempo){
								numEne++;
								//juego.getGui().getPanelSuperior().actualizarLevelProgress(numEne, cantDeEnemigos);
								tiempo=0;
								Enemigo e = nivelActual.getHordaActual().getSiguienteEnemigo();
								nivelActual.getMapa().agregarEntidad(e);
								nivelActual.getMapa().getJuego().getAtaqueAliado().agregarCantidad(e.getPosicionY());
								nivelActual.getMapa().getJuego().getMovimientoEnemigo().agregarEnemigo(e);
								nivelActual.getMapa().getJuego().getAtaqueEnemigo().agregarEnemigo(e);
							}
						}
						
					}
				}
			}
		}
	}
}
