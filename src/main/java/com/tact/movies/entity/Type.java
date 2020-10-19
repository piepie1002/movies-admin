package com.tact.movies.entity;


/**
 * 类型
 */
public class Type {
    private String id;//主键id
    private String name;//名称
    private int isUse;//是否在使用

    private SubClass subClass;

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

    public SubClass getSubClass() {
        return subClass;
    }

    public void setSubClass(SubClass subClass) {
        this.subClass = subClass;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isUse=" + isUse +
                ", subClass=" + subClass +
                '}';
    }
}
