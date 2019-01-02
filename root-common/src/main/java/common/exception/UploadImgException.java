package common.exception;

public class UploadImgException extends BaseUploadException {

    /**
     *
     */
    private static final long serialVersionUID = 7400051057921543564L;

    public UploadImgException(Integer code, String msg, String exception) {
        super(code, msg, exception);
    }

    public UploadImgException(Integer code, String msg, Throwable e) {
        super(code, msg, e);
    }
}