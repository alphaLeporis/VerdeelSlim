package gui;
import gui.states.AddUserState;
import gui.states.StartState;
import gui.states.State;
import gui.states.UserState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {

    // declare some things we need
    private JLabel introLbl, lbl1, lbl2, lbl3;
    private JTextField txtfld1, txtfld2, txtfld3;
    private JButton btn1;
    private JTextArea txtArea1;
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
    }

    public Container getPane() {
        return pane;
    }
}