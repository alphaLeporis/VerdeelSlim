package gui.components;

import backend.entry.tickets.TicketEntry;

import javax.swing.*;
import java.awt.*;

public class ticketLayout {
    final String name;
    final TicketEntry entry;
    public ticketLayout(String name, TicketEntry entry) {
        this.name = name;
        this.entry = entry;
    }

    public Component draw() {
        return new JLabel(name + " : "+ entry.getTicketType() +" : "+ entry.getPrice()+"€ : "+ entry.getPaidBy().getName());
    }
}
