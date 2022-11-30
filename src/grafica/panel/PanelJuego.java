package grafica.panel;

import javax.swing.JPanel;

import InterfazGrafica.InterfazGrafica;
import grafica.panel.aliados.PanelAliados;
import grafico.mapaGrafico.MapaGrafico;
import logica.juego.Juego;

public class PanelJuego extends JPanel {
	
	protected InterfazGrafica interfaz;
	protected MapaGrafico mapaGrafico;
	protected Juego juego;
	protected int anchoVentana, altoVentana;
	protected PanelAliados panelAliados;
	protected int cantidadDeFilas = Integer.parseInt(this.interfaz.configuration.getProperty("cantidadDeFilas"));
	protected int cantidadDeColumnas = Integer.parseInt(this.interfaz.configuration.getProperty("cantidadDeColumnas"));
	protected int alturaDeLaFila = Integer.parseInt(this.interfaz.configuration.getProperty("alturaDeCadaFila"));
	
	public PanelJuego(InterfazGrafica ventana) {
		super();
		this.interfaz = ventana;
		this.anchoVentana = this.interfaz.getAncho(); 
		this.altoVentana = this.interfaz.getAlto();
		setBounds(0, 0, this.anchoVentana, this.altoVentana);
		this.setLayout(null);
		this.setFocusable(true);
		
		this.mapaGrafico = new MapaGrafico();
		this.mapaGrafico.setBounds(0, 0, cantidadDeColumnas*alturaDeLaFila, cantidadDeFilas*alturaDeLaFila);
		this.add(this.mapaGrafico);
	}
	
	public void crearJuego(String modo) {
		this.juego = new Juego(this, modo);
		this.panelAliados = new PanelAliados(juego, anchoVentana, altoVentana, this.juego.getNivel().generarComandosDeAliadosDisponibles());
		this.panelAliados.setBounds(cantidadDeColumnas*alturaDeLaFila, 0, 300, 200);
		this.add(this.panelAliados);
	}
	
	public void iniciar() {
		this.juego.iniciarPartida();
	}
	
	public MapaGrafico getMapaGrafico() {
		return this.mapaGrafico;
	}
	
	public void terminate(){
		if(juego!=null)
			juego.finalizar();
	}

}
