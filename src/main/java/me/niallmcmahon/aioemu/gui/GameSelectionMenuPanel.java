package me.niallmcmahon.aioemu.gui;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
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

    public GameSelectionMenuPanel() throws IOException {
        gameOptions = Arrays.asList(
                new GameMenuOptionPanel("Playstation"),
                new GameMenuOptionPanel("N64"),
                new GameMenuOptionPanel("Gamecube")
        );
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setLayout(new GridLayout(gameOptions.size(), 1));
        for (GameMenuOptionPanel gameOption : gameOptions) {
            initMenuOption(gameOption);
        }
    }

    private void initMenuOption(GameMenuOptionPanel menuOption) throws IOException {
        menuOption.setPreferredSize(panelWidth, panelHeight/gameOptions.size());
        String propertyName = String.format("%s.background.image", menuOption.getOptionLabel().getText().toLowerCase());
        menuOption.setBackgroundImage(getStringProperty(propertyName));
        this.add(menuOption);
    }
}
