package databases;

import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class TicketsDatabase extends Database {

    private static TicketsDatabase instance;
    static {
        instance = new TicketsDatabase();
    }

    public static TicketsDatabase getInstance() {
        return instance;
    }

    private final HashMap<String, TicketEntry> db;

    public TicketsDatabase() {
        this.db = new HashMap<>();
    }

    @Override
    public void addEntry(DatabaseEntry entry) {
        this.db.put(entry.getName(), (TicketEntry) entry);
    }

    @Override
    public void removeEntry(DatabaseEntry entry) {
        this.db.remove(entry.getName());
    }

    @Override
    public DatabaseEntry getEntry(String name) {
        return this.db.get(name);
    }

    @Override
    public HashMap<String, TicketEntry> getDB() {
        return this.db;
    }

    @Override
    void addListeners(PropertyChangeListener observer) {

    }
}
