package gui;
import gui.states.StartState;
import gui.states.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener {

    // declare some things we need
    private JLabel introLbl, lbl1, lbl2, lbl3;
    private JTextField txtfld1, txtfld2, txtfld3;
    private JButton btn1;
    private JTextArea txtArea1;
    private Container pane;


    public void init() {
        Container pane = this.getContentPane();
        State currentState = new StartState(pane);
        currentState.init();
    }



    //handles action and all the things ^_^

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //parse some data from input
            int temp1 = Integer.parseInt(txtfld1.getText());
            int temp2 = Integer.parseInt(txtfld2.getText());

            //do what we want to do with whatever data


            //basic error catching
        } catch (NumberFormatException ex) {
            System.out.println("Exception: " + ex);
            JOptionPane.showMessageDialog(this, "Please enter a warning message");
        } catch (ArrayIndexOutOfBoundsException ex) {
            //warnings..
        } catch (NegativeArraySizeException ex) {
            //warnings..
        }
    }
}