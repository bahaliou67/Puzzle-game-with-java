package src.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Audio {
	// VARIABLES
	private Clip clip;
	private DataLine.Info daInfo = new DataLine.Info(Clip.class, null);
	// CONSTRUCTEUR
	public Audio(String son){

		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(son));
			DataLine.Info info = new DataLine.Info(Clip.class, audio.getFormat());
	 clip = (Clip) AudioSystem.getLine(info);
			clip.open(audio);
			this.play();
		} catch (Exception e) {
			System.out.println("Error dans Audio : "+e.toString());

		}
	}

	// GETTERS
	public Clip getClip(){return clip;}

	// METHODES
	public void play(){clip.start();}

	public void stop(){clip.stop();}


	public static void playSound(String son){
		Audio s = new Audio(son);
		//s.play();
	}
}
