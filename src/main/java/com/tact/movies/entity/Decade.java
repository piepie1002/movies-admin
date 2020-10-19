package com.tact.movies.entity;

/**
 * 年代
 */
public class Decade {
    private String id;//主键id
    private String name;//名称
    private int isUse;//是否在使用

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

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "Decade{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isUse=" + isUse +
                '}';
    }
}
