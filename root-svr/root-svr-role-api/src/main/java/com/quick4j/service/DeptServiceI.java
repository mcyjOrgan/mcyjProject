package com.quick4j.service;


import com.quick4j.vo.dept.*;
import com.root.Bean.Result;

import java.util.List;

public interface DeptServiceI {

    /**
     * 获取部门列表接口
     * @param getDepartmentListVo 获取列表入参
     * @return DepartmentListVo
     */
    Result<List<DepartmentListVo>> selectDepartmentList(GetDepartmentListVo getDepartmentListVo);

    /**
     * 添加部门
     * @param addOrUpdateDepartmentVo
     * @param
     * @return
     */
    Result create(AddOrUpdateDepartmentVo addOrUpdateDepartmentVo);


    /**
     * 获取部门详情
     * @param getDepartmentInfoVo
     * @return
     */
    Result selectDeptById(GetDepartmentInfoVo getDepartmentInfoVo);


}
