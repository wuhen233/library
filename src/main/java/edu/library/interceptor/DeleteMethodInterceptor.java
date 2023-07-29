package edu.library.interceptor;

import edu.library.exception.CustomizeException;
import edu.library.entity.Admin;
import edu.library.util.ResultCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DeleteMethodInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        HandlerMethod method= (HandlerMethod) handler;
        if (!method.hasMethodAnnotation(DeleteMapping.class)) {
            return true;
        }
        Admin admin= (Admin) session.getAttribute("admin");
//        if (!"502".equals(admin.getAdminName())) {
//            throw new CustomizeException(ResultCode.ACCESS_DENIED);
//        }
        return true;
    }
}
