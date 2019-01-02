package common.exception;

@SuppressWarnings("serial")
public class BaseUploadException extends Exception{
	private Integer code;
	private String msg;

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg(){
		return this.msg;
	}
	public void setMsg(String msg){
		this.msg = msg;
	}

	BaseUploadException(Integer code, String msg, String exception){
		super(exception);
		this.code = code;
		this.msg = msg;
	}
	BaseUploadException(Integer code, String msg, Throwable e){
		super(e);
		this.code = code;
		this.msg = msg;
	}
}
