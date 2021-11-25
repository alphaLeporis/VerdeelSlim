package databases;


import java.beans.PropertyChangeListener;

public abstract class Database
{
    public Database() {}

    abstract void addListeners(PropertyChangeListener observer);

}
