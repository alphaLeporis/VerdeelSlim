package databases;

import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;

import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class PersonsDatabase extends Database<PersonEntry> {
    private static final CSVHandler<PersonEntry> handler;
    private static final PersonsDatabase instance;
    static {
        instance = new PersonsDatabase();
        handler = new CSVHandler<>();
        System.out.println("DB started");
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
        save();
    }

    @Override
    public void removeEntry(DatabaseEntry entry) {
        this.db.remove(entry.getName());
        save();
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

    @Override
    void save() {
        try {
            handler.writeHashMapToCsv(this.db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
