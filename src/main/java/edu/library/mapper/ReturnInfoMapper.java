package edu.library.mapper;

import edu.library.entity.ReturnInfo;

import java.util.List;

public interface ReturnInfoMapper {

    int insertReturnRecord(ReturnInfo record);

    List<ReturnInfo> selectReturnRecords(Long readerId, Integer bookId);

}