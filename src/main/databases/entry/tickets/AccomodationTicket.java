package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class AccomodationTicket extends TicketEntry {
    public AccomodationTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Accomodation", price, paidBy);
    }
}
