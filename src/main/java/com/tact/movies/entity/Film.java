package com.tact.movies.entity;

import java.util.List;

/**
 * 影片信息
 */
public class Film {
    //主键id
    private String id;
    //片名
    private String name;
    //海报
    private String image;
    //上影年代
    private String onDecade;
    //状态
    private String status;
    //分辨率
    private String resolution;
    //类型名称
    private String typeName;
    //类型Id
    private String typeId;
    //演员
    private String actor;
    //地区名称
    private String locName;
    //地区Id
    private String locId;
    //更新时间
    private String updateTime;
    //是否在使用
    private int isUse;
    //一级目录
    private String cateLogId;
    //一级目录名称
    private String cateLogName;
    //二级目录
    private String subClassId;
    //二级目录名称
    private String subClassName;
    //是否vip资源
    private Integer isVip;
    //剧情
    private String plot;
    //评分
    private double evaluation;
    private List<Res> resList;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOnDecade() {
        return onDecade;
    }

    public void setOnDecade(String onDecade) {
        this.onDecade = onDecade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public String getCateLogId() {
        return cateLogId;
    }

    public void setCateLogId(String cateLogId) {
        this.cateLogId = cateLogId;
    }

    public String getCateLogName() {
        return cateLogName;
    }

    public void setCateLogName(String cateLogName) {
        this.cateLogName = cateLogName;
    }

    public String getSubClassId() {
        return subClassId;
    }

    public void setSubClassId(String subClassId) {
        this.subClassId = subClassId;
    }

    public String getSubClassName() {
        return subClassName;
    }

    public void setSubClassName(String subClassName) {
        this.subClassName = subClassName;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation = evaluation;
    }

    public List<Res> getResList() {
        return resList;
    }

    public void setResList(List<Res> resList) {
        this.resList = resList;
    }
}
