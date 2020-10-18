package me.niallmcmahon.aioemu.gui;

import lombok.Getter;
import me.niallmcmahon.aioemu.gui.base.BackgroundImageJPanel;

import javax.swing.*;
import java.io.IOException;

import static me.niallmcmahon.aioemu.util.PropertiesLoader.*;

@Getter
public class GameMenuOptionPanel extends BackgroundImageJPanel {

    private JLabel optionLabel;

    public GameMenuOptionPanel(String optionText) throws IOException {
        optionLabel = new JLabel(optionText);
        add(optionLabel);
    }
}
