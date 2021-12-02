package gui;

import javax.swing.*;

public class Display {
    private JFrame frame;

    public Display() {
        Interface GUI = new Interface();
        GUI.init(); // init all our things!
        System.out.println("VerdeelSlim GUI is starting...");

        // set window object size
        GUI.setSize(800, 450);
        GUI.setTitle("VerdeelSlim");
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
