package edu.library.mapper;

import edu.library.entity.BorrowInfo;

import java.util.List;

public interface BorrowInfoMapper {
    int deleteByReaderIdAndBookId(Long readerId,Integer bookId);

    int deleteByBookId(Integer bookId);

    BorrowInfo selectByBookId(Integer bookId);

    List<BorrowInfo> selectByReaderId(Long readerId);

    int insert(BorrowInfo record);

}