package com.templates.springapiserverasync.config;

import static com.templates.springapiserverasync.utility.HttpRequestUtility.getClientIp;

import com.templates.springapiserverasync.sample.dto.ClientInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ArgumentResolverConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        /*
        ## 파라미터를 가공해서 다시 넣어줌.
        예) 파라미터 중에 ClientInfo 가 존재하는 경우 resolveArgument 에서 정의한 로직이 동작하여
        ClientInfo 에 clientIP: 100.100.100.100, clientPort: 80 으로 주입시킴
         */
        argumentResolvers.add(
                new HandlerMethodArgumentResolver() {
                    /*
                    Return 값이 true 인 경우만 resolveArgument 로직을 탄다.
                     */
                    @Override
                    public boolean supportsParameter(MethodParameter parameter) {
                        return parameter.getParameterType() == ClientInfoDTO.class;
                    }

                    @Override
                    public Object resolveArgument(
                            MethodParameter parameter,
                            ModelAndViewContainer mavContainer,
                            NativeWebRequest webRequest,
                            WebDataBinderFactory binderFactory) {
                        return ClientInfoDTO.builder()
                                .clientIP(
                                        getClientIp(
                                                (HttpServletRequest) webRequest.getNativeRequest()))
                                .build();
                    }
                });
    }
}
