package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Observable extends JPanel {

    private List<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public int getObserverSize() {
        return observers.size();
    }

    void notifyObservers(BoreholeLog boreholeLog) {
        for (Observer observer : observers) {
            observer.update(boreholeLog);
        }

    }
}
