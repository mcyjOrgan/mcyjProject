package common.exception;

public class AppException extends Exception{
    private String code;
    private String msg;
    public AppException(String code, String exception){
        super(exception);
        this.code = code;
    }
    public AppException(String code,String message, String exception){
        super(exception);
        this.code = code;
        this.msg=message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
