package observers.database;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SaveDatabaseObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Pim Padaboem observeridoo");
    }
}
