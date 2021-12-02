package databases;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

public class BillCalculator {

    public BillCalculator() {
    }

    public void calculateBill() {
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        TicketsDatabase ticketsDatabase = TicketsDatabase.getInstance();

        for (TicketEntry ticket : ticketsDatabase.getDB().values()) {
            for (String name : ticket.getTicketSplitMap().getSplitMap().keySet()) {
                if (name.equals(ticket.getPaidBy().getName()))
                    personsDatabase.getDB().get(name).addAmountPaid(ticket.getPrice());
                personsDatabase.getDB().get(name).addAmountBorrowed(ticket.getTicketSplitMap().getSplitMap().get(name));
            }
        }
    }
}
