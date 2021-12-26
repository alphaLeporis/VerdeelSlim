package databases.controllers;

import databases.PersonsDatabase;
import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;


import java.util.HashMap;

public class PersonsController implements Controller<PersonEntry>
{
    private final PersonsDatabase db;

    public PersonsController(PersonsDatabase db)
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
    public HashMap<String, PersonEntry> getAllEntries() {
        return db.getDB();
    }
}
