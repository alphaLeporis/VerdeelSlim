package databases.controllers;

import databases.Database;
import databases.entry.DatabaseEntry;


import java.beans.PropertyChangeSupport;

public class PersonsController implements Controller
{
    private Database db;

    public PersonsController(Database db)
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
}
