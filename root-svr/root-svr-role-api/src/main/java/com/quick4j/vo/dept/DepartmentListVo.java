package com.quick4j.vo.dept;

import com.root.Base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "获取部门列表模型")
public class DepartmentListVo extends BaseVo {




    @ApiModelProperty(value = "部门名称")
    private String deptName;



    public DepartmentListVo() {
    }


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
