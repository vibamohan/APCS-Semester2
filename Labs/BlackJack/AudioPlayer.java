
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public final class AudioPlayer {

    private static final AudioPlayer INSTANCE = new AudioPlayer();

    public static AudioPlayer get() {
        return INSTANCE;
    }

    private AudioPlayer() {
    }

    public void playSound(String filePath) {
        try {
            Clip clip;

            try (AudioInputStream audioStream
                    = AudioSystem.getAudioInputStream(new File(filePath))) {
                clip = AudioSystem.getClip();
                clip.open(audioStream);
            }

            clip.setFramePosition(0);
            clip.start();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (UnsupportedAudioFileException
                | IOException
                | LineUnavailableException e) {
            System.err.println("Error playing audio: " + e.getMessage());
        }
    }
}
