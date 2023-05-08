package com.templates.springapiserverasync.config;

import com.templates.springapiserverasync.filter.BaseFilter;
import java.util.Collections;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    /*
    필터를 등록할 수 있다. 다수 등록이 가능하며, 상세 필터링 내용은 등록한 필터에서 확인 가능하다.
     */
    @Bean
    public FilterRegistrationBean firstFilterRegister() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new BaseFilter());
        registrationBean.setUrlPatterns(Collections.singleton("/*"));
        return registrationBean;
    }
}