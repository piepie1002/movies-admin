package com.tact.movies.service.impl;

import com.tact.movies.dao.CateLogDao;
import com.tact.movies.dao.DecadeDao;
import com.tact.movies.dao.LocDao;
import com.tact.movies.dao.SubclassDao;
import com.tact.movies.dao.impl.CateLogDaoImpl;
import com.tact.movies.dao.impl.DecadeDaoImpl;
import com.tact.movies.dao.impl.LocDaoImpl;
import com.tact.movies.dao.impl.SubclassDaoImpl;
import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.Decade;
import com.tact.movies.entity.Loc;
import com.tact.movies.entity.Subclass;
import com.tact.movies.service.SortService;
import com.tact.movies.utils.SortData;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class SortServiceImpl implements SortService {
    CateLogDao cateLogDao = new CateLogDaoImpl();
    SubclassDao subclassDao = new SubclassDaoImpl();
    LocDao locDao = new LocDaoImpl();
    DecadeDao decadeDao = new DecadeDaoImpl();
    @Override
    public SortData getSortDate() {
        List<CateLog> cateLogs = cateLogDao.selectCateLogList();
        List<Subclass> subclassList = subclassDao.selectSubClassList();
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
