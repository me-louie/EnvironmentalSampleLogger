package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Observable extends JPanel {

    private List<Observer> observers;

    //MODIFIES: this
    //EFFECTS: creates new empty list of observers
    protected Observable() {
        observers = new ArrayList<>();
    }

    //MODIFIES: this
    //adds observer to list of observers
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    //EFFECTS: returns size of observer list
    public int getObserverSize() {
        return observers.size();
    }


    //EFFECTS: updates list of observers
    void notifyObservers(BoreholeLog boreholeLog) {
        for (Observer observer : observers) {
            observer.update(boreholeLog);
        }

    }
}
