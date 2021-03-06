package com.tact.movies.entity;


public class Type {

  private String id;
  private long isUse;
  private String name;
  private String subclassId;

  public Type(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Type(String id, long isUse, String name, String subclassId) {
    this.id = id;
    this.isUse = isUse;
    this.name = name;
    this.subclassId = subclassId;
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


  public String getSubclassId() {
    return subclassId;
  }

  public void setSubclassId(String subclassId) {
    this.subclassId = subclassId;
  }

  @Override
  public String toString() {
    return "Type{" +
            "id='" + id + '\'' +
            ", isUse=" + isUse +
            ", name='" + name + '\'' +
            ", subclassId='" + subclassId + '\'' +
            '}';
  }
}
