package exceptions;

public class InvalidSoilTypeException extends InvalidTypeException {

    public InvalidSoilTypeException(){}

    public InvalidSoilTypeException(String msg) {
        super(msg);
    }

}
