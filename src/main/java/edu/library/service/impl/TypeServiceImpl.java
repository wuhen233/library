package edu.library.service.impl;


import edu.library.entity.Book;
import edu.library.entity.Type;
import edu.library.mapper.TypeMapper;
import edu.library.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;



    @Override
    public int addType(Type record) {
        return typeMapper.insert(record);
    }

    @Override
    public int updateType(Type record) {
        return typeMapper.updateById(record);
    }

    @Override
    public int deleteById(Integer typeId) {
        return typeMapper.deleteById(typeId);
    }

    @Override
    public List<Type> gettypes() {
        return typeMapper.selectAlltypes();
    }
}
