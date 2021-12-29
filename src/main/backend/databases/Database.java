package backend.databases;


import java.beans.PropertyChangeSupport;
import java.util.HashMap;

public abstract class Database<T>
{
    protected final HashMap<String, T> db;
    protected final PropertyChangeSupport changes;

    public Database() {
        this.db = new HashMap<>();
        this.changes = new PropertyChangeSupport(this);
        addObservers();
    }

    public HashMap<String, T>  getDB() {
        return this.db;
    }

    public abstract void addEntry(T entry);
    public abstract void removeEntry(T entry);
    public abstract T getEntry(String name);
    public abstract void addObservers();
}
