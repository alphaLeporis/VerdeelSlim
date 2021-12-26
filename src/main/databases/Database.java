package databases;


import databases.entry.DatabaseEntry;

import java.beans.PropertyChangeListener;
import java.util.HashMap;

public abstract class Database<T>
{
    public Database() {}

    public abstract void addEntry(DatabaseEntry entry);
    public abstract void removeEntry(DatabaseEntry entry);
    public abstract DatabaseEntry getEntry(String name);

    public abstract HashMap<String, T>  getDB();

    abstract void addListeners(PropertyChangeListener observer);

    abstract void save();
}
