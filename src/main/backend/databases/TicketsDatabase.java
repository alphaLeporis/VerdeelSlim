package backend.databases;

import backend.databases.controllers.DebtController;
import backend.entry.tickets.TicketEntry;
import observers.database.RecalculateDebtObserver;
import observers.database.SaveDatabaseObserver;


public class TicketsDatabase extends Database<TicketEntry>{
    private static final TicketsDatabase instance;
    private final DebtController debtController;

    static {
        instance = new TicketsDatabase();
    }

    public TicketsDatabase() {
        super();
        debtController = new DebtController();
    }

    public static TicketsDatabase getInstance() {
        return instance;
    }

    @Override
    public void addObservers() {
        changes.addPropertyChangeListener(new SaveDatabaseObserver());
        changes.addPropertyChangeListener(new RecalculateDebtObserver());
    }

    @Override
    public void addEntry(TicketEntry entry) {
        this.db.put(entry.getName(), (TicketEntry) entry);
        debtController.createEntry(entry);
        changes.firePropertyChange("TicketsDB-add", null, this.db);
    }

    @Override
    public void removeEntry(TicketEntry entry) {
        debtController.removeEntry(entry);
        this.db.remove(entry.getName());
        changes.firePropertyChange("TicketsDB-rm", null, this.db);
    }

    @Override
    public TicketEntry getEntry(String name) {
        return this.db.get(name);
    }


/*    public void addDebtsToPersons(TicketEntry ticket){
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        PersonsDatabase.getInstance().getDB().get(ticket.getPaidBy().getName()).addAmountPaid(ticket.getPrice());
        for (String name : ticket.getTicketSplitMap().getSplitMap().keySet()) {
            personsDatabase.getDB().get(name).addAmountBorrowed(ticket.getTicketSplitMap().getSplitMap().get(name));
        }
    }

    public void removeDebtsFromPersons(TicketEntry ticket){
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        personsDatabase.getDB().get(ticket.getPaidBy().getName()).reduceAmountPaid(ticket.getPrice());
        for (String name : ticket.getTicketSplitMap().getSplitMap().keySet()) {
            personsDatabase.getDB().get(name).reduceAmountBorrowed(ticket.getTicketSplitMap().getSplitMap().get(name));
        }

    }*/
}
