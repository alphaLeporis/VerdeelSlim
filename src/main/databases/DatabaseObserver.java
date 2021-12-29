package databases;

import calculator.BillCalculator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DatabaseObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        BillCalculator.getInstance().calculateBill();
    }
}
