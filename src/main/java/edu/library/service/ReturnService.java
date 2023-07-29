package edu.library.service;

import edu.library.entity.BorrowInfo;
import edu.library.entity.ReturnInfo;

import java.util.List;


public interface ReturnService {
    BorrowInfo returnBook(Integer bookId);

    List<ReturnInfo> getReturnRecords(Long readerId, Integer bookId);
}
