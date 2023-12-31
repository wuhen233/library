package edu.library.service.impl;

import edu.library.mapper.AdminMapper;
import edu.library.exception.CustomizeException;
import edu.library.entity.Admin;
import edu.library.service.AdminService;
import edu.library.util.ResultCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 用户登录业务
     * @param session
     * @return
     */
    @Override
    public void login(HttpSession session,String name,String password) {
        Admin admin = findAdminByName(name);
        if(admin==null){  //用户不存在
            throw new CustomizeException(ResultCode.USER_NOT_FOUND);
        }

        if(!admin.getPassword().equals(password)){  //密码错误
            throw new CustomizeException(ResultCode.PASSWORD_ERROR);
        }
        session.setAttribute("admin",admin);
    }

    @Override
    public Admin findAdminByName(String adminName) {
        return adminMapper.selectByName(adminName);
    }

    @Override
    public int addAdmin(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int updateAdmin(Admin record) {
        return adminMapper.updateById(record);
    }

    @Override
    public int deleteAdminById(Integer adminId) {
        return adminMapper.deleteById(adminId);
    }
}
