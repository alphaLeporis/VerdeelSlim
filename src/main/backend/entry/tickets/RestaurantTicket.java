package backend.entry.tickets;

import backend.entry.person.PersonEntry;

public class RestaurantTicket extends TicketEntry {

    public RestaurantTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Restaurant", price, paidBy);
    }
}
