package com.tact.movies.entity;

/**
 * 级别
 */
public class Level {
    // 主键id
    private String id;
    // 名称
    private String name;
    // 是否在使用
    private int isUse;

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
        return "Level{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isUse=" + isUse +
                '}';
    }
}
