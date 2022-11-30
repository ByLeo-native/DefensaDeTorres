package logica.juego.hilo.aliado;

import java.util.ArrayList;
import java.util.List;

import logica.juego.entidad.aliado.Aliado;
import logica.juego.nivel.Nivel;

public class TimerAliado implements Runnable {
	protected volatile boolean execute;
	protected Nivel nivelActual;
	protected volatile List<Aliado> enEjecucion, paraInsertar, paraEliminar;
	protected int tiempo;
	
	public TimerAliado() {
		this.paraInsertar = new ArrayList<Aliado>();
		this.paraEliminar = new ArrayList<Aliado>();
		this.enEjecucion = new ArrayList<Aliado>();
		this.execute = true;
	}
	
	public void agregarAliado(Aliado e){
		paraInsertar.add(e);
		System.out.println("Se añadio");
	}
	
	public void eliminarAliado(Aliado e){
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
