package observers.gui;

import gui.states.*;

import java.awt.event.ActionEvent;

public class TicketStateObserver extends StateObserver{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == TicketState.goBack) {
            TicketState.inter.changeState(new StartState(TicketState.inter));
        }

        if (e.getSource() == TicketState.addTicket) {
            TicketState.inter.changeState(new AddState(TicketState.inter));
        }
    }
}
