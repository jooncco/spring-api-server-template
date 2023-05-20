package com.templates.springapiserver.config;

import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .consumes(
                        Set.of(
                                "application/json;charset=UTF-8",
                                "application/x-www-form-urlencoded"))
                .produces(Set.of("application/json;charset=UTF-8"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.templates.springapiserver"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo getApiInfo() {
        final String API_TITLE = "Spring API Server Async Document";
        final String API_VERSION = "0.0.1";
        final String API_DESCRIPTION = "Provides documentation and tests for server APIs.";

        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }
}
