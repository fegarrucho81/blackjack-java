package src;
import javax.sound.sampled.*;
import java.io.File;

public class Audio {
    public static void tocarMusicaVitoria() {
        try {
            File audio = new File("C:\\Users\\felip\\OneDrive\\Área de Trabalho\\FELIPE\\java\\blackjack VERSÃO CORRETA\\musica\\musicavitoria.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tocarMusicaDerrota() {
        try {
            File audio2 = new File("C:\\Users\\felip\\OneDrive\\Área de Trabalho\\FELIPE\\java\\blackjack VERSÃO CORRETA\\musica\\musicaderrota.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audio2);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
