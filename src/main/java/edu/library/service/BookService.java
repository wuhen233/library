package edu.library.service;

import edu.library.param.BookParam;
import edu.library.entity.Book;

import java.util.List;


public interface BookService {
    int addBook(Book record);

    int updateBook(Book record);

    int deleteBookById(Integer bookId);

    Book findBookById(Integer bookId);

    List<Book> getBooksByBookParam(BookParam param);

    int getCount();
}
