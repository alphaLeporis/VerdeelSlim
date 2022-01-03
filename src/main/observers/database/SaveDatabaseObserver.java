package observers.database;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// Can be implemented to save to a database or csv file handler...
public class SaveDatabaseObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //System.out.println(evt.getNewValue());
    }
}
