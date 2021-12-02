package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class GenericTicket extends TicketEntry {
    public GenericTicket(String name, String ticketType, double price, PersonEntry paidBy) {
        super(name, ticketType, price, paidBy);
    }
}
