package observers.gui;

import backend.entry.tickets.TicketFactory;
import gui.states.AddState;
import gui.states.DivideTicketState;
import gui.states.StartState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class AddStateObserver extends StateObserver{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddState.goBack) {
            AddState.inter.changeState(new StartState(AddState.inter));
        }

        if (e.getSource() == AddState.addTicket) {
            System.out.println(AddState.ticketBox.getSelectedItem());
            System.out.println(AddState.prijsTextInput.getText().length());
            if (AddState.prijsTextInput.getText().length() == 0) {
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Vul een prijs in!");
            } else {
                try {
                    double d = Double.parseDouble(AddState.prijsTextInput.getText());
                    TicketFactory ticketFactory = new TicketFactory();
                    AddState.inter.changeState(new DivideTicketState(AddState.inter,
                                                                    ticketFactory.getTicket(AddState.naamTextInput.getText(),
                                                                    (String) Objects.requireNonNull(AddState.ticketBox.getSelectedItem()),
                                                                    d,
                                                                    AddState.getUser((String) AddState.betaaldBox.getSelectedItem()))));
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Dit is geen geldige prijs!");
                }
            }

        }
    }
}
