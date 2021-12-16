package gui.components;

import databases.entry.TicketEntry;

import javax.swing.*;
import java.awt.*;

public class ticketLayout {
    String name;
    TicketEntry entry;
    public ticketLayout(String name, TicketEntry entry) {
        this.name = name;
        this.entry = entry;
    }

    public Component draw() {
        return new JLabel(name + " : "+ entry.getTicketType() +" : "+ entry.getPrice()+"€ : "+ entry.getPaidBy().getName());
    }
}
