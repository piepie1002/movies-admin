package com.tact.movies.service.impl;

import com.tact.movies.dao.*;
import com.tact.movies.dao.impl.*;
import com.tact.movies.entity.*;
import com.tact.movies.service.SortService;
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
    public SortData getSortDate() {
        List<CateLog> cateLogs = cateLogDao.selectCateLogList();
        List<Subclass> subclassList = subClassDao.selectSubClassList();
        List<Loc> locs = locDao.selectLocList();
        List<Decade> decades = decadeDao.selectDecadeList();
        SortData sortDate = new SortData();
        sortDate.setCateLogs(cateLogs);
        sortDate.setSubClasses(subclassList);
        sortDate.setLocs(locs);
        sortDate.setDecades(decades);
        return sortDate;
    }
}
