package databases;

import databases.entry.PersonEntry;

import java.util.HashMap;

public class PersonsDatabase {

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

    public HashMap<String, PersonEntry> getDb() {
        return db;
    }
}
