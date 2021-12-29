package gui;

import javax.swing.*;

public class Display {

    public Display() {
        Interface GUI = new Interface();
        GUI.init();
        System.out.println("VerdeelSlim GUI is starting...");

        // set window object size
        GUI.setSize(450, 900);
        GUI.setTitle("VerdeelSlim");
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
