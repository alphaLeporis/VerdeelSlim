package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class TransportationTicket extends TicketEntry {
    public TransportationTicket(String ticketType, double price, PersonEntry paidBy) {
        super(ticketType, price, paidBy);
    }
}
