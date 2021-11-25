package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class TransportationTicket extends TicketEntry {
    public TransportationTicket(String name, String ticketType, double price, PersonEntry paidBy) {
        super(name, ticketType, price, paidBy);
    }
}
