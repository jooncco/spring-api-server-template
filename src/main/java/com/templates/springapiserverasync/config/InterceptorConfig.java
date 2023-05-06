package com.templates.springapiserverasync.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
        ## request 검증하는 용도로 쓰거나, 공통 로그 출력을 위해 사용될 수 있음
         preHandle return 값을 false 로 하면 controller 에 전달되지 않음.
         response.getWriter().write("ERROR"); 처럼 response 도 조작할 수 있음
         postHandle 로 후처리를 할 수 도 있음. 하지만 response 조작이 필요한 경우는 controller 에서 null 로 리턴 해야함
         */
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                Object handler) throws Exception {
                log.info("######## Interceptor.preHandle #########");
                log.info("METHOD: " + request.getMethod());
                log.info("URL: " + request.getRequestURL());
                log.info("######## //Interceptor.preHandle #########");
                HandlerInterceptor.super.preHandle(request, response, handler);
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response,
                Object handler, ModelAndView modelAndView) throws Exception {
                log.info("######## Interceptor.postHandle #########");
                log.info("Status : " + response.getStatus());
                log.info("ContentType : " + response.getContentType());
                log.info("######## //Interceptor.postHandle #########");
                HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
            }
        });
    }
}