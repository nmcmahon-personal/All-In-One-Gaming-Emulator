package me.niallmcmahon.aioemu.util;

import javax.sound.sampled.*;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class SoundPlayer {

    public static void playSound(String soundClipPath) {
        try {
            Path menuChangeSoundPath = Paths.get(ClassLoader.getSystemResource(soundClipPath).toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(menuChangeSoundPath.toFile().getAbsoluteFile());
            Clip soundClip = AudioSystem.getClip();
            soundClip.addLineListener(lineListener);
            soundClip.open(audioInputStream);
            soundClip.start();
        }catch (Exception ex) {
            System.out.printf("Error playing sound clip %s, %s\n", soundClipPath, ex.getMessage());
        }
    }

    private static LineListener lineListener = new LineListener() {
        @Override
        public void update(LineEvent event) {
            if(event.getType().equals(LineEvent.Type.STOP)) {
                event.getLine().close();
            }
        }
    };
}
