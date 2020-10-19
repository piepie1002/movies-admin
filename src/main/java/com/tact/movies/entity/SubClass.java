package com.tact.movies.entity;

import java.util.List;

/**
 * 二级子类目录
 */
public class SubClass {
    private String id;//主键id
    private String name;//名称
    private int isUse;//是否在使用

    private CateLog cataLog;
    private List<Type> types;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CateLog getCataLog() {
        return cataLog;
    }

    public void setCataLog(CateLog cataLog) {
        this.cataLog = cataLog;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isUse=" + isUse +
                ", cataLog=" + cataLog +
                ", types=" + types +
                '}';
    }
}
