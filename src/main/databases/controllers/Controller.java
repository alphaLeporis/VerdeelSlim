package databases.controllers;


import java.beans.PropertyChangeListener;

public interface Controller
{
    void addListeners(PropertyChangeListener observer);
}
