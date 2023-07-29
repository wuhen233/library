package edu.library.config;

import edu.library.interceptor.DeleteMethodInterceptor;
import edu.library.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(new String[]{"/login","/logout","/login.do"});

        registry.addInterceptor(new DeleteMethodInterceptor())
                .addPathPatterns("/book/**")
                .addPathPatterns("/reader/**");
    }

}
