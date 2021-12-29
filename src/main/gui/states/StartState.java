package gui.states;

import com.vdurmont.emoji.EmojiParser;
import gui.Interface;
import observers.database.RecalculateDebtObserver;
import observers.gui.StartStateObserver;

import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class StartState extends State {
    private final StartStateObserver observer = new StartStateObserver();
    public static Button lookUsers;
    public static Button addTicket;
    public static Button lookTicket;
    public static Button calculate;
    public static Button exit;

    public StartState(Interface inter) {
        super(inter);
    }

    public void init() {
        setHeaderImage("/logo.png");
        super.init();
    }

    @Override
    void setLayout() {
        pane.setLayout(new GridLayout(0, 1));
    }

    @Override
    void initActionListener() {
        lookUsers.addActionListener(observer);
        addTicket.addActionListener(observer);
        lookTicket.addActionListener(observer);
        calculate.addActionListener(observer);
        exit.addActionListener(observer);
    }

    @Override
    void createUIElements() {
        lookUsers = new Button("Bekijk gebruikers ");
        addTicket = new Button("Voeg een ticket toe");
        lookTicket = new Button("Bekijk hudige tickets");
        calculate = new Button("Bereken");
        exit = new Button("Sluit af");

        pane.add(lookUsers);
        pane.add(addTicket);
        pane.add(lookTicket);
        pane.add(calculate);
        pane.add(exit);
    }
}
