package gui.states;

import backend.databases.PersonsDatabase;
import backend.databases.controllers.PersonsController;
import backend.entry.person.PersonEntry;
import backend.entry.tickets.TicketEntry;
import gui.Interface;
import gui.components.userLayout;
import observers.gui.DivideTicketStateObserver;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DivideTicketState extends State {
    private final DivideTicketStateObserver observer = new DivideTicketStateObserver(this);
    public static TicketEntry entry;
    public static final HashMap<String, JTextField> textEntries = new HashMap<>();
    private final HashMap<String, PersonEntry> allPersons = getDatabaseEntries();
    public static boolean Even = true;

    public static Button goBack;
    public static Button addTicket;
    public static Button checkSum;
    public static JRadioButton option1;
    public static JRadioButton option2;
    public static JTextArea yourSum;

    public static double finalSum;

    public DivideTicketState(Interface inter, TicketEntry entry) {
        super(inter);
        DivideTicketState.entry = entry;
    }

    @Override
    void setLayout() {
        pane.setLayout(new GridLayout(0, 2));
    }

    @Override
    void createUIElements() {
        // Reset sum value
        finalSum = 0;

        // Create buttons
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);

        addTicket = new Button(inter.currentLanguage.addTicket());
        goBack = new Button(inter.currentLanguage.goBack());
        checkSum = new Button(inter.currentLanguage.checkSum());
        option1 = new JRadioButton(inter.currentLanguage.dividedUniformly());
        option2 = new JRadioButton(inter.currentLanguage.dividedNonUniformly());
        yourSum = new JTextArea();

        // Draw first buttons
        pane.add(option1);
        pane.add(option2);

        // Draw all persons
        for (Map.Entry<String, PersonEntry> set : allPersons.entrySet()) {
            JTextField text = new JTextField(String.valueOf(entry.getTicketSplitMap().getName(set.getKey())));
            finalSum = finalSum + entry.getTicketSplitMap().getName(set.getKey());
            text.setEditable(!Even);
            text.addActionListener(observer);
            textEntries.put(set.getKey(), text);

            if (inter.currentLanguage.isRTL()) {
                pane.add(text);
                pane.add(new userLayout(set.getKey()).draw());
            } else {
                pane.add(new userLayout(set.getKey()).draw());
                pane.add(text);
            }
        }
        yourSum.setEditable(false);
        yourSum.setText(inter.currentLanguage.totalPrice() + finalSum);

        // Draw rest of buttons on pane
        if (inter.currentLanguage.isRTL()) {
            pane.add(yourSum);
            pane.add(checkSum);
            pane.add(addTicket);
            pane.add(goBack);
        } else {
            pane.add(checkSum);
            pane.add(yourSum);
            pane.add(goBack);
            pane.add(addTicket);
        }
    }

    @Override
    void initActionListener() {
        goBack.addActionListener(observer);
        checkSum.addActionListener(observer);
        addTicket.addActionListener(observer);
        option1.addActionListener(observer);
        option2.addActionListener(observer);
    }

    private HashMap<String, PersonEntry> getDatabaseEntries() {
        PersonsDatabase personDB = PersonsDatabase.getInstance();
        return new PersonsController(personDB).getAllEntries();
    }

    public static PersonEntry getUser(String name) {
        PersonsDatabase personDB = PersonsDatabase.getInstance();
        HashMap<String, PersonEntry>  persons = new PersonsController(personDB).getAllEntries();
        return persons.get(name);
    }

}
