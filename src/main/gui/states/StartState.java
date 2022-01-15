package gui.states;

import gui.Interface;
import observers.gui.StartStateObserver;

import java.awt.*;

public class StartState extends State {
    private final StartStateObserver observer = new StartStateObserver();
    public static Button lookUsers;
    public static Button addTicket;
    public static Button lookTicket;
    public static Button calculate;
    public static Button exit;
    public static Button changeLanguage;

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
        changeLanguage.addActionListener(observer);
        exit.addActionListener(observer);
    }

    @Override
    void createUIElements() {
        lookUsers = new Button(inter.currentLanguage.viewUsers());
        addTicket = new Button(inter.currentLanguage.addTicket());
        lookTicket = new Button(inter.currentLanguage.viewTickets());
        calculate = new Button(inter.currentLanguage.calculate());
        changeLanguage = new Button(inter.nextlanguageInList().changeLanguage());
        exit = new Button(inter.currentLanguage.exit());

        pane.add(lookUsers);
        pane.add(addTicket);
        pane.add(lookTicket);
        pane.add(calculate);
        pane.add(changeLanguage);
        pane.add(exit);
    }
}
