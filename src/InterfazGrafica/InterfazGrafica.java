package InterfazGrafica;



import grafica.panel.PanelInformacion;
import grafica.panel.PanelInicio;
import grafica.panel.PanelJuego;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfazGrafica extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ImageIcon image = new ImageIcon("src/Sprites/IconosBotones/Hojas.gif");
	private static final int AnchoVentana=1200,AltoVentana=720;
	private PanelJuego gui;
	private PanelInicio inicio;
	private PanelInformacion informacion;
	public static Properties configuration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica frame = new InterfazGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazGrafica() {
		super("Tower Defense");
		this.loadConfigurations();
//		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 0, AnchoVentana, AltoVentana);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		inicio = new PanelInicio(this);
		informacion = new PanelInformacion(this);
		contentPane.add(inicio);
	}
	
	public void cambiar(JPanel actual, JPanel nuevo){
		contentPane.remove(actual);
		contentPane.add(nuevo);
		contentPane.repaint();
	}
	public int getAncho(){
		return AnchoVentana;
	}
	public int getAlto(){
		return AltoVentana;
	}
	public PanelJuego getGUIJuego(){
		return gui;
	}
	public void cambiarJuego(PanelJuego g){
		gui=g;
	}
	public PanelInicio getInicio(){
		return inicio;
	}
	public PanelInformacion getInformacion(){
		return informacion;
	}
	
	private void loadConfigurations() {
		try (InputStream input = new FileInputStream("./configuration.properties")) {
            this.configuration = new Properties();
            this.configuration.load(input);
        } catch (IOException io) {
            io.printStackTrace();
        }
	}
	
}
