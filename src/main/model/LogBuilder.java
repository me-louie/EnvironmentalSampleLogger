package model;

public class LogBuilder implements Observer {
    @Override
    public String update(BoreholeLog boreholeLog) {
//        System.out.println("A " + s.getColour() + " sample has been added.");
//        return s.getColour();
        return "colour";
    }
}
