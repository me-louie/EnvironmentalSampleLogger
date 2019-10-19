package ui.exceptions;

public class SampleNameAlreadyUsedException extends Exception {

    public SampleNameAlreadyUsedException(){}

    public SampleNameAlreadyUsedException(String msg) {
        super(msg);
    }
}
