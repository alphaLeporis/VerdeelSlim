package backend.databases;

import backend.databases.controllers.DebtController;
import backend.entry.tickets.TicketEntry;
import observers.database.RecalculateDebtObserver;
import observers.database.SaveDatabaseObserver;


public class TicketsDatabase extends Database<TicketEntry>{
    private static TicketsDatabase instance;
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

    public static void clearTicketsDatabase() {
        instance = new TicketsDatabase();
    }

    @Override
    public void addObservers() {
        changes.addPropertyChangeListener(new SaveDatabaseObserver());
        changes.addPropertyChangeListener(new RecalculateDebtObserver());
    }

    @Override
    public void addEntry(TicketEntry entry) {
        this.db.put(entry.getName(), entry);
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


}
