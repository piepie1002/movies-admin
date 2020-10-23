package com.tact.movies.entity;


public class SubClass {

  private String id;
  private long isUse;
  private String name;
  private String catalogId;


  public SubClass(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public SubClass(String id, long isUse, String name, String catalogId) {
    this.id = id;
    this.isUse = isUse;
    this.name = name;
    this.catalogId = catalogId;
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


  public String getCatalogId() {
    return catalogId;
  }

  public void setCatalogId(String catalogId) {
    this.catalogId = catalogId;
  }

  @Override
  public String toString() {
    return "SubClass{" +
            "id='" + id + '\'' +
            ", isUse=" + isUse +
            ", name='" + name + '\'' +
            ", catalogId='" + catalogId + '\'' +
            '}';
  }
}
