package com.quick4j.service;

import com.quick4j.dao.DepartmentMapper;
import com.quick4j.vo.dept.*;
import com.root.Base.BaseApiServiceImpl;
import com.root.Bean.Result;
import com.root.constant.ApiResultEnum;
import common.util.DateUtils;
import common.util.TreeUtils;
import common.validator.ValidationUtils;
import common.validator.bean.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service("deptService")
public class DeptServiceImpl extends BaseApiServiceImpl implements DeptServiceI {
    private final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public Result<List<DepartmentListVo>> selectDepartmentList(GetDepartmentListVo getDepartmentListVo) {

            int total = 0;
            List<DepartmentListVo> list = new ArrayList<DepartmentListVo>();

        try {

            if(getDepartmentListVo!=null&&getDepartmentListVo.getEntSerno().equals("1")){

                DepartmentListVo departmentListVo = new DepartmentListVo();
                departmentListVo.setDeptName("测试案例");
                list.add(departmentListVo);
                total= 1;
            }else{
                for(int i=0 ;i<10;i++){
                    DepartmentListVo departmentListVo = new DepartmentListVo();
                    departmentListVo.setDeptName("测试案例"+i);
                    list.add(departmentListVo);

                }
                total= 10;
            }
            //获取到需要返回的列表信息
//            list = departmentMapper.selectDepartmentList(getDepartmentListVo);
            //总条数（分页时用）
//            total = departmentMapper.selectCountList(getDepartmentListVo);
        } catch (Exception e) {
            logger.error("unknown error", e);
            return new Result<>(ApiResultEnum.ERR);
        }
        return new Result<>(ApiResultEnum.SUCCESS, list, total);
    }

    @Override
    public Result create(AddOrUpdateDepartmentVo addOrUpdateDepartmentVo){
        try {


            //如果插入成功返回成功
//            if (departmentMapper.insert(addOrUpdateDepartmentVo) > 0)
            if (1==1)
                return new Result(ApiResultEnum.SUCCESS);
        } catch (Exception e) {
            logger.error("unknown err");
            return new Result(ApiResultEnum.ERR);
        }
        return new Result(ApiResultEnum.FAIL);
    }


    @Override
    public Result selectDeptById(GetDepartmentInfoVo getDepartmentInfoVo) {
        DepartmentInfoVo departmentInfoVo;
        try {

            departmentInfoVo= new DepartmentInfoVo();
            departmentInfoVo.setDeptName("测试详细");

        } catch (Exception e) {
            logger.error("unknown err");
            return new Result(ApiResultEnum.ERR);
        }
        return new Result<>(ApiResultEnum.SUCCESS, departmentInfoVo);
    }

}
