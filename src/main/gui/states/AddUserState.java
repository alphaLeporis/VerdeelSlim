package gui.states;

import databases.Database;
import databases.PersonsDatabase;
import databases.controllers.PersonsController;
import databases.entry.PersonEntry;
import gui.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AddUserState extends State {
    private final Interface inter;
    private final Container pane;


    private final Button addUser = new Button("Toevoegen");
    private final Button goBack = new Button("Keer terug");
    private final TextField nameUserText = new TextField("Wat is je naam?");
    private final TextField nameUser = new TextField();

    public AddUserState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }

    @Override
    public void init() {
        pane.setLayout(new GridLayout(0, 2));
        nameUserText.setEditable(false);
        nameUser.addActionListener(this);
        addUser.addActionListener(this);
        pane.add(nameUserText);
        pane.add(nameUser);
        pane.add(goBack);
        pane.add(addUser);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addUser) {
            Database personDatabase = PersonsDatabase.getInstance();
            PersonsController personsController = new PersonsController(personDatabase);
            personsController.createEntry(new PersonEntry(nameUser.getText()));
            inter.changeState(new UserState(this.inter));
        }
        if (e.getSource() == goBack) {
            inter.changeState(new UserState(this.inter));
        }
    }
}
