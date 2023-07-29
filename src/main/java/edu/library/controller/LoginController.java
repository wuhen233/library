package edu.library.controller;

import edu.library.entity.Admin;
import edu.library.service.AdminService;
import edu.library.util.ResultCode;
import edu.library.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录处理
     * @param session
     * @param admin
     * @return
     */
    @PostMapping("/login.do")
    @ResponseBody
    public ResultVO loginHandler(HttpSession session, @Valid Admin admin) {
        adminService.login(session,admin.getAdminName(),admin.getPassword());
        return new ResultVO(ResultCode.SUCCESS,"/main");
    }

    /**
     * 退出处理
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
