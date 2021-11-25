package databases.controllers;

import databases.Database;
import databases.entry.DatabaseEntry;

public class TicketsController implements Controller{

    private Database db;

    public TicketsController(Database db)
    {
        this.db = db;
    }

    @Override
    public void createEntry(DatabaseEntry entry) {

    }

    @Override
    public void removeEntry(DatabaseEntry entry) {

    }

    @Override
    public void modifyEntry(DatabaseEntry entry) {

    }
}
