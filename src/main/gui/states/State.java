package gui.states;

import gui.Interface;
import gui.Language;
import gui.Nederlands;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

abstract public class State extends JFrame {
    protected final Container pane;
    public static Interface inter;
    protected BufferedImage headerImage;
    protected Language language;

    public State(Interface inter) {
        StartState.inter = inter;
        this.pane = inter.getPane();
        this.language = new Nederlands();
    }

    public void init() {
        setLayout();
        if (headerImage != null) {
            addImage(headerImage);
        }
        createUIElements();
        initActionListener();
    }

    private void addImage(BufferedImage img) {
        JLabel pic = new JLabel(new ImageIcon(img));
        pane.add(pic);
    }

    public void setHeaderImage(String headerImage) {
        try {
            this.headerImage = ImageIO.read(Objects.requireNonNull(StartState.class.getResource(headerImage)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Container getPane() {
        return pane;
    }

    abstract void setLayout();
    abstract void createUIElements();
    abstract void initActionListener();
}
