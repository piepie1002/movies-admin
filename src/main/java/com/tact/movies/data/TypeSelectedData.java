package com.tact.movies.data;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.SubClass;
import com.tact.movies.entity.Type;

import java.util.List;

public class TypeSelectedData {
    private List<CateLog> cateLogs;
    private List<SubClass> subClasses;
    private List<Type> types;

    public List<CateLog> getCateLogs() {
        return cateLogs;
    }

    public void setCateLogs(List<CateLog> cateLogs) {
        this.cateLogs = cateLogs;
    }

    public List<SubClass> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<SubClass> subClasses) {
        this.subClasses = subClasses;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
