package com.root.Base;

import io.swagger.annotations.ApiModel;

/**
 * Created by shusican on 2017/8/2.
 */
@ApiModel
public class BaseListVo extends BaseVo{

    private Integer offset;
    private Integer cnt;

    public BaseListVo() {
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
}
