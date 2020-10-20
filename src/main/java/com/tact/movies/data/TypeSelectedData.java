package com.tact.movies.data;

import com.tact.movies.entity.SubClass;
import com.tact.movies.entity.Type;

import java.util.List;

public class TypeSelectedData {
    private List<SubClass> subClass;
    private List<Type> types;

    public List<SubClass> getSubClass() {
        return subClass;
    }

    public void setSubClass(List<SubClass> subClass) {
        this.subClass = subClass;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
