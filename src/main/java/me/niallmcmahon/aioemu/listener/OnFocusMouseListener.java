package me.niallmcmahon.aioemu.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface OnFocusMouseListener extends MouseListener {

    @Override
    default void mouseClicked(MouseEvent e) {}

    @Override
    default void mousePressed(MouseEvent e) {}

    @Override
    default void mouseReleased(MouseEvent e) {}

    @Override
    void mouseEntered(MouseEvent e);

    @Override
    void mouseExited(MouseEvent e);
}
