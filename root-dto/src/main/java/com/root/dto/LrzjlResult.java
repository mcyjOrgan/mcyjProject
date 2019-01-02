package com.root.dto;

import java.io.Serializable;

public class LrzjlResult implements Serializable {
	
	private Integer code;
	
	private String message;
	
	private String description;
	
	public LrzjlResult() {

    }

    public Integer getCode() {
		return this.code;		
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	
	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setValue(Integer code, String Msg, String desc){
        this.code = code;
        this.message = Msg;
        this.description = desc;
    }
    
    public String toString() {
        return "code: " + code + "; message: " + message + "; description: " + description;
    }

}
