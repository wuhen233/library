package edu.library.service.impl;

import edu.library.mapper.BookMapper;
import edu.library.mapper.BorrowInfoMapper;
import edu.library.mapper.ReaderMapper;
import edu.library.mapper.ReturnInfoMapper;
import edu.library.exception.CustomizeException;
import edu.library.entity.Book;
import edu.library.entity.BorrowInfo;
import edu.library.entity.Reader;
import edu.library.entity.ReturnInfo;
import edu.library.service.ReturnService;
import edu.library.util.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class ReturnServiceImpl implements ReturnService {

    //设置超期每天的费用（单位元）
    private final double PER_DAY_FINE = 0.1;
    @Resource
    private ReturnInfoMapper returnInfoMapper;
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BorrowInfoMapper borrowInfoMapper;
    @Resource
    private ReaderMapper readerMapper;


    /**
     * 还书业务
     * @param bookId
     * @return 返回被删除的借阅记录
     */
    @Override
    public BorrowInfo returnBook(Integer bookId) {
        BorrowInfo borrowInfo = borrowInfoMapper.selectByBookId(bookId);
        //查询借阅记录
        if (borrowInfo == null) {
            throw new CustomizeException(ResultCode.RECORD_NOT_FOUND, "该书籍没有外借记录,不能归还");
        }
        //删除借阅记录
        borrowInfoMapper.deleteByBookId(bookId);
        //更新书籍状态为 “在馆（false）”
        Book book = borrowInfo.getBookInfo();
        book.setStatus(false);
        bookMapper.updateBookById(book);

        Date borrowTime = borrowInfo.getBorrowTime();
        Date expiredTime = borrowInfo.getExpireTime();
        Date returnTime = new Date();
        //如果超期
        if (returnTime.after(expiredTime)) {
            //计算时间差(毫秒)
            long milliSeconds = returnTime.getTime() - expiredTime.getTime();
            //计算天数差
            int days= (int) (milliSeconds/(1000*60*60*24));
            //计算超期罚款
            double fine = days * PER_DAY_FINE;
            //更新数据表
            Reader reader = readerMapper.selectReaderById(borrowInfo.getReaderId());
            reader.setFine(reader.getFine().add(BigDecimal.valueOf(fine)));
            readerMapper.updateReaderById(reader);
        }
        //添加记录到归还表
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setBookId(borrowInfo.getBookId());
        returnInfo.setReaderId(borrowInfo.getReaderId());
        returnInfo.setBorrowTime(borrowInfo.getBorrowTime());
        returnInfo.setReturnTime(returnTime);
        returnInfoMapper.insertReturnRecord(returnInfo);
        return borrowInfo;
    }

    @Override
    public List<ReturnInfo> getReturnRecords(Long readerId, Integer bookId) {
        return returnInfoMapper.selectReturnRecords(readerId, bookId);
    }
}
