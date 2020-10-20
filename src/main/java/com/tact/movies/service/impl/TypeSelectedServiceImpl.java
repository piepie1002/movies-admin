package com.tact.movies.service.impl;

import com.tact.movies.dao.AddFilmDao;
import com.tact.movies.dao.impl.AddFilmDaoImpl;
import com.tact.movies.data.TypeSelectedData;
import com.tact.movies.entity.SubClass;
import com.tact.movies.entity.Type;
import com.tact.movies.service.TypeSelectedService;

import java.util.List;

public class TypeSelectedServiceImpl implements TypeSelectedService {
    AddFilmDao afd = new AddFilmDaoImpl();

    @Override
    public TypeSelectedData getSubClassData(String id) {
        TypeSelectedData data = new TypeSelectedData();
        List<SubClass> subClass = afd.selectSubClasses(id);
        data.setSubClass(subClass);
        return data;
    }

    @Override
    public TypeSelectedData getTypeData(String id) {
        TypeSelectedData data = new TypeSelectedData();
        List<Type> types = afd.selectTypes(id);
        data.setTypes(types);
        return data;
    }
}
