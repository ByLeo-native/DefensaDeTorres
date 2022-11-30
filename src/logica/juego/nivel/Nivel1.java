package logica.juego.nivel;

import java.util.Random;

import logica.juego.entidad.enemigo.Enemigo;
import logica.juego.horda.Horda;
import logica.juego.mapa.Mapa;

public class Nivel1 extends Nivel {

	public Nivel1(Mapa m) {
		super(m);
		this.presupuesto = 100;
		for(int i=0;i<hordas.length;i++) {
			hordas[i].setTiempoCreacional(5);
		}
	}

	@Override
	protected void generarPrimeraHorda() {
		Random r = new Random();
		int alturaDeCadaFila = Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("alturaDeCadaFila"));
		int anchoDeCadaColumna = Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("anchoDeCadaColumna"));
		int cantidadDeColumnas = Integer.parseInt(InterfazGrafica.InterfazGrafica.configuration.getProperty("cantidadDeColumnas"));
		int aux;
		Horda horda = this.hordas[0];
		//Horda1
		for(int i=0;i<10;i++){
			modo.crearEnemigoComun();
			aux = r.nextInt(this.mapa.getCantidadDeFilas());
			Enemigo e = this.builderEnemigo.getResultado();
			e.setPosicion(cantidadDeColumnas, aux);
			horda.agregar(e);
		}
		for(int i=0;i<3;i++){
			modo.crearEnemigoReforzado();;
			aux = r.nextInt(this.mapa.getCantidadDeFilas());
			Enemigo e = this.builderEnemigo.getResultado();
			e.setPosicion(cantidadDeColumnas, aux);
			horda.agregar(e);
		}
		
	}

	@Override
	protected void generarSegundaHorda() {
		Horda horda = this.hordas[1];
		
	}

	@Override
	protected void generarTerceraHorda() {
		Horda horda = this.hordas[2];
		
	}

	@Override
	protected void generarCuartaHorda() {
		Horda horda = this.hordas[3];
		
	}

	@Override
	protected void generarQuintaHorda() {
		Horda horda = this.hordas[4];
		
	}

	@Override
	public String[] generarComandosDeAliadosDisponibles() {
		String [] aux = {"LanzaGuisantes" , "Nuez", "Girasol"};
		return aux;
	}

	@Override
	public String[] generarComandosDeEnemigosDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Nivel getSiguienteNivel(){
		this.mapa.limpiar();
		this.mapa.getJuego().terminarTodosLosHilos();
		//this.mapa.getJuego().getGui().getPanelPrincipal().remove(map.getMapaGrafico());
		//this.mapa.getJuego().getGui().getPanelPrincipal().repaint();
		return new Nivel2(this.mapa);
	}

}
