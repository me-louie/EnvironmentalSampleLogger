package ui.exceptions;

public class SampleNameAlreadyUsedException extends Exception {

    //EFFECTS: constructs new SampleNameAlreadyUsed exception with specified message
    public SampleNameAlreadyUsedException(String msg) {
        super(msg);
    }
}
