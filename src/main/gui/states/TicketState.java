package gui.states;

import databases.Database;
import databases.TicketsDatabase;
import databases.controllers.TicketsController;
import databases.entry.TicketEntry;
import gui.Interface;
import gui.components.ticketLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class TicketState extends State {
    private final Interface inter;
    private final Container pane;

    private Button addTicket = new Button("Voeg ticket toe");
    private Button goBack = new Button("Keer terug");

    public TicketState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }

    public void init() {
        HashMap<String, TicketEntry> allPersons = getDatabaseEntries();
        pane.setLayout(new GridLayout(0, 1));
        for (Map.Entry<String, TicketEntry> set : allPersons.entrySet()) {
            pane.add(new ticketLayout(set.getKey(), set.getValue()).draw());
        }

        goBack.addActionListener(this);
        addTicket.addActionListener(this);
        pane.add(goBack);
        pane.add(addTicket);
    }

    private HashMap<String, TicketEntry> getDatabaseEntries() {
        Database ticketDB = TicketsDatabase.getInstance();
        return new TicketsController(ticketDB).getAllEntries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            inter.changeState(new StartState(this.inter));
        }

        if (e.getSource() == addTicket) {
            inter.changeState(new AddState(this.inter));
        }
    }
}
