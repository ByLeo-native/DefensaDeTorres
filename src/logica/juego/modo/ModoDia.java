package logica.juego.modo;

import java.util.ArrayList;
import java.util.List;

import logica.juego.builder.aliado.BuilderAliado;
import logica.juego.builder.enemigo.BuilderEnemigo;
import logica.juego.entidad.aliado.Aliado;
import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.mapa.Mapa;

public class ModoDia extends Modo {
	
	public ModoDia(BuilderAliado b1, BuilderEnemigo b2, Mapa m) {
		super( b1, b2, m);
	}
	
	//Armar enemigos
	
	//Armar aliados
	
//	public void crearGirasol() {
//		this.builderAliado.resetear();
//		this.builderAliado.setMapa(mapa);
//		this.builderAliado.setVidaMaxima(100);
//		this.builderAliado.setVida(100);
//		this.builderAliado.setPrecio(75);
//		this.builderAliado.setSoles(50);
//		this.builderAliado.setEstrategia(null);
//		this.builderAliado.setEntidadGrafica(null);
//	}
	
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
		return "FondoDia.jpeg";
	}
	
	public String[] getComandosParaCartas() {
		String [] aux = {"LanzaGuisantes", "Nuez", "Girasol"};
		return aux;
	}
	
}
