package com.eliteams.quick4j.role;

import com.eliteams.quick4j.web.SessionControllerApi;
import com.quick4j.service.DeptServiceI;
import com.quick4j.vo.dept.*;
import com.root.Bean.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("api/dept")
@Api(value = "dept", description = "部门管理")
public class DeptController extends SessionControllerApi {

    @Autowired
    private DeptServiceI departmentServiceI;

    @RequestMapping(value = "deptList", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取部门列表")
    public Result<List<DepartmentListVo>> selectDepartmentList(@RequestBody GetDepartmentListVo getDepartmentListVo,HttpServletRequest request){

        Result<List<DepartmentListVo>> list = departmentServiceI.selectDepartmentList(getDepartmentListVo);
        return list;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "增加部门")
    public Result create(@RequestBody AddOrUpdateDepartmentVo addOrUpdateDepartmentVo,HttpServletRequest request){

        Result list = departmentServiceI.create(addOrUpdateDepartmentVo);
        return list;
    }


    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取部门详情")
    public Result selectDeptById(@ModelAttribute GetDepartmentInfoVo getDepartmentInfoVo,HttpServletRequest request){
        Result list = departmentServiceI.selectDeptById(getDepartmentInfoVo);
        return list;
    }


}






































