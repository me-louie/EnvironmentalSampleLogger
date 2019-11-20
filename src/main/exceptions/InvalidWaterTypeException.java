package exceptions;

public class InvalidWaterTypeException extends InvalidTypeException {

    //EFFECTS: constructs new InvalidWaterTypeException with specified message
    public InvalidWaterTypeException(String msg) {
        super(msg);
    }
}
