package databases;


import databases.entry.DatabaseEntry;

import java.beans.PropertyChangeListener;
import java.util.HashMap;

public abstract class Database
{
    public Database() {}

    public abstract void addEntry(DatabaseEntry entry);
    public abstract void removeEntry(DatabaseEntry entry);
    public abstract DatabaseEntry getEntry(String name);

    public abstract HashMap getDB();

    abstract void addListeners(PropertyChangeListener observer);

}
