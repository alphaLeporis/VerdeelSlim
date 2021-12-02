package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class AmusementTicket extends TicketEntry {
    public AmusementTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Amusement", price, paidBy);
    }
}
