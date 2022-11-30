package logica.juego.horda;

import java.util.ArrayList;
import java.util.List;

import logica.juego.entidad.enemigo.Enemigo;

public class Horda {
	
	protected Enemigo siguienteEnemigoALanzar;
	protected List<Enemigo> enemigosAEnviar;
	protected List<Enemigo> enemigosEnMapa;
	protected int tiempoCreacional;
	
	public Horda() {
		this.enemigosAEnviar = new ArrayList<Enemigo>();
		this.enemigosEnMapa = new ArrayList<Enemigo>();
	}
	
	public Enemigo getSiguienteEnemigo() {
		if(!enemigosAEnviar.isEmpty()){
			Enemigo e = enemigosAEnviar.remove(0);
			enemigosEnMapa.add(e);
			return e;
		}
		return null;
	}
	
	public boolean quedanEnemigos() {
		return this.siguienteEnemigoALanzar == null;
	}

	public boolean estaCompleta() {
		return (this.enemigosAEnviar.isEmpty() && this.enemigosEnMapa.isEmpty());
	}

	public int getTiempoCreacional() {
		return this.tiempoCreacional;
	}
	
	public int cantEnemigos(){
		return this.enemigosAEnviar.size();
	}
	
	public void setTiempoCreacional(int t){
		this.tiempoCreacional=t;
	}
	public void agregar(Enemigo e){
		this.enemigosAEnviar.add(e);
	}
	
	public boolean hayEnemigos(){
		return !this.enemigosAEnviar.isEmpty();
	}
	
	public void removeEnemieInMap(Enemigo e){
		this.enemigosEnMapa.remove(e);
	}
}
