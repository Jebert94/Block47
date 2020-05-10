import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    private static ArrayList<String> typingFiles = new ArrayList<String>();
    static{
        typingFiles.add("/SoundEffects/Old01.wav");
        typingFiles.add("/SoundEffects/Old02.wav");
        typingFiles.add("/SoundEffects/Old03.wav");
        typingFiles.add("/SoundEffects/Old04.wav");
        typingFiles.add("/SoundEffects/Old05.wav");
        typingFiles.add("/SoundEffects/Old05.wav");
    }
    private Clip clip;

    public Sound(String file) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(file));
            this.clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    public Clip getClip(){
        return clip;
    }



    public Sound() {
        Random rand = new Random();
        try {
            String file = typingFiles.get(rand.nextInt(typingFiles.size()));
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(file));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}