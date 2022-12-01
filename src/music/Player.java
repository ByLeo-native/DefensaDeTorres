package music;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Player {
	Clip clip;
	public Player(){
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void playInicioDeJuego() {
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/music/BGM.wav").getAbsoluteFile());
	        clip.close();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void playMusicaEnPartida() {
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/music/gaming.wav").getAbsoluteFile());
	        clip.close();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void playGeneracionDeSoles() {
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/music/sun.wav").getAbsoluteFile());
	        clip.close();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void playDerrota() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Sprites/Dark_Souls_Death.wav").getAbsoluteFile());
	        clip.close();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void playVictoria() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Sprites/Final_Fantasy_VII_-_Victory_Fanfare.wav").getAbsoluteFile());
	        clip.close();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void close() {
		this.clip.close();
	}
}
