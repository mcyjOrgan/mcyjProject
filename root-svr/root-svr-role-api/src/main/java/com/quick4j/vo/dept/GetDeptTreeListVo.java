package com.quick4j.vo.dept;

import com.root.Base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询可否删除入参")
public class GetDeptTreeListVo extends BaseVo {

    @ApiModelProperty(value = "企业编码")
    private String entSerno;

    public GetDeptTreeListVo() {
    }

    public String getEntSerno() {
        return entSerno;
    }

    public void setEntSerno(String entSerno) {
        this.entSerno = entSerno;
    }
}
