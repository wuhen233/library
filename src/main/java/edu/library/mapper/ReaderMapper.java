package edu.library.mapper;

import edu.library.param.ReaderParam;
import edu.library.entity.Reader;

import java.util.List;

public interface ReaderMapper {
    int deleteReaderById(Long readerId);

    int insert(Reader record);

    Reader selectReaderById(Long readerId);

    int updateReaderById(Reader record);

    List<Reader> selectReadersByReaderParam(ReaderParam param);

    int selectCount();
}