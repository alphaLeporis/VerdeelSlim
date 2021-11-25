package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class AmusementTicket extends TicketEntry {
    public AmusementTicket(String ticketType, double price, PersonEntry paidBy) {
        super(ticketType, price, paidBy);
    }
}