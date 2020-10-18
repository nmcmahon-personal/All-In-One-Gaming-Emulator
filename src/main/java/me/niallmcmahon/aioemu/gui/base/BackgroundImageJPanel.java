package me.niallmcmahon.aioemu.gui.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

@Getter
@NoArgsConstructor
public class BackgroundImageJPanel extends JPanel {

    private Image backgroundImage;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }

    public void setPreferredSize(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        super.setPreferredSize(dimension);
    }

    public void setPreferredSize(double width, double height) {
        Dimension dimension = new Dimension((int)width, (int)height);
        super.setPreferredSize(dimension);
    }

    public void setBackgroundImage(String pathToImage) throws IOException {
        URL imageUrl = ClassLoader.getSystemResource(pathToImage);
        this.backgroundImage = ImageIO.read(imageUrl).getScaledInstance((int)this.getPreferredSize().getWidth(), (int)this.getPreferredSize().getHeight(), Image.SCALE_DEFAULT);
    }
}
