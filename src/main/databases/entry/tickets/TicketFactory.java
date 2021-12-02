package databases.entry.tickets;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class TicketFactory {

    public TicketFactory() {
    }

    public TicketEntry getTicket(String name, String ticketType, double price, PersonEntry paidBy){
        if(ticketType.equals("Accomodation")){
            return new AccomodationTicket(name, price, paidBy);
        }
        else if (ticketType.equals("Amusement")){
            return new AmusementTicket(name, price, paidBy);
        }
        else if (ticketType.equals("Restaurant")){
            return new RestaurantTicket(name, price, paidBy);
        }
        else if (ticketType.equals("Transportation")){
            return new TransportationTicket(name, price, paidBy);
        }
        else{
            return null;
        }
    }
}
