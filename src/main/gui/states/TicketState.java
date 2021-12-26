package gui.states;

import databases.Database;
import databases.TicketsDatabase;
import databases.controllers.TicketsController;
import databases.entry.TicketEntry;
import gui.Interface;
import gui.components.ticketLayout;
import observers.gui.TicketStateObserver;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TicketState extends State {
    private final TicketStateObserver observer = new TicketStateObserver();
    public static Button addTicket;
    public static Button goBack;
    private final HashMap<String, TicketEntry> allPersons = getDatabaseEntries();

    public TicketState(Interface inter) {
        super(inter);
    }

    private HashMap<String, TicketEntry> getDatabaseEntries() {
        Database ticketDB = TicketsDatabase.getInstance();
        return new TicketsController(ticketDB).getAllEntries();
    }

    @Override
    void setLayout() {
        pane.setLayout(new GridLayout(0, 1));
    }

    @Override
    void createUIElements() {
        addTicket = new Button("Voeg ticket toe");
        goBack = new Button("Keer terug");

        for (Map.Entry<String, TicketEntry> set : allPersons.entrySet()) {
            pane.add(new ticketLayout(set.getKey(), set.getValue()).draw());
        }

        pane.add(goBack);
        pane.add(addTicket);

    }

    @Override
    void initActionListener() {
        goBack.addActionListener(observer);
        addTicket.addActionListener(observer);
    }
}
