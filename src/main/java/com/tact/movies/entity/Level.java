package com.tact.movies.entity;


public class Level {

  private String id;
  private long isUse;
  private String name;

  public Level(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Level(String id, long isUse, String name) {
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

  @Override
  public String toString() {
    return "Level{" +
            "id='" + id + '\'' +
            ", isUse=" + isUse +
            ", name='" + name + '\'' +
            '}';
  }
}
