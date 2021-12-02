package gui.states;

import java.awt.*;
import java.awt.event.ActionEvent;

public class StartState extends State {
    private final Container pane;

    public StartState(Container pane) {
        this.pane = pane;
    }

    public void init() {
        pane.setLayout(new GridLayout(0, 1));
        pane.add(new Button("Bekijk gebruikers"));
        pane.add(new Button("Wijzig gebruikers"));
        pane.add(new Button("Voeg een ticket toe"));
        pane.add(new Button("Bereken"));
        pane.add(new Button("Sluit af"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
