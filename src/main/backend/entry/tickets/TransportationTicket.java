package backend.entry.tickets;

import backend.entry.person.PersonEntry;

public class TransportationTicket extends TicketEntry {
    public TransportationTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Transportation", price, paidBy);
    }
}
