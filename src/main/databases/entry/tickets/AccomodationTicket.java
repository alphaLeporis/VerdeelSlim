package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class AccomodationTicket extends TicketEntry {
    public AccomodationTicket(String name, String ticketType, double price, PersonEntry paidBy) {
        super(name, ticketType, price, paidBy);
    }
}
