package edu.library.interceptor;

import edu.library.annotation.ViewMethod;
import edu.library.exception.CustomizeException;
import edu.library.util.ResultCode;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {  //不是请求接口方法的放行
            return true;
        }
        HttpSession session=request.getSession();
        //判断用户是否已经登录
        if(session.getAttribute("admin")==null){   //用户未登录

            //判断拦截的请求方法是否存在@ViewMethod注解，存在则说明该方法是跳转页面的
            HandlerMethod method = (HandlerMethod) handler;
            if (method.hasMethodAnnotation(ViewMethod.class)) {
                response.sendRedirect("/login");  //重定向跳转到登录页面
                return false;
            }else {    //否则，抛出未登录异常，通过异常处理响应json数据
                throw new CustomizeException(ResultCode.USER_NOT_LOGGED_IN,"请重新登录！");
            }
        }
        //已登录，则放行请求
        return true;
    }
}
