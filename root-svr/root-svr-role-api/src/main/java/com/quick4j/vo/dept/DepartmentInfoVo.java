package com.quick4j.vo.dept;

import com.root.Base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "部门详情")
public class DepartmentInfoVo extends BaseVo {


    @ApiModelProperty(value = "部门名称")
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
