package gui.states;

import calculator.BillCalculator;
import databases.Database;
import databases.PersonsDatabase;
import databases.controllers.PersonsController;
import databases.entry.PersonEntry;
import gui.Interface;
import gui.components.debtLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalculateState extends State {
    private final Interface inter;
    private final Container pane;

    private final Button goBack = new Button("Keer terug");

    public CalculateState(Interface inter) {
        this.inter = inter;
        this.pane = inter.getPane();
    }

    public void init() {
        HashMap<String, PersonEntry> allPersons = getDatabaseEntries();
        pane.setLayout(new GridLayout(0, 1));

        BillCalculator billCalculator = new BillCalculator();
        billCalculator.calculateBill();
        HashMap<String, ArrayList<Map.Entry<String, Double>>> debts = billCalculator.getDebtsList();

        for(Map.Entry<String, ArrayList<Map.Entry<String, Double>>> entry: debts.entrySet()){
            for(Map.Entry<String, Double> set: entry.getValue()){
                System.out.println(entry.getKey() + " gets/gives  to  " + set.getKey() + " amount: " + set.getValue());
                pane.add(new debtLayout(entry.getKey(), set.getKey(), set.getValue()).draw());
            }
        }

        goBack.addActionListener(this);
        pane.add(goBack);
    }

    private HashMap<String, PersonEntry> getDatabaseEntries() {
        Database personDB = PersonsDatabase.getInstance();
        return new PersonsController(personDB).getAllEntries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            inter.changeState(new StartState(this.inter));
        }
    }
}
