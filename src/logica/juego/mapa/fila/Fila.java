package logica.juego.mapa.fila;

import java.util.ArrayList;
import java.util.List;

import logica.juego.entidad.Entidad;
import logica.juego.visitor.Visitor;

public class Fila {
	protected int posicionX;
	protected int posicionY;
	protected int dimensionX;
	protected int dimensionY;
	protected List<Entidad> entidades;
	
	public Fila(int x, int y, int dx, int dy) {
		this.posicionX = x;
		this.posicionY = y;
		this.dimensionX = dx;
		this.dimensionY = dy;
		this.entidades = new ArrayList<Entidad>();
	}
	
	public int getPosicionX() {
		return this.posicionX;
	}
	
	public int getPosicionY() {
		return this.posicionY;
	}
	
	public void setPosicionX( int x ) {
		this.posicionX = x;
	}
	
	public void setPosicionY( int y ) {
		this.posicionY = y;
	}
	
	public int getDimensionX() {
		return this.dimensionX;
	}
	
	public int getDimensionY() {
		return this.dimensionY;
	}
	
	public void agregarEntidad(Entidad e) {
		this.entidades.add(e);
	}
	
	public void removerEntidad(Entidad e) {
		this.entidades.remove(e);
	}

	public void limpiar() {
		int x = entidades.size();
		for(int i = 0;i<x;i++)
			if(!entidades.isEmpty())
				entidades.get(0).kill();
	}
	
	public void accept(Visitor v){
		int size = this.entidades.size();
		int i=0;
		while(i<size){
			this.entidades.get(i).accept(v);
			i++;
			size = this.entidades.size();
		}
	}
	
	public void chequearColision(Entidad e1, Visitor v) {
		int size = this.entidades.size();
		int i=0;
		while(i<size){
			Entidad e = this.entidades.get(i);
			if( !e.equals(e1) && this.colisionan(e, e1)) {
				e.accept(v);
			}
			i++;
			size = this.entidades.size();
		}
	}
	
	protected boolean colisionan(Entidad e1, Entidad e2) {
		int x1 = e1.getEntidadGrafica().getPunto().x;
		int y1 = e1.getEntidadGrafica().getPunto().y;
		int dx1 = e1.getEntidadGrafica().getDimensionX();
		int dy1 = e1.getEntidadGrafica().getDimensionY();
		
		int x2 = e2.getEntidadGrafica().getPunto().x;
		int y2 = e2.getEntidadGrafica().getPunto().y;
		int dx2 = e2.getEntidadGrafica().getDimensionX();
		int dy2 = e2.getEntidadGrafica().getDimensionY();
		
		boolean a = ( (x1 < x2) && (x2 < (x1 + dx1)));
		boolean b = ( (y1 <= y2) && (y2 <= (y1 + dy1)));
		boolean c = ( (x1 < (x2 + dx2)) && ((x2 + dx2) < ( x1 + dx1)) );
		boolean d = ( (y1 <= (y2 + dy2)) && ((y2 + dy2) <= ( y1 + dy1)) );
		
		return ( !a || b || !c || d )&&( !a || b || c || d )&&( a || !b || c || !d )&&( a || !b || c || d )&&( a || b || !c || d )&&( a || b || c || !d )&&( a || b || c || d );
	}
}
