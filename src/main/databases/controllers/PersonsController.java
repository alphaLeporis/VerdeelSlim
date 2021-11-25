package databases.controllers;

import database.Database;
import employee.Employee;
import javafx.util.Pair;
import register_entry.RegisterEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PersonsController implements Controller
{
    private Database db;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public PersonsController(Database db)
    {
        this.db = db;
    }

    @Override
    public void checkIn(Employee e)
    {
        RegisterEntry entry = new RegisterEntry(true);
        db.addEntry(e, entry);
        pcs.firePropertyChange("checkIn", null, new Pair<RegisterEntry,String> (entry, e.getName()));
    }

    @Override
    public void checkOut(Employee e)
    {
        RegisterEntry entry = new RegisterEntry(false);
        db.addEntry(e, entry);
        pcs.firePropertyChange("checkOut", null, new Pair<RegisterEntry,String> (entry, e.getName()));
    }


    @Override
    public void addListeners(PropertyChangeListener observer) {
        pcs.addPropertyChangeListener(observer);
    }
}
