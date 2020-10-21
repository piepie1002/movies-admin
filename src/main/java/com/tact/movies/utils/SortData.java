package com.tact.movies.utils;

import com.tact.movies.entity.*;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class SortData {
    private List<CateLog>cateLogs;
    private List<Film>films;
    private List<Loc>locs;
    private List<SubClass>subClasses;
    private List<Res>ress;
    private List<Decade> decades;
    private PageBean pageBean;
    private List<Type> type;

    public SortData() {
    }

    public SortData(List<CateLog> cateLogs, List<Film> films, List<Loc> locs, List<SubClass> subClasses, List<Res> ress, List<Decade> decades,PageBean pageBean) {
        this.cateLogs = cateLogs;
        this.films = films;
        this.locs = locs;
        this.subClasses = subClasses;
        this.ress = ress;
        this.decades = decades;
        this.pageBean = pageBean;
    }

    public List<CateLog> getCateLogs() {
        return cateLogs;
    }

    public void setCateLogs(List<CateLog> cateLogs) {
        this.cateLogs = cateLogs;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public List<Loc> getLocs() {
        return locs;
    }

    public void setLocs(List<Loc> locs) {
        this.locs = locs;
    }

    public List<SubClass> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<SubClass> subClasses) {
        this.subClasses = subClasses;
    }

    public List<Res> getRess() {
        return ress;
    }

    public void setRess(List<Res> ress) {
        this.ress = ress;
    }

    public List<Decade> getDecades() {
        return decades;
    }

    public void setDecades(List<Decade> decades) {
        this.decades = decades;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }
}
