package gui.components;

import javax.swing.*;
import java.awt.*;

public class userLayout {
    String name;
    public userLayout(String name) {
        this.name = name;
    }

    public Component draw() {
        return new JLabel(name);
    }
}
