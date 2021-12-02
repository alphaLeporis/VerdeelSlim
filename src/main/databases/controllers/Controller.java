package databases.controllers;


import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;

import java.util.HashMap;

public interface Controller
{
    public void createEntry(DatabaseEntry entry);
    public void removeEntry(DatabaseEntry entry);
    public void modifyEntry(DatabaseEntry entry);
    public HashMap<String, PersonEntry> getAllEntries();
}
