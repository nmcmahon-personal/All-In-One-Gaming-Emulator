package me.niallmcmahon.aioemu.util;

import javax.sound.sampled.*;
import java.net.URL;


public class SoundPlayer {

    public static void playSound(String soundClipPath) {
        try {
            URL menuChangeSoundPath = ClassLoader.getSystemResource(soundClipPath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(menuChangeSoundPath);
            Clip soundClip = AudioSystem.getClip();
            soundClip.addLineListener(lineListener);
            soundClip.open(audioInputStream);
            soundClip.start();
        }catch (Exception ex) {
            System.out.printf("Error playing sound clip %s, %s\n", soundClipPath, ex.getMessage());
        }
    }

    private static LineListener lineListener = event -> {
        if(event.getType().equals(LineEvent.Type.STOP)) {
            event.getLine().close();
        }
    };
}
