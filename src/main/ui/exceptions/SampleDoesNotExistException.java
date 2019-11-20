package ui.exceptions;

public class SampleDoesNotExistException extends Exception {

    //EFFECTS: constructs new SampleDoesNotExist exception with specified message
    public SampleDoesNotExistException(String msg) {
        super(msg);
    }
}
