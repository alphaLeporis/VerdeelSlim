package backend.entry.tickets;

import backend.entry.person.PersonEntry;

public class AmusementTicket extends TicketEntry {
    public AmusementTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Amusement", price, paidBy);
    }
}
