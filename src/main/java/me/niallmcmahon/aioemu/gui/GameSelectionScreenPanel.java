package me.niallmcmahon.aioemu.gui;

import me.niallmcmahon.aioemu.gui.base.BackgroundImageJPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import static me.niallmcmahon.aioemu.util.PropertiesLoader.getStringProperty;

public class GameSelectionScreenPanel extends BackgroundImageJPanel {

    private static int panelWidth = Integer.parseInt(getStringProperty("screen.width"));
    private static int panelHeight = Integer.parseInt(getStringProperty("screen.height"));

    public GameSelectionScreenPanel() throws IOException {
        setPreferredSize(panelWidth, panelHeight);
        setBackgroundImage(getStringProperty("game.selection.screen.background.image"));
        this.add(new GameSelectionMenuPanel());
    }
}
