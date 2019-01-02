package common.exception;


@SuppressWarnings("serial")
public class DataException extends Exception {

    private String errorMessage;

    public DataException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
