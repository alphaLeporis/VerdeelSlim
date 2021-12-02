package databases;


import java.beans.PropertyChangeListener;

public abstract class Database
{
    public Database() {}

    public abstract Database getDB();

    abstract void addListeners(PropertyChangeListener observer);

}
