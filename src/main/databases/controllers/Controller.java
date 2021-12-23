package databases.controllers;


import databases.entry.DatabaseEntry;

import java.util.HashMap;

public interface Controller<T>
{
    void createEntry(DatabaseEntry entry);
    void removeEntry(DatabaseEntry entry);
    void modifyEntry(DatabaseEntry entry);
    HashMap<String, T> getAllEntries();
}
