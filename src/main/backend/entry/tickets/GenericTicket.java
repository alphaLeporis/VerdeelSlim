package backend.entry.tickets;

import backend.entry.person.PersonEntry;

public class GenericTicket extends TicketEntry {
    public GenericTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Generic", price, paidBy);
    }
}
