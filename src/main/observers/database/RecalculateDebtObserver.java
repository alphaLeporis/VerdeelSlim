package observers.database;

import backend.calculator.BillCalculator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RecalculateDebtObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("CaCHING - Bill is calculated...");
        BillCalculator.getInstance().calculateBill();
    }
}
