package logica.juego.modo;

import java.util.ArrayList;
import java.util.List;

import logica.juego.builder.aliado.BuilderAliado;
import logica.juego.builder.enemigo.BuilderEnemigo;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.mapa.Mapa;

public class ModoNoche extends Modo {

	public ModoNoche(BuilderAliado b1, BuilderEnemigo b2, Mapa m) {
		super( b1, b2, m);
	}
	
	//Armar enemigos
	
	
	//Armar aliados

	@Override
	public List<Enemigo> getListaDeEnemigosFaciles() {
		List<Enemigo> l = new ArrayList<Enemigo>();
		return l;
	}

	@Override
	public List<Enemigo> getListaDeEnemigosModerados() {
		List<Enemigo> l = new ArrayList<Enemigo>();
		return l;
	}

	@Override
	public List<Enemigo> getListaDeEnemigosDificiles() {
		List<Enemigo> l = new ArrayList<Enemigo>();
		return l;
	}

	@Override
	public String getRutaDeFondo() {
		return "FondoNoche.jpeg";
	}
}
