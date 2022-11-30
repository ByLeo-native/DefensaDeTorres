package logica.juego.accion;

import logica.juego.entidad.aliado.Aliado;
import logica.juego.mapa.Mapa;
import logica.juego.mapa.fila.Fila;
import logica.juego.nivel.Nivel;
import logica.juego.visitor.VisitorAniadirATimer;
import logica.juego.visitor.VisitorTimer;

public class CreadorAliado implements Accion {
	
	protected boolean disponible;
	protected Nivel nivel; //Nivel me define cual enemigo y aliado puedo crear
	protected Aliado aliado;
	protected String comando;
	protected VisitorTimer visitorTimerAniadir;
	
	public CreadorAliado(Nivel n, String s) {
		this.nivel = n;
		this.comando = s;
		this.visitorTimerAniadir = new VisitorAniadirATimer(this.nivel.getMapa().getJuego());
	}
	
	protected void agregar(Mapa m){
		this.disponible = true;
		if((nivel.getPresupuesto()-aliado.getPrecio()>=0)){
			for(int i=aliado.getPosicionX();(i<(aliado.getDimensionX()+aliado.getPosicionX()))&&disponible;i++){
				for(int j=aliado.getPosicionY();j<(aliado.getDimensionY()+aliado.getPosicionY())&&disponible;j++){
					Fila f = m.getFila(j);
					f.chequearColision(aliado, this.aliado.getColisionAliado());
				}
			}
			if(disponible){
				m.agregarEntidad(aliado);
				aliado.getEstrategia().accept(visitorTimerAniadir);
				//m.getJuego().getAtaqueAliado().agregarAliado(aliado);
				nivel.setPresupueto(nivel.getPresupuesto()-aliado.getPrecio());
			}
		}
	}
	
	public void actuar() {
		this.nivel.getMapa().agregarEntidad(this.nivel.crearLanzaguisantes());
	}

	@Override
	public void ejecutarAccion(int x, int y, Mapa m) {
		this.crearAliado();
		this.aliado.setPosicion(x, y);
		this.agregar(m);
	}
	
	protected void crearAliado() {
		if(this.comando == "LanzaGuisantes") {
			this.aliado = this.nivel.crearLanzaguisantes();
		} else if(this.comando == "Nuez") {
			this.aliado = this.nivel.crearAliadoMuralla();
		} else if(this.comando == "Girasol") {
			this.aliado = this.nivel.crearGirasol();
		}
	}
	
	public void setDisponible(boolean b) {
		this.disponible = b;
	}
}
