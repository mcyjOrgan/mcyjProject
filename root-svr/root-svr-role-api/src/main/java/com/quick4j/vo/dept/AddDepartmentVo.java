package com.quick4j.vo.dept;

import com.root.dto.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "添加部门")
public class AddDepartmentVo extends BaseReqVO {

    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    @ApiModelProperty(value = "企业编码")
    private String entSerno;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "上级部门ID")
    private Long upDeptId;

    @ApiModelProperty(value = "上级部门名称")
    private Long upDeptName;

    @ApiModelProperty(value = "排序")
    private Integer deptOrder;

    @ApiModelProperty(value = "部门描述")
    private String deptDesc;

    @ApiModelProperty(value = "操作人")
    private Long op;

    @ApiModelProperty(value = "操作时间")
    private String opDate;

    public AddDepartmentVo() {
    }

    public Long getUpDeptName() {
        return upDeptName;
    }

    public void setUpDeptName(Long upDeptName) {
        this.upDeptName = upDeptName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getEntSerno() {
        return entSerno;
    }

    public void setEntSerno(String entSerno) {
        this.entSerno = entSerno;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getUpDeptId() {
        return upDeptId;
    }

    public void setUpDeptId(Long upDeptId) {
        this.upDeptId = upDeptId;
    }

    public Integer getDeptOrder() {
        return deptOrder;
    }

    public void setDeptOrder(Integer deptOrder) {
        this.deptOrder = deptOrder;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

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
}
