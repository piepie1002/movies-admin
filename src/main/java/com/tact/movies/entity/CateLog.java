package com.tact.movies.entity;

public class CateLog {
    private String id;
    private long isUse;
    private String name;
    private long sort;
    private long isVip;
  
    public CateLog(String id ,String name) {
        this.id = id;
        this.name = name;
    }

    public CateLog(String id, long isUse, String name) {
        this.id = id;
        this.isUse = isUse;
        this.name = name;
    }

    public String getId() {
      return id;
    }
  
    public void setId(String id) {
      this.id = id;
    }
  
  
    public long getIsUse() {
      return isUse;
    }
  
    public void setIsUse(long isUse) {
      this.isUse = isUse;
    }
  
  
    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
  
    public long getSort() {
      return sort;
    }
  
    public void setSort(long sort) {
      this.sort = sort;
    }
  
  
    public long getIsVip() {
      return isVip;
    }
  
    public void setIsVip(long isVip) {
        this.isVip = isVip;
    }

    public CateLog(String id, long isUse, String name, long sort, long isVip) {
        this.id = id;
        this.isUse = isUse;
        this.name = name;
        this.sort = sort;
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        return "CateLog{" +
                "id='" + id + '\'' +
                ", isUse=" + isUse +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", isVip=" + isVip +
                '}';
    }
}
