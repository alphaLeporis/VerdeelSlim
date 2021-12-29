package databases.controllers;


import databases.entry.DatabaseEntry;

import java.util.HashMap;

public interface Controller<T>
{
    void createEntry(T entry);
    void removeEntry(T entry);
    HashMap<String, T> getAllEntries();
}
