package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class RestaurantTicket extends TicketEntry {

    public RestaurantTicket(String name, double price, PersonEntry paidBy) {
        super(name, "Restaurant", price, paidBy);
    }
}
