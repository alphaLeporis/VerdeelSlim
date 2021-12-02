package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class TransportationTicket extends TicketEntry {
    public TransportationTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Transportation", price, paidBy);
    }
}
