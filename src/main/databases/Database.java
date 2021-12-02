package databases;


import databases.entry.DatabaseEntry;
import databases.entry.PersonEntry;

import java.beans.PropertyChangeListener;
import java.util.HashMap;

public abstract class Database
{
    public Database() {}

    abstract void addListeners(PropertyChangeListener observer);

}
