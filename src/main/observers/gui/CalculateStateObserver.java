package observers.gui;

import gui.states.CalculateState;
import gui.states.StartState;

import java.awt.event.ActionEvent;

public class CalculateStateObserver extends StateObserver {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CalculateState.goBack) {
            CalculateState.inter.changeState(new StartState(CalculateState.inter));
        }
    }
}
