package edu.library.mapper;


import edu.library.entity.Admin;
import edu.library.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TypeMapper  {
    int deleteById(Integer typeId);

    int insert(Type record);

    Type selectByName(@Param("typeName") String typeName);

    int updateById(Type record);

    List<Type> selectAlltypes();

}
