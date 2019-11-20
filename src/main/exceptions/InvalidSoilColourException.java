package exceptions;

public class InvalidSoilColourException extends Exception {

    //EFFECTS: constructs new InvalidSoilColourException with specified message
    public InvalidSoilColourException(String msg) {
        super(msg);
    }
}
