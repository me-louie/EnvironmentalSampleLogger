package model;

public class LogBuilder implements Observer {
    @Override
    public String update(SoilSample s) {
        System.out.println("A " + s.getColour() + " sample has been added.");
        return s.getColour();

    }
}
