package databases.controllers;

import databases.Database;
import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;


import java.util.HashMap;

public class PersonsController implements Controller
{
    private Database db;

    public PersonsController(Database db)
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

    @Override
    public HashMap<String, PersonEntry> getAllEntries() {
        return db.getDB();
    }
}
