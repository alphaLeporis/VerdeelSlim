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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class DivideTicketState extends State {
    private final Interface inter;
    private final Container pane;
    private final TicketEntry entry;
    private HashMap<String, JTextField> textEntries = new HashMap();
    private boolean Even = true;

    private final Button addTicket = new Button("Voeg ticket toe");
    private final Button goBack = new Button("Keer terug");
    private final Button checkSum = new Button("Kijk na");

    private final JRadioButton option1 = new JRadioButton("Even verdeeld");
    private final JRadioButton option2 = new JRadioButton("Oneven verdeeld");
    private final JTextArea yourSum = new JTextArea();

    private double finalSum = 0;

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

        finalSum = 0;
        for (Map.Entry<String, PersonEntry> set : allPersons.entrySet()) {
            pane.add(new userLayout(set.getKey()).draw());
            JTextField text = new JTextField(String.valueOf(entry.getTicketSplitMap().getName(set.getKey())));
            finalSum = finalSum + entry.getTicketSplitMap().getName(set.getKey());
            text.setEditable(!Even);
            text.addActionListener(this);
            textEntries.put(set.getKey(), text);
            pane.add(text);
        }
        yourSum.setEditable(false);
        yourSum.setText("Totaal prijs: " +String.valueOf(finalSum));

        goBack.addActionListener(this);
        checkSum.addActionListener(this);
        addTicket.addActionListener(this);
        option1.addActionListener(this);
        option2.addActionListener(this);
        pane.add(checkSum);
        pane.add(yourSum);

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
        return persons.get(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkSum) {
            double sum = 0;
            for (Map.Entry<String, JTextField> set : textEntries.entrySet()) {
                try {
                    double d = Double.parseDouble(set.getValue().getText());
                    sum = sum + d;
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Dit is geen geldige prijs!");
                    return;
                }
            }
            System.out.println(sum);
            yourSum.setText("Totaal prijs: " +String.valueOf(sum));
            if (sum != finalSum) {
                yourSum.setText("Jouw som: " +String.valueOf(sum) +
                        "\nDe correcte som: "+ String.valueOf(finalSum) +
                        "\nJe mist: "+ String.valueOf(abs(finalSum-sum)));

                yourSum.setBackground(Color.RED);
            } else {
                yourSum.setText("De correcte en jouw som: " +String.valueOf(sum));
                yourSum.setBackground(null);
            }
        }


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
