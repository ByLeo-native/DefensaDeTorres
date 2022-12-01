package grafica.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import InterfazGrafica.InterfazGrafica;
import music.Player;

public class PanelInicio extends JPanel {
	
	protected JLabel fondo;
	protected InterfazGrafica interfaz;
	protected JButton [] botones;
	protected final String dir = "src/assets/";
	protected Player player;

	public PanelInicio(InterfazGrafica interfazGrafica) {
		super();
		this.player = new Player();
		this.player.playInicioDeJuego();
		this.interfaz = interfazGrafica;
		setLayout(null);
		setBounds(0,0,interfazGrafica.getAncho()-15,interfazGrafica.getAlto()-40);
		
		fondo = new JLabel("");
		fondo.setBounds(0, 0, 1186, 773);
		ImageIcon icon = new ImageIcon(dir+"Paneles/FondoInicio.jpg");
		icon = new ImageIcon(icon.getImage().getScaledInstance(1186, 773, BufferedImage.SCALE_SMOOTH));
		fondo.setIcon (icon);
		armarBotones();
		add(fondo);
	}
	
	protected void armarBotones(){
		String[] command = {"ModoDia","ModoNoche"};
		botones = new JButton[command.length];
		OyenteBotones oyente = new OyenteBotones();
		ImageIcon icon = null;
		for(int i=0;i<botones.length;i++){
			icon = new ImageIcon(dir+"Paneles/"+command[i]+".jpeg");
			icon = new ImageIcon(icon.getImage().getScaledInstance(115, 37, BufferedImage.SCALE_SMOOTH));
			botones[i] = new JButton();
			botones[i].setBorder(null);
			botones[i].setBorderPainted(false);
			botones[i].setContentAreaFilled(false);
			botones[i].setActionCommand(command[i]);
			botones[i].setBounds(600,(i+1)*50 + 526,110,33);
			botones[i].setFocusable(false);
			botones[i].addActionListener(oyente);
			//botones[i].setIcon(new ImageIcon(dir+command[i]+".jpeg"));
			botones[i].setIcon(icon);
			add(botones[i]);
		}
	}
	
	private class OyenteBotones implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
			switch(s){
				case("ModoDia"):{
					crearJuego("Dia");
					break;
				}
				case("ModoNoche"):{
					crearJuego("Noche");
					break;
				}
				case("Informacion"):{
					cambiar(interfaz.getInformacion());
					break;
				}
				case("Salir"):{
					PanelJuego g =interfaz.getGUIJuego();
					if(g!=null)
						g.terminate();
					interfaz.dispose();
					break;
				}
			}
		}
	}
	
	protected void crearJuego(String s) {
		this.player.close();
		PanelJuego g = interfaz.getGUIJuego();
		if(g!=null){
			g.terminate();
		}
		g = new PanelJuego(interfaz);
		g.crearJuego(s);
		interfaz.cambiarJuego(g);
		cambiar(g);
		g.iniciar();
	}
	
	private void cambiar(JPanel panel){
		interfaz.cambiar(this, panel);
	}

}
