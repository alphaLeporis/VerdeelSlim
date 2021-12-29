package backend.databases.controllers;

import backend.databases.TicketsDatabase;
import backend.entry.tickets.TicketEntry;

import java.util.HashMap;

public class TicketsController implements Controller<TicketEntry> {

    private final TicketsDatabase db;

    public TicketsController(TicketsDatabase db)
    {
        this.db = db;
    }

    @Override
    public void createEntry(TicketEntry entry) {
        this.db.addEntry(entry);
    }

    @Override
    public void removeEntry(TicketEntry entry) {
        this.db.removeEntry(entry);
    }

    @Override
    public HashMap<String, TicketEntry> getAllEntries() {
        return db.getDB();
    }
}
