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

    public HashMap<String, PersonEntry> getDb() {
        return db;
    }

    public PersonsDatabase() {
        this.db = new HashMap<>();
    }


    @Override
    void addListeners(PropertyChangeListener observer) {

    }
}
