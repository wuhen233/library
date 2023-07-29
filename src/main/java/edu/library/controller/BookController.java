package edu.library.controller;

import edu.library.entity.Type;
import edu.library.param.BookParam;
import edu.library.entity.Book;
import edu.library.service.BookService;
import edu.library.service.TypeService;
import edu.library.util.ResultCode;
import edu.library.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private TypeService typeService;

    /**
     * 分页获取书籍列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/list")
    public ResultVO getBooks(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        BookParam param = new BookParam();
        param.setPage(page);
        param.setLimit(limit);
        List<Book> books =bookService.getBooksByBookParam(param);
        int count = bookService.getCount();
//        List<Type> types=typeService.gettypes();
        return new ResultVO(ResultCode.SUCCESS, count, books);
    }

    /**
     * 根据ID查询书籍
     * @param bid
     * @return
     */
    @GetMapping("/list/{bid}")
    public ResultVO getBook(@PathVariable Integer bid) {
        Book book = bookService.findBookById(bid);
        return new ResultVO(ResultCode.SUCCESS, book);
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @PostMapping("/list")
    public ResultVO addBook(@RequestBody @Valid Book book) {

        bookService.addBook(book);
        return new ResultVO(ResultCode.SUCCESS, null);
    }

    /**
     * 根据ID更新书籍
     * @param bid
     * @param book
     * @return
     */
    @PutMapping("/list/{bid}")
    public ResultVO updateBook(@PathVariable Integer bid, @RequestBody @Valid Book book) {
        book.setBookId(bid);
//        System.out.println(book);
        bookService.updateBook(book);
        return new ResultVO(ResultCode.SUCCESS, null);
    }

    /**
     * 根据id删除书籍
     * @param bid
     * @return
     */
    @DeleteMapping("/list/{bid}")
    public ResultVO deleteBook(@PathVariable Integer bid) {
        bookService.deleteBookById(bid);
        return new ResultVO(ResultCode.SUCCESS, null);
    }

    /**
     * 多条件查询书籍
     * @param param
     * @return
     */
    @GetMapping("/search")
    public ResultVO searchBooks(BookParam param) {
        param.setPage(null);
        param.setLimit(null);
        if(param.getBookName().isEmpty()){
            param.setBookName(null);
        }
        if(param.getIsbn().isEmpty()){
            param.setIsbn(null);
        }
        List<Book> books =bookService.getBooksByBookParam(param);
        return new ResultVO(ResultCode.SUCCESS, books);
    }

}
