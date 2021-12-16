package gui.states;

import databases.Database;
import databases.PersonsDatabase;
import databases.TicketsDatabase;
import databases.controllers.PersonsController;
import databases.controllers.TicketsController;
import databases.entry.PersonEntry;
import databases.entry.TicketEntry;
import databases.entry.tickets.TicketFactory;
import gui.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

public class AddState extends State{
    private final Interface inter;
    private final Container pane;
    private TicketEntry entry;

    private JComboBox<String> betaaldBox;
    private JTextField betaaldBoxText = new JTextField(15);
    private JTextField naamText = new JTextField(15);
    private JTextField naamTextInput = new JTextField(15);
    private JComboBox ticketBox = new JComboBox(new String[]{"Accomodation", "Amusement", "Restaurant", "Transportation"});
    private JTextField ticketBoxText = new JTextField(15);
    private JTextField prijsText = new JTextField(15);
    private JTextField prijsTextInput = new JTextField(15);

    private Button addTicket = new Button("Verdeel");
    private Button goBack = new Button("Keer terug");

    public AddState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }

    public AddState(Interface inter, TicketEntry entry) {
        this.inter = inter;
        this.pane = inter.getPane();
        this.entry = entry;
    }

    @Override
    public void init() {
        pane.setLayout(new GridLayout(0, 2));
        betaaldBoxText.setText("Wie heeft betaald?");
        betaaldBoxText.setEditable(false);
        naamText.setText("Wat is de naam van het ticket?");
        naamText.setEditable(false);
        naamTextInput.setEditable(true);

        ticketBoxText.setText("Wat voor een ticket was het?");
        ticketBoxText.setEditable(false);
        prijsText.setText("Hoeveel kostte dit ticket?");
        prijsText.setEditable(false);
        prijsTextInput.setEditable(true);

        betaaldBox = new JComboBox<>(getAllUsers());
        ticketBox.setEditable(true);

        addTicket.addActionListener(this);
        goBack.addActionListener(this);

        pane.add(betaaldBoxText);
        pane.add(betaaldBox);
        pane.add(naamText);
        pane.add(naamTextInput);
        pane.add(ticketBoxText);
        pane.add(ticketBox);
        pane.add(prijsText);
        pane.add(prijsTextInput);
        pane.add(goBack);
        pane.add(addTicket);

        if (entry != null) {
            this.naamTextInput.setText(entry.getName());
            System.out.println(entry.getPaidBy().getName());
            this.betaaldBox.setSelectedItem(entry.getPaidBy().getName());
            this.ticketBox.setSelectedItem(entry.getTicketType());
            this.prijsTextInput.setText(String.valueOf(entry.getPrice()));
        }
    }

    // Todo: deze code is heel brak :)
    private String[] getAllUsers() {
        Database personDB = PersonsDatabase.getInstance();
        HashMap<String, PersonEntry>  persons = new PersonsController(personDB).getAllEntries();
        List<String>list = new ArrayList<String>();
        list.addAll(persons.keySet());
        System.out.println(list);
        String sa[] = {};
        sa = list.toArray(sa);
        return sa;
    }

    private PersonEntry getUser(String name) {
        Database personDB = PersonsDatabase.getInstance();
        HashMap<String, PersonEntry>  persons = new PersonsController(personDB).getAllEntries();
        return (PersonEntry) persons.get(name);
    }

    // Todo: deze code is ook heel brak :)
    private String[] getAllTickets() {
        Database ticketDB = TicketsDatabase.getInstance();
        HashMap<String, TicketEntry>  persons = new TicketsController(ticketDB).getAllEntries();
        List<String>list = new ArrayList<String>();
        list.addAll(persons.keySet());
        System.out.println(list);
        String sa[] = {};
        sa = list.toArray(sa);
        return sa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            inter.changeState(new StartState(this.inter));
        }

        if (e.getSource() == addTicket) {
            System.out.println(ticketBox.getSelectedItem());
            System.out.println(prijsTextInput.getText().length());
            if (prijsTextInput.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vul een prijs in!");
            } else {
                try {
                    double d = Double.parseDouble(prijsTextInput.getText());
                    TicketFactory ticketFactory = new TicketFactory();
                    inter.changeState(new DivideTicketState(this.inter, ticketFactory.getTicket(naamTextInput.getText(), (String) ticketBox.getSelectedItem(), d, getUser((String) betaaldBox.getSelectedItem()))));
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Dit is geen geldige prijs!");
                }
            }

        }
    }
}
