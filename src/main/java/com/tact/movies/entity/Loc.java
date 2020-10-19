package com.tact.movies.entity;


public class Loc {

  private String id;
  private long isUse;
  private String name;

  public Loc(String id, long isUse, String name) {
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

}
