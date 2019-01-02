package com.quick4j.vo.dept;

import com.root.dto.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "删除部门入参")
public class DeleteDepartmentVo extends BaseReqVO{

    @ApiModelProperty(value = "部门ID")
    private List<Long> deptIds;

    public DeleteDepartmentVo() {
    }

    public List<Long> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<Long> deptIds) {
        this.deptIds = deptIds;
    }
}
