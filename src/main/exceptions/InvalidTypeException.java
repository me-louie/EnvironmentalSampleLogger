package exceptions;

public class InvalidTypeException extends Exception {

    public InvalidTypeException(){}

    public InvalidTypeException(String msg) {
        super(msg);
    }
}
