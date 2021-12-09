package gui.states;

import gui.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddState extends State{
    private final Interface inter;
    private final Container pane;

    private JComboBox betaaldBox = new JComboBox();
    private JTextField betaaldBoxText = new JTextField(15);
    private JComboBox ticketBox = new JComboBox();
    private JTextField ticketBoxText = new JTextField(15);
    private JTextField prijsText = new JTextField(15);
    private JTextField prijsTextInput = new JTextField(15);

    private Button addTicket = new Button("Voeg toe");
    private Button goBack = new Button("Keer terug");

    public AddState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }


    @Override
    public void init() {
        pane.setLayout(new GridLayout(0, 2));
        betaaldBoxText.setText("Wie heeft betaald?");
        betaaldBoxText.setEditable(false);
        ticketBoxText.setText("Wat voor een ticket was het?");
        ticketBoxText.setEditable(false);
        prijsText.setText("Hoeveel kostte dit ticket?");
        prijsText.setEditable(false);
        prijsTextInput.setEditable(true);

        goBack.addActionListener(this);

        pane.add(betaaldBoxText);
        pane.add(betaaldBox);
        pane.add(ticketBoxText);
        pane.add(ticketBox);
        pane.add(prijsText);
        pane.add(prijsTextInput);
        pane.add(goBack);
        pane.add(addTicket);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            inter.changeState(new StartState(this.inter));
        }
    }
}
