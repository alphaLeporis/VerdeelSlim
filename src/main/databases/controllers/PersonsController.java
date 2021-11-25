package databases.controllers;

import database.Database;
import databases.Database;
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

}
