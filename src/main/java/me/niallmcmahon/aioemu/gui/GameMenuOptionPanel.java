package me.niallmcmahon.aioemu.gui;

import lombok.Getter;
import me.niallmcmahon.aioemu.gui.base.BackgroundImageJPanel;
import me.niallmcmahon.aioemu.listener.OnFocusMouseListener;
import me.niallmcmahon.aioemu.util.SoundPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;


import static me.niallmcmahon.aioemu.util.PropertiesLoader.*;

@Getter
public class GameMenuOptionPanel extends BackgroundImageJPanel {

    private String consoleName;

    public GameMenuOptionPanel(String consoleName) throws IOException {
        this.setOpaque(false);
        this.consoleName = consoleName;
        this.addMouseListener(selectionListener);
    }

    OnFocusMouseListener selectionListener = new OnFocusMouseListener() {
        @Override
        public void mouseEntered(MouseEvent e) {
            GameMenuOptionPanel source = (GameMenuOptionPanel) e.getSource();
            source.setBorder(new LineBorder(Color.BLUE, 10));
            SoundPlayer.playSound(getStringProperty("menu.selection.change.sound"));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            GameMenuOptionPanel source = (GameMenuOptionPanel) e.getSource();
            source.setBorder(null);
        }
    };
}
