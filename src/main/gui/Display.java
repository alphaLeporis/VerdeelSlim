package gui;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private JFrame frame;

    public Display() {
        newDisplay();
        setStartFrame();
    }

    private void newDisplay() {
        frame = new JFrame();
        GridLayout grid = new GridLayout(0,1);
        frame.setLayout(grid);//using no layout managers
        frame.setSize(400,500);//400 width and 500 height
        frame.setVisible(true);//making the frame visible
    }

    private void setStartFrame() {
        frame.add(new JButton("Friends"));
        frame.add(new JButton("Tickets"));
        frame.add(new JButton("Balance"));
        frame.setVisible(true);//making the frame visible
    }

}
