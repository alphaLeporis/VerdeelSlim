package observers.gui;

import gui.states.AddUserState;
import gui.states.StartState;
import gui.states.UserState;

import java.awt.event.ActionEvent;

public class UserStateObserver extends StateObserver{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == UserState.goBack) {
            UserState.inter.changeState(new StartState(UserState.inter));
        }

        if (e.getSource() == UserState.addUser) {
            UserState.inter.changeState(new AddUserState(UserState.inter));
        }
    }
}
