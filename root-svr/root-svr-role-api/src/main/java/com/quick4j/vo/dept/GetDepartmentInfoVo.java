package com.quick4j.vo.dept;

import com.root.Base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "获取部门详情入参")
public class GetDepartmentInfoVo extends BaseVo {

    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    public GetDepartmentInfoVo() {
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
