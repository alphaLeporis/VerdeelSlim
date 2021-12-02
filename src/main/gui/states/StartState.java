package gui.states;

import gui.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;

public class StartState extends State {
    private final Container pane;
    private final Interface inter;

    public StartState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }

    public void init() {
        pane.setLayout(new GridLayout(0, 1));
        Button lookUsers = new Button("Bekijk gebruikers");
        lookUsers.addActionListener(this);
        pane.add(lookUsers);
        pane.add(new Button("Wijzig gebruikers"));
        pane.add(new Button("Voeg een ticket toe"));
        pane.add(new Button("Bereken"));
        pane.add(new Button("Sluit af"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inter.changeState(new UserState(this.inter));
    }
}
