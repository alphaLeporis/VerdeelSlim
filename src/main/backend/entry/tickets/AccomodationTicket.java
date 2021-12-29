package backend.entry.tickets;

import backend.entry.person.PersonEntry;

public class AccomodationTicket extends TicketEntry {
    public AccomodationTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Accomodation", price, paidBy);
    }
}
