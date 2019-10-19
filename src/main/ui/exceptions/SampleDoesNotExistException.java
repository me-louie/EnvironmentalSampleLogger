package ui.exceptions;

public class SampleDoesNotExistException extends Exception {

    public SampleDoesNotExistException(){}

    public SampleDoesNotExistException(String msg) {
        super(msg);
    }
}
