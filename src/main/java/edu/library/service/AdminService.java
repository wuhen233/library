package edu.library.service;

import edu.library.entity.Admin;

import javax.servlet.http.HttpSession;


public interface AdminService {

    void login(HttpSession session,String name,String password);

    Admin findAdminByName(String adminName);

    int addAdmin(Admin record);

    int updateAdmin(Admin record);

    int deleteAdminById(Integer adminId);
}
