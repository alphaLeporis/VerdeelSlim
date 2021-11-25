package databases.controllers;


import databases.entry.DatabaseEntry;

import java.beans.PropertyChangeListener;

public interface Controller
{
    public void createEntry(DatabaseEntry entry);
    public void removeEntry(DatabaseEntry entry);
    public void modifyEntry(DatabaseEntry entry);
}
