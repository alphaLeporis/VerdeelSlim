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
            System.out.println(sum);
            DivideTicketState.yourSum.setText("Totaal prijs: " + sum);
            if (sum != DivideTicketState.finalSum) {
                DivideTicketState.yourSum.setText("Jouw som: " + sum +
                        "\nDe correcte som: " + DivideTicketState.finalSum +
                        "\nJe mist: " + abs(DivideTicketState.finalSum - sum));

                DivideTicketState.yourSum.setBackground(Color.RED);
            } else {
                DivideTicketState.yourSum.setText("De correcte en jouw som: " + sum);
                DivideTicketState.yourSum.setBackground(null);
            }
        }


        if (e.getSource() == DivideTicketState.addTicket) {
            for (Map.Entry<String, JTextField> set : DivideTicketState.textEntries.entrySet()) {
                try {
                    double d = Double.parseDouble(set.getValue().getText());
                    DivideTicketState.entry.setAmount(DivideTicketState.getUser(set.getKey()), d);
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

            if (DivideTicketState.entry.checkPriceIsPaid()) {
                TicketsController ticketsController = new TicketsController(TicketsDatabase.getInstance());
                ticketsController.createEntry(DivideTicketState.entry);

                DivideTicketState.inter.changeState(new TicketState(DivideTicketState.inter));
            } else {
                JOptionPane.showMessageDialog(null, "Oei kijk je som na!");
            }

        }

        if (e.getSource() == DivideTicketState.goBack) {
            DivideTicketState.inter.changeState(new AddState(DivideTicketState.inter, DivideTicketState.entry));
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
