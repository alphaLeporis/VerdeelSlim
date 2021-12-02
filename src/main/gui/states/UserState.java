package gui.states;

import databases.Database;
import databases.PersonsDatabase;
import databases.controllers.PersonsController;
import databases.entry.PersonEntry;
import gui.Interface;
import gui.components.userLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class UserState extends State {
    private final Interface inter;
    private final Container pane;

    public UserState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }

    public void init() {
        HashMap<String, PersonEntry> allPersons = getDatabaseEntries();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        for (Map.Entry<String, PersonEntry> set : allPersons.entrySet()) {
            System.out.println(set.getKey());
            pane.add(new userLayout(set.getKey()).draw());
        }

    }

    private HashMap<String, PersonEntry> getDatabaseEntries() {
        Database personDB = PersonsDatabase.getInstance();
        return new PersonsController(personDB).getAllEntries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
