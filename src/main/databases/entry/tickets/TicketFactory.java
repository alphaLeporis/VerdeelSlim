package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class TicketFactory {

    public TicketFactory() {
    }

    public TicketEntry getTicket(String name, String ticketType, double price, PersonEntry paidBy){
        switch (ticketType) {
            case "Accomodation":
                return new AccomodationTicket(name, price, paidBy);
            case "Amusement":
                return new AmusementTicket(name, price, paidBy);
            case "Restaurant":
                return new RestaurantTicket(name, price, paidBy);
            case "Transportation":
                return new TransportationTicket(name, price, paidBy);
            default:
                return new GenericTicket(name, price, paidBy);
        }
    }
}
