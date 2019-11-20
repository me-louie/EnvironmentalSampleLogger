package exceptions;

public class InvalidTypeException extends Exception {


    //EFFECTS: constructs new InvalidSoilTypeException with specified message
    public InvalidTypeException(String msg) {
        super(msg);
    }
}
