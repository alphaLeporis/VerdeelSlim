package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class GenericTicket extends TicketEntry {
    public GenericTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Generic", price, paidBy);
    }
}
