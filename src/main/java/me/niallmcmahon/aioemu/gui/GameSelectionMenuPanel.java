package me.niallmcmahon.aioemu.gui;

import lombok.Getter;
import me.niallmcmahon.aioemu.listener.ComponentShownListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.security.DomainCombiner;
import java.util.Arrays;
import java.util.List;

import static me.niallmcmahon.aioemu.util.PropertiesLoader.*;

@Getter
public class GameSelectionMenuPanel extends JPanel {

    private final List<GameMenuOptionPanel> gameOptions;
    private final int panelHeight = getIntProperty("screen.height");
    private final int panelWidth = getIntProperty("screen.width")/2;
    static final int horizontalMenuPadding = 50;
    static final int verticalMenuPadding = 50;

    public GameSelectionMenuPanel() throws IOException {
        gameOptions = Arrays.asList(
                new GameMenuOptionPanel("Playstation"),
                new GameMenuOptionPanel("N64"),
                new GameMenuOptionPanel("Gamecube")
        );
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(50, 0, 50, 0));
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setLayout(new GridLayout(gameOptions.size(), 1, horizontalMenuPadding, verticalMenuPadding));
        this.gameOptions.forEach(this::initMenuOption);
    }

    private void initMenuOption(GameMenuOptionPanel menuOption) {
        try {
            this.add(menuOption);
            menuOption.setPreferredSize(panelWidth, (panelHeight / gameOptions.size()) - verticalMenuPadding);
            String propertyName = String.format("%s.background.image", menuOption.getConsoleName().toLowerCase());
            menuOption.setBackgroundImage(getStringProperty(propertyName));
        } catch (IOException ex) {
            System.out.printf("IOException occurred while initialising menu option: %s", ex.getMessage());
        }
    }
}
