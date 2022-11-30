package logica.juego.hilo.enemigo;

import java.util.ArrayList;
import java.util.List;

import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.nivel.Nivel;

public abstract class TimerEnemigo implements Runnable {
	protected volatile boolean execute;
	protected Nivel nivelActual;
	protected volatile List<Enemigo> enEjecucion, paraInsertar, paraEliminar;
	protected int tiempo;
	
	public TimerEnemigo() {
		this.paraInsertar = new ArrayList<Enemigo>();
		this.paraEliminar = new ArrayList<Enemigo>();
		this.enEjecucion = new ArrayList<Enemigo>();
		this.execute = true;
	}
	
	public void agregarEnemigo(Enemigo e){
		paraInsertar.add(e);
	}
	
	public void eliminarEnemigo(Enemigo e){
		paraEliminar.add(e);
	}
	
	public void terminate(){
		execute=false;
	}
	
	protected void actualizar(){
		int x= paraInsertar.size();
		for(int i=0;i<x;i++){
			enEjecucion.add(paraInsertar.remove(0));
		}
		int y= paraEliminar.size();
		for(int i=0;i<y;i++){
			enEjecucion.remove(paraEliminar.remove(0));
		}
	}
	
	public void run(){
		while(execute){
			actualizar();
			int x= enEjecucion.size();
			for(int i=0;i<x;i++){
				enEjecucion.get(i).actuar();
			}
			try{
				Thread.sleep(tiempo);
			}catch(InterruptedException e){
			}
		}
	}
	
}
