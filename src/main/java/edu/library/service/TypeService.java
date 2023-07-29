package edu.library.service;


import edu.library.entity.Admin;
import edu.library.entity.Book;
import edu.library.entity.Type;

import java.util.List;


public interface TypeService {
//    List<Type selectByName(String typeName);

    int addType(Type record);

    int updateType(Type record);

    int deleteById(Integer typeId);
    public List<Type> gettypes();
}
