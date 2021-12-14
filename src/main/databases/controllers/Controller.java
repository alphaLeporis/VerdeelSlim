package databases.controllers;


import databases.entry.DatabaseEntry;

import java.util.HashMap;

public interface Controller<T>
{
    public void createEntry(DatabaseEntry entry);
    public void removeEntry(DatabaseEntry entry);
    public void modifyEntry(DatabaseEntry entry);
    public HashMap<String, T> getAllEntries();
}
