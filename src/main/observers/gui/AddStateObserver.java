package observers.gui;

import backend.entry.tickets.TicketFactory;
import gui.states.AddTicketState;
import gui.states.DivideTicketState;
import gui.states.StartState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class AddStateObserver extends StateObserver{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddTicketState.goBack) {
            AddTicketState.inter.changeState(new StartState(AddTicketState.inter));
        }

        if (e.getSource() == AddTicketState.addTicket) {
            System.out.println(AddTicketState.ticketBox.getSelectedItem());
            System.out.println(AddTicketState.prijsTextInput.getText().length());
            if (AddTicketState.prijsTextInput.getText().length() == 0) {
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, AddTicketState.inter.currentLanguage.fillInPriceError());
            } else {
                try {
                    double d = Double.parseDouble(AddTicketState.prijsTextInput.getText());
                    TicketFactory ticketFactory = new TicketFactory();
                    AddTicketState.inter.changeState(new DivideTicketState(AddTicketState.inter,
                                                                    ticketFactory.getTicket(AddTicketState.naamTextInput.getText(),
                                                                    (String) Objects.requireNonNull(AddTicketState.ticketBox.getSelectedItem()),
                                                                    d,
                                                                    AddTicketState.getUser((String) AddTicketState.betaaldBox.getSelectedItem()))));
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, AddTicketState.inter.currentLanguage.priceNotValidError());
                }
            }

        }
    }
}
