package logica.juego.entidad.proyectil;

import logica.juego.entidad.aliado.Aliado;

public class DisparoLanzaGuisantes extends Proyectil {

	public DisparoLanzaGuisantes(Aliado a) {
		super(a);
		this.mapa = a.getMapa();
		this.danio = 15;
		this.velocidad = 15;
		this.vida = 1;
		this.dimensionX = 1;
		this.dimensionY = 1;
		this.setEntidadGrafica("disparoLanzaGuisantes.png");
	}

}
