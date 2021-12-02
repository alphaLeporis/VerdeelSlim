package gui.states;

import databases.Database;
import databases.PersonsDatabase;
import databases.controllers.PersonsController;
import databases.entry.PersonEntry;
import gui.components.userLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class UserState extends State {
    private final Container pane;

    public UserState(Container pane) {
        this.pane = pane;
    }

    public void init() {
        HashMap<String, PersonEntry> allPersons = getDatabaseEntries();

        for (Map.Entry<String, PersonEntry> set : allPersons.entrySet()) {
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
