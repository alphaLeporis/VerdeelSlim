package databases.controllers;

import databases.Database;
import databases.entry.DatabaseEntry;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PersonsController implements Controller
{
    private Database db;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

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
}
