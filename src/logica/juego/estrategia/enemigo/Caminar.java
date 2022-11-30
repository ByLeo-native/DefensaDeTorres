package logica.juego.estrategia.enemigo;

import grafica.entidadGrafica.EntidadGrafica;
import logica.juego.Juego;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.mapa.fila.Fila;
import logica.juego.visitor.VisitorTimer;

public class Caminar extends EstrategiaEnemigo {
	
	protected Juego juego;

	public Caminar(Enemigo e) {
		super(e);
		this.juego = this.enemigo.getMapa().getJuego();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actuar() {
		EntidadGrafica grafico = this.enemigo.getEntidadGrafica();
		int posX = grafico.getPunto().x;
		int posY = grafico.getPunto().y;
		int dimensionY = grafico.getDimensionY();
		if(posX==0)
			this.juego.perder();
		if((posX-1>=0)){
			for(int j = this.enemigo.getPosicionY(); j < this.enemigo.getPosicionY()+this.enemigo.getDimensionY();j++){//Creo que revisa que hay en la celda que sigue
				Fila f = this.enemigo.getMapa().getFila(j);
				if(f!=null)
					f.chequearColision(enemigo, this.enemigo.getVisitorColision());
			}
			if(this.enemigo.estaVivo()){ //Si se puede mover
				//((GraphicEnemigo)grafico).avanzar();
				grafico.cambiarDePosicion(grafico.getPunto().x - this.enemigo.getVelocidad(), grafico.getPunto().y); //Cambia la posicion del grafico desplazandolo utilizando la velocidad
			}
			else{
				//grafico.setImageIdle();
			}
		}
	}
	
	public void kill() {
		super.kill();
		this.juego = null;
	}
	
	@Override
	public void accept(VisitorTimer v) {
		v.visit(this);
	}

}
