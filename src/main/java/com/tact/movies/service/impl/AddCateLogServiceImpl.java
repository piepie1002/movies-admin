package com.tact.movies.service.impl;

import com.tact.movies.dao.*;
import com.tact.movies.dao.impl.*;
import com.tact.movies.data.TypeSelectedData;
import com.tact.movies.entity.*;
import com.tact.movies.service.AddCateLogService;

import java.util.List;

public class AddCateLogServiceImpl implements AddCateLogService {
    CateLogDao cateLogDao = new CateLogDaoImpl();
    SubClassDao subClassDao = new SubClassDaoImpl();
    TypeDao typeDao = new TypeDaoImpl();
    LocDao locDao = new LocDaoImpl();
    LevelDao levelDao = new LevelDaoImpl();
    DecadeDao decadeDao = new DecadeDaoImpl();

    //获取一层目录数据集
    @Override
    public TypeSelectedData getCateLogData() {
        List<CateLog> cateLogs = cateLogDao.selectCateLogList();
        TypeSelectedData data = new TypeSelectedData();
        data.setCateLogs(cateLogs);
        return data;
    }

    //获取二层目录数据集
    @Override
    public TypeSelectedData getSubClassData(String cateLogId) {
        List<SubClass> subClasses = subClassDao.selectSubClassList(cateLogId);
        TypeSelectedData data = new TypeSelectedData();
        data.setSubClasses(subClasses);
        return null;
    }

    //获取三层目录数据集
    @Override
    public TypeSelectedData getTypeData(String subClassId) {
        List<Type> types = typeDao.selectTypeList(subClassId);
        TypeSelectedData data = new TypeSelectedData();
        data.setTypes(types);
        return data;
    }

    //添加一级目录
    @Override
    public boolean insertCateLog(CateLog cateLog) {
        //判重
        CateLog ca = cateLogDao.selectCateLog(cateLog.getName());
        boolean flag = checkRepeat(ca);    // 不存在 返回true
        if (flag){
            //添加
            int count = cateLogDao.insertCateLog(cateLog);
            return checkInsert(count);
        }
        return false;
    }

    //添加二级目录
    @Override
    public boolean insertSubClass(SubClass subClass) {
        //判重
        SubClass sub = subClassDao.selectSubClass(subClass.getName());
        boolean flag = checkRepeat(sub);    // 不存在 返回true
        if (flag){
            //添加
            int count = subClassDao.insertSubClass(subClass);
            return checkInsert(count);
        }
        return false;
    }

    //添加三级目录
    @Override
    public boolean insertType(Type type) {
        //判重
        Type ty = typeDao.selectType(type.getName());
        boolean flag = checkRepeat(ty);     // 不存在 返回true
        if (flag){
            //添加
            int count = typeDao.insertType(type);
            return checkInsert(count);
        }
        return false;
    }

    //添加地区
    @Override
    public boolean insertLoc(Loc loc) {
        //判重
        Loc lo = locDao.selectLoc(loc.getName());
        boolean flag = checkRepeat(lo);     // 不存在 返回true
        if (flag){
            //添加
            int count = locDao.insertLoc(loc);
            return checkInsert(count);
        }
        return false;
    }

    //添加级别
    @Override
    public boolean insertLevel(Level level) {
        //判重
        Level le = levelDao.selectLevel(level.getName());
        boolean flag = checkRepeat(le);     // 不存在 返回true
        if (flag){
            //添加
            int count = levelDao.insertLevel(level);
            return checkInsert(count);
        }
        return false;
    }

    //添加年代
    @Override
    public boolean insertDecade(Decade decade) {
        //判重
        Decade de = decadeDao.selectDecade(decade.getName());
        boolean flag = checkRepeat(de);     // 不存在 返回true
        if (flag){
            //添加
            int count = decadeDao.insertDecade(decade);
            return checkInsert(count);
        }
        return false;
    }

    //判断是否已存在
    public boolean checkRepeat(Object obj){
        if (obj == null){
            return true;
        }
        return false;
    }

    //判断是否添加成功
    public boolean checkInsert(int count){
        if(count > 0){
            return true;
        }
        return false;
    }

}
