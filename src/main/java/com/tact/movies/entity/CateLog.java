package com.tact.movies.entity;

import java.util.List;

/**
 * 一级分类目录
 */
public class CateLog {
    //主键id
    private String id;
    //名称
    private String name;
    //是否在使用 1：使用 2：未使用
    private int isUse;
    private List<SubClass> subClassList;

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

    public List<SubClass> getSubClassList() {
        return subClassList;
    }

    public void setSubClassList(List<SubClass> subClassList) {
        this.subClassList = subClassList;
    }


    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "CataLog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isUse=" + isUse +
                ", subClassList=" + subClassList +
                '}';
    }
}
