package com.quick4j.vo.dept;

import com.root.Base.BaseVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class DepartmentTreeVo extends BaseVo {

    @ApiModelProperty(value = "部门Id")
    private String deptId;

    @ApiModelProperty(value = "父部门Id")
    private String upDeptId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "子部门集合")
    private List<DepartmentTreeVo> childDept;

    public DepartmentTreeVo() {
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUpDeptId() {
        return upDeptId;
    }

    public void setUpDeptId(String upDeptId) {
        this.upDeptId = upDeptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<DepartmentTreeVo> getChildDept() {
        return childDept;
    }

    public void setChildDept(List<DepartmentTreeVo> childDept) {
        this.childDept = childDept;
    }
}
