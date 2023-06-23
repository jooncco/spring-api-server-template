package com.templates.springapiserver.config;

import com.templates.springapiserver.filter.BaseFilter;
import java.util.Collections;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<BaseFilter> baseFilterRegister() {
        FilterRegistrationBean<BaseFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new BaseFilter());
        registrationBean.setUrlPatterns(Collections.singleton("/api/**"));
        return registrationBean;
    }
}
