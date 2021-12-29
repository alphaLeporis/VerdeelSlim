package databases;

import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;
import observers.database.SaveDatabaseObserver;

import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class PersonsDatabase extends Database<PersonEntry> {
    private static final PersonsDatabase instance;

    static {
        instance = new PersonsDatabase();
    }

    public PersonsDatabase() {
        super();
    }

    public static PersonsDatabase getInstance() {
        return instance;
    }

    @Override
    public void addObservers() {
        changes.addPropertyChangeListener(new SaveDatabaseObserver());
    }

    @Override
    public void addEntry(PersonEntry entry) {
        this.db.put(entry.getName(), (PersonEntry) entry);
        changes.firePropertyChange("PersonsDB-add", null, this.db);
    }

    @Override
    public void removeEntry(PersonEntry entry) {
        this.db.remove(entry.getName());
        changes.firePropertyChange("PersonsDB-rm", null, this.db);
    }

    @Override
    public PersonEntry getEntry(String name) {
        return this.db.get(name);
    }
}
