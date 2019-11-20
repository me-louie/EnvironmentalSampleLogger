package exceptions;

public class InvalidSoilTypeException extends InvalidTypeException {

    //EFFECTS: constructs new InvalidSoilTypeException with specified message
    public InvalidSoilTypeException(String msg) {
        super(msg);
    }

}
