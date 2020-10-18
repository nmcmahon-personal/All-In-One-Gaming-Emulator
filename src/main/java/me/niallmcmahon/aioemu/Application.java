package me.niallmcmahon.aioemu;

import me.niallmcmahon.aioemu.gui.GameSelectionScreenPanel;

import javax.swing.*;
import java.io.IOException;

import static me.niallmcmahon.aioemu.util.PropertiesLoader.*;

public class Application {

    public static void main(String[] args) throws IOException {
        loadAppProperties();
        JFrame frame = new JFrame(getStringProperty("application.name"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setContentPane(new GameSelectionScreenPanel());
        frame.pack();
        frame.setVisible(true);
    }



}
