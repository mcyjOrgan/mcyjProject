package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.root.dto.SysLog;

import java.util.List;

public interface SysLogMapper extends GenericDao<SysLog, Long> {

    Integer insert(SysLog record);

//    SysLog selectByPrimaryKey(Long logOperId);
//
//    List<SysLog> selectList(SysLog record);
//
//    Integer selectCount(SysLog record);

    String selectMenuName(Long menuId);
}