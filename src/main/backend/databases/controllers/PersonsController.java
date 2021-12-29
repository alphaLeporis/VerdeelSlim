package backend.databases.controllers;

import backend.databases.PersonsDatabase;
import backend.entry.person.PersonEntry;


import java.util.HashMap;

public class PersonsController implements Controller<PersonEntry>
{
    private final PersonsDatabase db;

    public PersonsController(PersonsDatabase db)
    {
        this.db = db;
    }

    @Override
    public void createEntry(PersonEntry entry) {
        this.db.addEntry(entry);
    }

    @Override
    public void removeEntry(PersonEntry entry) {
        this.db.removeEntry(entry);
    }

    @Override
    public HashMap<String, PersonEntry> getAllEntries() {
        return db.getDB();
    }
}
