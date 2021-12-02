package databases.controllers;

import databases.Database;
import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;

import java.util.HashMap;
import databases.entry.TicketEntry;

public class TicketsController implements Controller{

    private Database db;

    public TicketsController(Database db)
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
    public void modifyEntry(DatabaseEntry entry) {

    }

    @Override
    public HashMap<String, PersonEntry> getAllEntries() {

        return null;
    }
}
