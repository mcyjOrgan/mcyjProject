package com.root.dto;

public class BaseReqVO extends BaseVO{
    
    /*发起请求的当前用户的ID*/
    private Long op;
    
    /*发起请求的时间*/
    private String opDate;

    public Long getOp() {
        return op;
    }

    public void setOp(Long op) {
        this.op = op;
    }

    public String getOpDate() {
        return opDate;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    public BaseReqVO() {
        super();
    }
}
