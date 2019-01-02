package com.root.dto;

import javax.validation.constraints.Min;

public class BaseListReqVO extends BaseReqVO{

    private Integer offset;
    
    private Integer limit;
    @Min(1)
    private Integer page;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public BaseListReqVO() {
        super();
    }

    @Override
    public String toString() {
        return "BaseListReqVO{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", page=" + page +
                '}';
    }
}
