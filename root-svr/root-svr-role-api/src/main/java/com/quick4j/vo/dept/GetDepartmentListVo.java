package com.quick4j.vo.dept;

import com.root.dto.BaseListReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "获取部门信息入参")
public class GetDepartmentListVo extends BaseListReqVO {


    @ApiModelProperty(value = "企业编号")
    private String entSerno;

    public GetDepartmentListVo() {
    }

    public String getEntSerno() {
        return entSerno;
    }

    public void setEntSerno(String entSerno) {
        this.entSerno = entSerno;
    }
}

