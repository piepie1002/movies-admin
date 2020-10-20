package com.tact.movies.entity;


<<<<<<< HEAD:src/main/java/com/tact/movies/entity/Decade.java
public class Decade {
=======
public class CateLog {
>>>>>>> cwg:src/main/java/com/tact/movies/entity/CateLog.java

  private String id;
  private long isUse;
  private String name;
  private long sort;

  public Decade(String id, long isUse, String name) {
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

}
