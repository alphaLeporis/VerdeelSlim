package gui.states;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AddUserState extends State {
    private final Container pane;

    public AddUserState(Container pane) {
        this.pane = pane;
    }

    @Override
    public void init() {
        pane.setLayout(new GridLayout(0, 1));
        pane.add(new TextField());
        pane.add(new Button("Toevoegen"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
