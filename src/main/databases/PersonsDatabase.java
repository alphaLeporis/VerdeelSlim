package databases;

import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;

import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class PersonsDatabase extends Database {

    private static PersonsDatabase instance;
    static {
        instance = new PersonsDatabase();
    }

    public static PersonsDatabase getInstance() {
        return instance;
    }

    private final HashMap<String, PersonEntry> db;

    public PersonsDatabase() {
        this.db = new HashMap<>();
    }


    @Override
    public void addEntry(DatabaseEntry entry) {
        this.db.put(entry.getName(), (PersonEntry) entry);
    }

    @Override
    public void removeEntry(DatabaseEntry entry) {
        this.db.remove(entry.getName());
    }

    @Override
    public DatabaseEntry getEntry(String name) {
        return this.db.get(name);
    }

    @Override
    public HashMap<String, PersonEntry> getDB() {
        return this.db;
    }

    @Override
    void addListeners(PropertyChangeListener observer) {
    }
}
