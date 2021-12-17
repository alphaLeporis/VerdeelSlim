package databases;

import databases.entry.DatabaseEntry;
import databases.entry.TicketEntry;

import java.beans.PropertyChangeListener;
import java.util.HashMap;


public class TicketsDatabase extends Database {
    private static final CSVHandler<TicketEntry> handler;
    private static final TicketsDatabase instance;
    static {
        instance = new TicketsDatabase();
        handler = new CSVHandler<>();
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
        save();
    }

    @Override
    public void removeEntry(DatabaseEntry entry) {
        this.db.remove(entry.getName());
        save();
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

    @Override
    void save() {
        try {
            handler.writeHashMapToCsv(this.db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
