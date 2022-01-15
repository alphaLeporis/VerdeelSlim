package gui.states;

import backend.calculator.BillCalculator;
import gui.Interface;
import gui.components.debtLayout;
import observers.gui.CalculateStateObserver;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class CalculateState extends State {
    private final CalculateStateObserver observer = new CalculateStateObserver();

    public static Button goBack;

    public CalculateState(Interface inter) {
        super(inter);
    }

    @Override
    void setLayout() {
        pane.setLayout(new GridLayout(0, 1));
    }

    @Override
    void createUIElements() {
        goBack = new Button(inter.currentLanguage.goBack());

        for(Map.Entry<String, ArrayList<Map.Entry<String, Double>>> entry: BillCalculator.getInstance().getDebtsList().entrySet()){
            for(Map.Entry<String, Double> set: entry.getValue()){
                //System.out.println(entry.getKey() + inter.currentLanguage.getsGives() + set.getKey() + inter.currentLanguage.amount() + set.getValue());
                pane.add(new debtLayout(inter, entry.getKey(), set.getKey(), set.getValue()).draw());
            }
        }

        pane.add(goBack);
    }

    @Override
    void initActionListener() {
        goBack.addActionListener(observer);
    }
}
