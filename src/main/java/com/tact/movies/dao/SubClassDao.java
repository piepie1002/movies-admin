package com.tact.movies.dao;


import com.tact.movies.entity.SubClass;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface SubClassDao {
     List<SubClass> selectSubClassList();

     //获取一级目录对应所有二级目录
     List<SubClass> selectSubClassList(String cateLogId);

     //根据name获取二级目录
     SubClass selectSubClass(String subClassName);

     //添加二级目录
     int insertSubClass(SubClass subClass);

}
