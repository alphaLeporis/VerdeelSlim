package observers.gui;

import gui.states.*;

import java.awt.event.ActionEvent;

public class StartStateObserver extends StateObserver{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == StartState.lookUsers) {
            StartState.inter.changeState(new UserState(StartState.inter));
        }

        if (e.getSource() == StartState.addTicket) {
            StartState.inter.changeState(new AddTicketState(StartState.inter));
        }

        if (e.getSource() == StartState.lookTicket) {
            StartState.inter.changeState(new TicketState(StartState.inter));
        }

        if (e.getSource() == StartState.calculate) {
            StartState.inter.changeState(new CalculateState(StartState.inter));
        }

        if (e.getSource() == StartState.changeLanguage) {
            StartState.inter.ChangeLanguageToNext();
            StartState.inter.changeState(new StartState(StartState.inter));
        }

        if (e.getSource() == StartState.exit) {
            System.exit(0);
        }
    }
}
