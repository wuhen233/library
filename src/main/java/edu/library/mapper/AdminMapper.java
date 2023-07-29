package edu.library.mapper;

import edu.library.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int deleteById(Integer adminId);

    int insert(Admin record);

    Admin selectByName(@Param("adminName") String adminName);

    int updateById(Admin record);

}