package databases.controllers;

import databases.PersonsDatabase;
import databases.entry.DatabaseEntry;
import databases.entry.TicketEntry;

import java.util.HashMap;

public class DebtController implements Controller<TicketEntry> {
    public DebtController() {}

    @Override
    public void createEntry(TicketEntry entry) {
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        PersonsDatabase.getInstance().getDB().get(entry.getPaidBy().getName()).addAmountPaid(entry.getPrice());
        for (String name : entry.getTicketSplitMap().getSplitMap().keySet()) {
            personsDatabase.getDB().get(name).addAmountBorrowed(entry.getTicketSplitMap().getSplitMap().get(name));
        }
    }

    @Override
    public void removeEntry(TicketEntry entry) {
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        personsDatabase.getDB().get(entry.getPaidBy().getName()).reduceAmountPaid(entry.getPrice());
        for (String name : entry.getTicketSplitMap().getSplitMap().keySet()) {
            personsDatabase.getDB().get(name).reduceAmountBorrowed(entry.getTicketSplitMap().getSplitMap().get(name));
        }
    }

    @Override
    public HashMap getAllEntries() {
        return null;
    }
}
