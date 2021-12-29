package gui.states;

import backend.databases.PersonsDatabase;
import backend.databases.controllers.PersonsController;
import backend.entry.person.PersonEntry;
import gui.Interface;
import gui.components.userLayout;
import observers.gui.UserStateObserver;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UserState extends State {
    private final UserStateObserver observer = new UserStateObserver();
    public static Button addUser;
    public static Button goBack;
    private final HashMap<String, PersonEntry> allPersons = getDatabaseEntries();

    public UserState(Interface inter) {
        super(inter);
    }

    private HashMap<String, PersonEntry> getDatabaseEntries() {
        PersonsDatabase personDB = PersonsDatabase.getInstance();
        return new PersonsController(personDB).getAllEntries();
    }

    @Override
    void setLayout() {
        pane.setLayout(new GridLayout(0, 1));
    }

    @Override
    void initActionListener() {
        goBack.addActionListener(observer);
        addUser.addActionListener(observer);
    }

    @Override
    void createUIElements() {
        addUser = new Button("Voeg gebruiker toe");
        goBack = new Button("Keer terug");

        for (Map.Entry<String, PersonEntry> set : allPersons.entrySet()) {
            pane.add(new userLayout(set.getKey()).draw());
        }

        pane.add(goBack);
        pane.add(addUser);
    }

}
