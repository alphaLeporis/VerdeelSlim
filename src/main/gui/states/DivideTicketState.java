package gui.states;

import databases.Database;
import databases.PersonsDatabase;
import databases.TicketsDatabase;
import databases.controllers.Controller;
import databases.controllers.PersonsController;
import databases.controllers.TicketsController;
import databases.entry.PersonEntry;
import databases.entry.TicketEntry;
import gui.Interface;
import gui.components.userLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class DivideTicketState extends State {
    private final Interface inter;
    private final Container pane;
    private final TicketEntry entry;

    private Button addTicket = new Button("Voeg ticket toe");
    private Button goBack = new Button("Keer terug");

    public DivideTicketState(Interface inter, TicketEntry entry) {
        this.inter = inter;
        this.pane = inter.getPane();
        this.entry = entry;
    }

    public void init() {
        HashMap<String, PersonEntry> allPersons = getDatabaseEntries();
        pane.setLayout(new GridLayout(0, 1));
        for (Map.Entry<String, PersonEntry> set : allPersons.entrySet()) {
            pane.add(new userLayout(set.getKey()).draw());
        }

        goBack.addActionListener(this);
        addTicket.addActionListener(this);
        pane.add(goBack);
        pane.add(addTicket);
    }

    private HashMap<String, PersonEntry> getDatabaseEntries() {
        Database personDB = PersonsDatabase.getInstance();
        return new PersonsController(personDB).getAllEntries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTicket) {
            Controller ticketsController = new TicketsController(TicketsDatabase.getInstance());
            ticketsController.createEntry(entry);

            inter.changeState(new TicketState(this.inter));
        }

        if (e.getSource() == goBack) {
            inter.changeState(new AddState(this.inter, this.entry));
        }
    }
}
