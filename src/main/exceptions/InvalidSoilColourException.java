package exceptions;

public class InvalidSoilColourException extends Exception {
    public InvalidSoilColourException(){}

    public InvalidSoilColourException(String msg) {
        super(msg);
    }
}
