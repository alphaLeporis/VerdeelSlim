package gui.states;

import databases.Database;
import databases.PersonsDatabase;
import databases.TicketsDatabase;
import databases.controllers.Controller;
import databases.controllers.PersonsController;
import databases.controllers.TicketsController;
import databases.entry.PersonEntry;
import databases.entry.TicketEntry;
import databases.entry.tickets.TicketFactory;
import gui.Interface;
import gui.components.userLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class DivideTicketState extends State {
    private final Interface inter;
    private final Container pane;
    private final TicketEntry entry;
    private HashMap<String, JTextField> textEntries = new HashMap();
    private boolean Even = true;

    private Button addTicket = new Button("Voeg ticket toe");
    private Button goBack = new Button("Keer terug");

    private JRadioButton option1 = new JRadioButton("Even verdeeld");
    private JRadioButton option2 = new JRadioButton("Oneven verdeeld");

    public DivideTicketState(Interface inter, TicketEntry entry) {
        this.inter = inter;
        this.pane = inter.getPane();
        this.entry = entry;
    }

    public void init() {
        textEntries = new HashMap();
        HashMap<String, PersonEntry> allPersons = getDatabaseEntries();
        pane.setLayout(new GridLayout(0, 2));
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        pane.add(option1);
        pane.add(option2);


        for (Map.Entry<String, PersonEntry> set : allPersons.entrySet()) {
            pane.add(new userLayout(set.getKey()).draw());
            JTextField text = new JTextField(String.valueOf(entry.getTicketSplitMap().getName(set.getKey())));
            text.setEditable(!Even);
            textEntries.put(set.getKey(), text);
            pane.add(text);
        }

        goBack.addActionListener(this);
        addTicket.addActionListener(this);
        option1.addActionListener(this);
        option2.addActionListener(this);
        pane.add(goBack);
        pane.add(addTicket);
    }

    private HashMap<String, PersonEntry> getDatabaseEntries() {
        Database personDB = PersonsDatabase.getInstance();
        return new PersonsController(personDB).getAllEntries();
    }

    private PersonEntry getUser(String name) {
        Database personDB = PersonsDatabase.getInstance();
        HashMap<String, PersonEntry>  persons = new PersonsController(personDB).getAllEntries();
        return (PersonEntry) persons.get(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTicket) {
            for (Map.Entry<String, JTextField> set : textEntries.entrySet()) {
                try {
                    double d = Double.parseDouble(set.getValue().getText());
                    entry.setAmount(getUser(set.getKey()), d);
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Dit is geen geldige prijs!");
                    return;
                }
            }

            if (entry.checkPriceIsPaid()) {
                Controller ticketsController = new TicketsController(TicketsDatabase.getInstance());
                ticketsController.createEntry(entry);

                inter.changeState(new TicketState(this.inter));
            } else {
                JOptionPane.showMessageDialog(null, "Oei kijk je som na!");
            }

        }

        if (e.getSource() == goBack) {
            inter.changeState(new AddState(this.inter, this.entry));
        }

        if (e.getSource() == option1) {
            pane.removeAll();
            Even = true;
            init();
            inter.revalidate();
        }

        if (e.getSource() == option2) {
            pane.removeAll();
            Even = false;
            init();
            inter.revalidate();
        }
    }
}
