package com.root.dto;

public class LrzjlResultInteger {

	private Integer id;
	   
	private Integer code;
	 
	private String message;
	 
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
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

	@Override
	public String toString() {
		return "RetIntegerRsp [id=" + id + ", code=" + code + ", message=" + message + ", description=" + description
				+ "]";
	}
	
	
}
