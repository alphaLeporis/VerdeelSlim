package gui;
import gui.i18n.*;
import gui.states.StartState;
import gui.states.State;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Interface extends JFrame {
    private Container pane;
    private State currentState;
    public Language currentLanguage;
    protected static ArrayList<Language> installedLanguages = new ArrayList<>();


    public void init() {
        pane = this.getContentPane();
        initLanguages();
        currentState = new StartState(this);
        currentState.init();
    }

    public void changeState(State newState) {
        pane.removeAll();
        currentState = newState;
        currentState.init();
        revalidate();
    }

    public Container getPane() {
        return pane;
    }

    private void initLanguages() {
        currentLanguage = new Nederlands();
        installedLanguages.add(new English());
        installedLanguages.add(new French());
        installedLanguages.add(new Russian());
    }

    public Language nextlanguageInList() {
        return installedLanguages.get(0);
    }

    public void ChangeLanguageToNext() {
        installedLanguages.add(currentLanguage);
        currentLanguage = installedLanguages.get(0);
        installedLanguages.remove(0);
        System.out.println(currentLanguage);
    }
}