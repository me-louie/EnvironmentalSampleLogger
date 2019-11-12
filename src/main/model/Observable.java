package model;

import java.util.ArrayList;
import java.util.List;

public class Observable {

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

    void notifyObservers(SoilSample s) {
        for (Observer observer : observers) {
            observer.update(s);
        }

    }
}
