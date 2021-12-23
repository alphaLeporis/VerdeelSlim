package gui;
import gui.states.StartState;
import gui.states.State;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    private Container pane;
    private State currentState;


    public void init() {
        pane = this.getContentPane();
        currentState = new StartState(this);
        currentState.init();
    }

    public void changeState(State newState) {
        pane.removeAll();
        currentState = newState;
        currentState.init();
        revalidate();
    }

    public Container getPane() {
        return pane;
    }
}