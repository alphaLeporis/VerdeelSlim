package observers.gui;

import databases.Database;
import databases.PersonsDatabase;
import databases.controllers.PersonsController;
import databases.entry.PersonEntry;
import gui.states.AddUserState;
import gui.states.UserState;

import java.awt.event.ActionEvent;

public class AddUserStateOberserver extends StateObserver {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddUserState.addUser) {
            Database personDatabase = PersonsDatabase.getInstance();
            PersonsController personsController = new PersonsController(personDatabase);
            personsController.createEntry(new PersonEntry(AddUserState.nameUser.getText()));
            AddUserState.inter.changeState(new UserState(AddUserState.inter));
        }
        if (e.getSource() == AddUserState.goBack) {
            AddUserState.inter.changeState(new UserState(AddUserState.inter));
        }
    }
}
