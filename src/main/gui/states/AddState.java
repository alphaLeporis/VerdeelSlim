package gui.states;

import backend.databases.PersonsDatabase;
import backend.databases.controllers.PersonsController;
import backend.entry.person.PersonEntry;
import backend.entry.tickets.TicketEntry;
import gui.Interface;
import observers.gui.AddStateObserver;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class AddState extends State{
    private final AddStateObserver observer = new AddStateObserver();
    private TicketEntry entry;

    public static final JComboBox<String> betaaldBox = new JComboBox<>(getAllUsers());
    private final JTextField betaaldBoxText = new JTextField();
    private final JTextField naamText = new JTextField();
    public static final JTextField naamTextInput = new JTextField();
    public static final JComboBox<String> ticketBox = new JComboBox<>(new String[]{"Accomodation", "Amusement", "Restaurant", "Transportation"});
    private final JTextField ticketBoxText = new JTextField();
    private final JTextField prijsText = new JTextField();
    public static final JTextField prijsTextInput = new JTextField();

    public static final Button addTicket = new Button("Verdeel");
    public static final Button goBack = new Button("Keer terug");

    public AddState(Interface inter) {
        super(inter);
    }

    public AddState(Interface inter, TicketEntry entry) {
        super(inter);
        this.entry = entry;
    }

    @Override
    void setLayout() {
        pane.setLayout(new GridLayout(0, 2));
    }

    @Override
    void createUIElements() {
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

        ticketBox.setEditable(true);

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
            naamTextInput.setText(entry.getName());
            System.out.println(entry.getPaidBy().getName());
            betaaldBox.setSelectedItem(entry.getPaidBy().getName());
            ticketBox.setSelectedItem(entry.getTicketType());
            prijsTextInput.setText(String.valueOf(entry.getPrice()));
        }
    }

    @Override
    void initActionListener() {
        addTicket.addActionListener(observer);
        goBack.addActionListener(observer);
    }

    // Todo: deze code is heel brak :)
    private static String[] getAllUsers() {
        PersonsDatabase personDB = PersonsDatabase.getInstance();
        HashMap<String, PersonEntry>  persons = new PersonsController(personDB).getAllEntries();
        List<String> list = new ArrayList<>(persons.keySet());
        System.out.println(list);
        String[] sa = {};
        sa = list.toArray(sa);
        return sa;
    }

    public static PersonEntry getUser(String name) {
        PersonsDatabase personDB = PersonsDatabase.getInstance();
        HashMap<String, PersonEntry>  persons = new PersonsController(personDB).getAllEntries();
        return persons.get(name);
    }

}
