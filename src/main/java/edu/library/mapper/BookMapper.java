package edu.library.mapper;

import edu.library.param.BookParam;
import edu.library.entity.Book;

import java.util.List;

public interface BookMapper {
    int deleteBookById(Integer bookId);

    int insert(Book record);

    Book selectBookById(Integer bookId);

    int updateBookById(Book record);

    List<Book> selectBooksByBookParam(BookParam param);

    int selectCount();
}