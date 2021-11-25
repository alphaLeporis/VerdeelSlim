package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class RestaurantTicket extends TicketEntry {
    public RestaurantTicket(String ticketType, double price, PersonEntry paidBy) {
        super(ticketType, price, paidBy);
    }
}
