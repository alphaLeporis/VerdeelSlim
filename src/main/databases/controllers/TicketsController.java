package databases.controllers;

import databases.TicketsDatabase;
import databases.entry.DatabaseEntry;
import databases.entry.TicketEntry;

import java.util.HashMap;

public class TicketsController implements Controller<TicketEntry> {

    private final TicketsDatabase db;

    public TicketsController(TicketsDatabase db)
    {
        this.db = db;
    }

    @Override
    public void createEntry(DatabaseEntry entry) {
        this.db.addEntry(entry);
    }

    @Override
    public void removeEntry(DatabaseEntry entry) {
        this.db.removeEntry(entry);
    }

    @Override
    public HashMap<String, TicketEntry> getAllEntries() {
        return db.getDB();
    }
}
