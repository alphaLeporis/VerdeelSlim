package databases;

import databases.entry.PersonEntry;
import databases.entry.PersonEntryComparator;
import databases.entry.TicketEntry;

import java.util.*;

public class BillCalculator {

    public BillCalculator() {
    }

    public void calculateBill() {
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        TicketsDatabase ticketsDatabase = TicketsDatabase.getInstance();

        for (TicketEntry ticket : ticketsDatabase.getDB().values()) {
            personsDatabase.getDB().get(ticket.getPaidBy().getName()).addAmountPaid(ticket.getPrice());
            for (String name : ticket.getTicketSplitMap().getSplitMap().keySet()) {
                personsDatabase.getDB().get(name).addAmountBorrowed(ticket.getTicketSplitMap().getSplitMap().get(name));
                personsDatabase.getDB().get(name).calcNetAmount();
            }
        }
        debtCalculator();
    }

    public void debtCalculator(){
        List<PersonEntry> personsDatabase = new ArrayList<PersonEntry>(PersonsDatabase.getInstance().getDB().values());
        personsDatabase.sort(new PersonEntryComparator());
    }
}
