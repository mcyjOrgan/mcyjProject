package common.exception;

/**
 * Created by cc on 2018/2/21.
 */
public class TokenTypeException extends Exception{

    private Integer code;
    private String msg;

    public TokenTypeException(Integer code, String msg, String exception) {
        super(exception);
        this.code = code;
        this.msg = msg;
    }

    public TokenTypeException(String message, Throwable cause, Integer code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }
}
