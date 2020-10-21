package com.tact.movies.service.impl;

import com.tact.movies.dao.*;
import com.tact.movies.dao.impl.*;
import com.tact.movies.entity.*;
import com.tact.movies.service.SortService;
import com.tact.movies.utils.PageBean;
import com.tact.movies.utils.SortData;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class SortServiceImpl implements SortService {
    CateLogDao cateLogDao = new CateLogDaoImpl();
    SubClassDao subClassDao = new SubClassDaoImpl();
    LocDao locDao = new LocDaoImpl();
    DecadeDao decadeDao = new DecadeDaoImpl();
    FilmDao filmDao = new FilmDaoImpl();
    @Override
    public SortData getSortDate(PageBean pageBean) {
        List<CateLog> cateLogs = cateLogDao.selectCateLogList();
        List<SubClass> subclassList = subClassDao.selectSubClassList();
        List<Loc> locs = locDao.selectLocList();
        List<Decade> decades = decadeDao.selectDecadeList();
        SortData sortDate = new SortData();
        sortDate.setPageBean(pageBean);
        sortDate.setCateLogs(cateLogs);
        sortDate.setSubClasses(subclassList);
        sortDate.setLocs(locs);
        sortDate.setDecades(decades);
        return sortDate;
    }

    @Override
    public PageBean getPageBean(String curPage) {
        PageBean<Film> pageBean = new PageBean<>();
        //1.设置当前页
        pageBean.setCurPage(Integer.parseInt(curPage));
        //2.每页展示的数据
        pageBean.setPageSize(18);
        //3.设置总条数
        pageBean.setCount(filmDao.getFilmCount());
        //4.设置页数 -- 在page对象中直接通过算法生成
        //5.设置每页展示的数据集合
        pageBean.setDataList(filmDao.selectCateLogName("电影",
                (Integer.parseInt(curPage)-1)*pageBean.getPageSize(),pageBean.getPageSize()));
        return pageBean;
    }
}
