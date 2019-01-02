package com.quick4j.vo.dept;

import com.root.dto.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "添加修改部门")
public class AddOrUpdateDepartmentVo extends BaseReqVO {

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    public AddOrUpdateDepartmentVo() {
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
