package me.niallmcmahon.aioemu.listener;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public interface ComponentShownListener extends ComponentListener {
    @Override
    default void componentResized(ComponentEvent e) {}

    @Override
    default void componentMoved(ComponentEvent e) {}

    @Override
    void componentShown(ComponentEvent e);

    @Override
    default void componentHidden(ComponentEvent e) {}
}
