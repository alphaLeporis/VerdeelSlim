package gui.states;

import databases.Database;
import databases.PersonsDatabase;
import databases.controllers.PersonsController;
import databases.entry.PersonEntry;
import gui.Interface;
import gui.components.userLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class UserState extends State {
    private final Interface inter;
    private final Container pane;

    private Button addUser = new Button("Voeg gebruiker toe");
    private Button goBack = new Button("Keer terug");

    public UserState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }

    public void init() {
        HashMap<String, PersonEntry> allPersons = getDatabaseEntries();
        pane.setLayout(new GridLayout(0, 1));
        for (Map.Entry<String, PersonEntry> set : allPersons.entrySet()) {
            pane.add(new userLayout(set.getKey()).draw());
        }

        goBack.addActionListener(this);
        addUser.addActionListener(this);
        pane.add(goBack);
        pane.add(addUser);
    }

    private HashMap<String, PersonEntry> getDatabaseEntries() {
        Database personDB = PersonsDatabase.getInstance();
        return new PersonsController(personDB).getAllEntries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            inter.changeState(new StartState(this.inter));
        }

        if (e.getSource() == addUser) {
            inter.changeState(new AddUserState(this.inter));
        }
    }
}
