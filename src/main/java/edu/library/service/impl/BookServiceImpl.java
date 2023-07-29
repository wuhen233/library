package edu.library.service.impl;

import edu.library.entity.Type;
import edu.library.mapper.BookMapper;
import edu.library.exception.CustomizeException;
import edu.library.param.BookParam;
import edu.library.entity.Book;
import edu.library.service.BookService;
import edu.library.service.TypeService;
import edu.library.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private TypeService typeService;
    @Override
    public int addBook(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int updateBook(Book record) {
        return bookMapper.updateBookById(record);
    }

    @Override
    public int deleteBookById(Integer bookId) {
        return bookMapper.deleteBookById(bookId);
    }

    @Override
    public List<Book> getBooksByBookParam(BookParam param) {
        List<Book> books=bookMapper.selectBooksByBookParam(param);
        List<Type> types=typeService.gettypes();
        for (Book book : books) {
            int typeid=book.getType();
            for (Type type:types){
                if(type.getTypeId()==typeid){
//                    System.out.println(type.getTypeId()==typeid);
                    book.setTypestr(type.getTypeName());
//                    System.out.println(book.getTypestr());
                }
            }
        }
        return books;
    }

    @Override
    public int getCount() {
        return bookMapper.selectCount();
    }

    @Override
    public Book findBookById(Integer bookId) {
        Book book = bookMapper.selectBookById(bookId);
        if (book == null) {
            throw new CustomizeException(ResultCode.RECORD_NOT_FOUND,"查询不到该书籍");
        }
        List<Type> types=typeService.gettypes();
        int typeid=book.getType();
        for (Type type:types){
            if(type.getTypeId()==typeid) {
//                    System.out.println(type.getTypeId()==typeid);
                book.setTypestr(type.getTypeName());
//                    System.out.println(book.getTypestr());
            }
        }
        return book;
    }
}
