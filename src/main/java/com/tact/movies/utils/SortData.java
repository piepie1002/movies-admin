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
    private List<Subclass>subClasses;
    private List<Res>ress;
    private List<Decade> decades;
    private List<Film> filmList;

    public SortData() {
    }

    public SortData(List<CateLog> cateLogs, List<Film> films, List<Loc> locs, List<Subclass> subClasses, List<Res> ress, List<Decade> decades,List<Film> filmList) {
        this.cateLogs = cateLogs;
        this.films = films;
        this.locs = locs;
        this.subClasses = subClasses;
        this.ress = ress;
        this.decades = decades;
        this.filmList = filmList;
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

    public List<Subclass> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<Subclass> subClasses) {
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

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
