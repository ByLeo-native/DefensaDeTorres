package logica.juego.hilo.proyectil;

import java.util.ArrayList;
import java.util.List;

import logica.juego.entidad.proyectil.Proyectil;
import logica.juego.nivel.Nivel;

public class TimerProyectil implements Runnable {
	protected volatile boolean execute;
	protected Nivel nivelActual;
	protected volatile List<Proyectil> enEjecucion, paraInsertar, paraEliminar;
	protected int tiempo;
	
	public TimerProyectil() {
		this.paraInsertar = new ArrayList<Proyectil>();
		this.paraEliminar = new ArrayList<Proyectil>();
		this.enEjecucion = new ArrayList<Proyectil>();
		this.execute = true;
		this.tiempo = 50;
	}
	
	public void agregarProyectil(Proyectil e){
		paraInsertar.add(e);
	}
	
	public void eliminarProyectil(Proyectil e){
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
