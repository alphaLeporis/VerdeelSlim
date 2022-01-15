package observers.gui;

import backend.databases.TicketsDatabase;
import backend.databases.controllers.TicketsController;
import gui.states.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Thread.sleep;

public class DivideTicketStateObserver extends StateObserver{
    private final DivideTicketState state;
    public DivideTicketStateObserver(DivideTicketState state) {
        this.state = state;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == DivideTicketState.checkSum) {
            double sum = 0;
            for (Map.Entry<String, JTextField> set : DivideTicketState.textEntries.entrySet()) {
                try {
                    double d = Double.parseDouble(set.getValue().getText());
                    sum = sum + d;
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Dit is geen geldige prijs!");
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    return;
                }
            }
            DivideTicketState.yourSum.setText(State.inter.currentLanguage.totalPrice() + sum);
            if (sum != DivideTicketState.finalSum) {
                DivideTicketState.yourSum.setText(State.inter.currentLanguage.yourSum() + sum +
                        "\n"+State.inter.currentLanguage.correctSum() + DivideTicketState.finalSum +
                        "\n"+State.inter.currentLanguage.missingSum() + abs(DivideTicketState.finalSum - sum));

                DivideTicketState.yourSum.setBackground(Color.RED);
            } else {
                DivideTicketState.yourSum.setText(State.inter.currentLanguage.yourCorrectSum() + sum);
                DivideTicketState.yourSum.setBackground(null);
            }
        }


        if (e.getSource() == DivideTicketState.addTicket) {
            for (Map.Entry<String, JTextField> set : DivideTicketState.textEntries.entrySet()) {
                try {
                    double d = Double.parseDouble(set.getValue().getText());
                    DivideTicketState.entry.setAmount(DivideTicketState.getUser(set.getKey()), d);
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, State.inter.currentLanguage.priceNotValidError());
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    return;
                }
            }

            if (DivideTicketState.entry.checkPriceIsPaid()) {
                TicketsController ticketsController = new TicketsController(TicketsDatabase.getInstance());
                ticketsController.createEntry(DivideTicketState.entry);

                DivideTicketState.inter.changeState(new TicketState(DivideTicketState.inter));
            } else {
                JOptionPane.showMessageDialog(null, State.inter.currentLanguage.checkSumError());
            }

        }

        if (e.getSource() == DivideTicketState.goBack) {
            DivideTicketState.inter.changeState(new AddTicketState(DivideTicketState.inter, DivideTicketState.entry));
        }

        if (e.getSource() == DivideTicketState.option1) {
            state.getPane().removeAll();
            DivideTicketState.Even = true;
            state.init();
            DivideTicketState.inter.revalidate();
        }

        if (e.getSource() == DivideTicketState.option2) {
            state.getPane().removeAll();
            DivideTicketState.Even = false;
            state.init();
            DivideTicketState.inter.revalidate();
        }
    }
}
