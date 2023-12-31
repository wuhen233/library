package edu.library.service.impl;

import edu.library.mapper.ReaderMapper;
import edu.library.exception.CustomizeException;
import edu.library.param.ReaderParam;
import edu.library.entity.Reader;
import edu.library.service.ReaderService;
import edu.library.util.ResultCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ReaderServiceImpl implements ReaderService {
    @Resource
    private ReaderMapper readerMapper;

    /**
     * 多条件查询读者
     * @param param
     * @return
     */
    @Override
    public List<Reader> getReadersByReaderParam(ReaderParam param) {
        List<Reader> readers=readerMapper.selectReadersByReaderParam(param);
        return readers;
    }

    //获得总数
    @Override
    public int getCount() {
        return readerMapper.selectCount();
    }

    @Override
    public int addReader(Reader record) {
        return readerMapper.insert(record);
    }

    @Override
    public int updateReader(Reader record) {
        return readerMapper.updateReaderById(record);
    }

    @Override
    public int deleteReaderById(Long readerId) {
        return readerMapper.deleteReaderById(readerId);
    }

    /**
     * 根据读者ID查询读者
     * @param readerId
     * @return
     */
    @Override
    public Reader findReaderById(Long readerId) {
        Reader reader = readerMapper.selectReaderById(readerId);
        if (reader == null) {
            //查询不到数据
            throw new CustomizeException(ResultCode.RECORD_NOT_FOUND,"查询不到该读者");
        }
        return reader;
    }
}
