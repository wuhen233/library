package edu.library.service;

import edu.library.param.ReaderParam;
import edu.library.entity.Reader;

import java.util.List;


public interface ReaderService {

    List<Reader> getReadersByReaderParam(ReaderParam param);

    int addReader(Reader record);

    int updateReader(Reader record);

    int deleteReaderById(Long readerId);

    Reader findReaderById(Long readerId);

    int getCount();
}
