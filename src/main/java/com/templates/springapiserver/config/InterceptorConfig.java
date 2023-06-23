package com.templates.springapiserver.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        registry.addInterceptor(
                new HandlerInterceptor() {
                    @Override
                    public boolean preHandle(
                            HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler)
                            throws Exception {
                        log.info("######## Interceptor.preHandle #########");
                        log.info("METHOD: " + request.getMethod());
                        log.info("URL: " + request.getRequestURL());
                        log.info("######## //Interceptor.preHandle #########");
                        HandlerInterceptor.super.preHandle(request, response, handler);
                        return true;
                    }

                    @Override
                    public void postHandle(
                            HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler,
                            ModelAndView modelAndView)
                            throws Exception {
                        log.info("######## Interceptor.postHandle #########");
                        log.info("Status : " + response.getStatus());
                        log.info("ContentType : " + response.getContentType());
                        log.info("######## //Interceptor.postHandle #########");
                        HandlerInterceptor.super.postHandle(
                                request, response, handler, modelAndView);
                    }
                });
    }
}
