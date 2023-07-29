package edu.library.service;

import edu.library.entity.BorrowInfo;

import java.util.List;


public interface BorrowService {

    void borrowBook(Long readerId, Integer bookId);

    List<BorrowInfo> getBorrowRecordsByReaderId(Long readerId);
}
