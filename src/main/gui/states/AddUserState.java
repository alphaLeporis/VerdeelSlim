package gui.states;

import gui.Interface;
import observers.gui.AddUserStateOberserver;

import java.awt.*;

public class AddUserState extends State {
    private final AddUserStateOberserver observer = new AddUserStateOberserver();
    public static Button addUser;
    public static Button goBack;
    public static TextField nameUser;

    public AddUserState(Interface inter) {
        super(inter);
    }

    @Override
    void setLayout() {
        pane.setLayout(new GridLayout(0, 2));
    }

    @Override
    void createUIElements() {
        TextField nameUserText = new TextField(super.language.userName());
        addUser = new Button(super.language.addUser());
        goBack = new Button(super.language.goBack());
        nameUser = new TextField();

        nameUserText.setEditable(false);

        pane.add(nameUserText);
        pane.add(nameUser);
        pane.add(goBack);
        pane.add(addUser);
    }

    @Override
    void initActionListener() {
        nameUser.addActionListener(observer);
        addUser.addActionListener(observer);
        goBack.addActionListener(observer);
    }
}
