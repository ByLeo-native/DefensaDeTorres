package logica.juego.mapa;

import grafico.mapaGrafico.MapaGrafico;
import logica.juego.Juego;
import logica.juego.entidad.Entidad;
import logica.juego.mapa.fila.Fila;

public class Mapa {

	protected Juego juego;
	protected Fila[] filas;
	protected MapaGrafico mapaGrafico;
	
	public Mapa( Juego j, MapaGrafico map, int cant) {
		this.juego = j;
		this.filas = new Fila [cant];
		this.mapaGrafico = map;
		this.mapaGrafico.setMapa(this);
		int alturaDeLaFila = (int)(map.getAlto()/cant);
		for(int i = 0; i < cant; i++) {
			this.filas[i] = new Fila(0, i*alturaDeLaFila, map.getAncho(), alturaDeLaFila);
		}
	}
	
	public boolean agregarEntidad(Entidad e) {
		int cantidadDeColumnas = Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("cantidadDeColumnas"));
		int x = e.getPosicionX();
		int y = e.getPosicionY();
		int dx = e.getDimensionX();
		int dy = e.getDimensionY();
		boolean agregado=false;
		if( x>=0 && x<=cantidadDeColumnas)
			if((y>=0) && ( (y+dy-1) < this.getCantidadDeFilas())){
				for(int i=x;i<x+dx;i++)
					for(int j=y;j<y+dy;j++){
						if( i <= cantidadDeColumnas){
							this.agregarEntidad(e, j);
							agregado = true;
						}
					}
				this.mapaGrafico.agregarEntidadGrafica(e.getEntidadGrafica());
				this.mapaGrafico.repaint();
				e.getEntidadGrafica().agregarGraficosAsociados();
			}
		return agregado;
	}
	
	protected void agregarEntidad(Entidad e, int fila) {
		this.filas[fila].agregarEntidad(e);
	}
	
	public void removerEntidad(Entidad e) {
		this.filas[e.getPosicionY()].removerEntidad(e);
		this.mapaGrafico.removerEntidadGrafica(e.getEntidadGrafica());
	}
	
	public void removerEntidad(Entidad e, int fila) {
		this.filas[fila].removerEntidad(e);
	}
	
	public Fila getFila(int fila) {
		return this.filas[fila];
	}

	public Juego getJuego() {
		return this.juego;
	}

	public int getCantidadDeFilas() {
		return this.filas.length;
	}

	public void limpiar() {
		for(int i = 0; i < this.filas.length; i++) {
			this.filas[i].limpiar();
		}
	}

	public void setFondo(String s) {
		this.mapaGrafico.setFondo(s);
		
	}
}
