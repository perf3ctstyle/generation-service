package com.github.click.nd.rest.generation.service.config;

import com.github.click.nd.rest.generation.service.exception.handlers.FilterExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletException;

@EnableSwagger2
@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.straight.flower.orangery"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public FilterExceptionHandler exceptionHandlerFilter() throws ServletException {
        FilterExceptionHandler exceptionHandlerFilter = new FilterExceptionHandler();
        exceptionHandlerFilter.afterPropertiesSet();
        return exceptionHandlerFilter;
    }
}
