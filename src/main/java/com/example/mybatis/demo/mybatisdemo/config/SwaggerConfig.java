package com.example.mybatis.demo.mybatisdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${bearer.authentication.header.name:API_TICKET}")
    private String bearerName = "API_TICKET";

    @Value("${bearer.authentication.header.key:bearer}")
    private String bearerKey = "bearer";

    @Bean
    public Docket swaggerApi() {
        // /api/v1/swagger URL이 존재하는 Controller 대상
        return this.api("Swagger 1", PathSelectors.ant("/api/v1/swagger/**"));
    }

    @Bean
    public Docket RuntimeApi() {
        // /api/v1/runtime URL이 존재하는 Controller 대상
        return this.api("Runtime Controller", PathSelectors.ant("/api/v1/runtime/**"));
    }

    @Bean
    public Docket allApi() {
        // /api URL이 존재하는 Controller 대상
        return this.api("전체", PathSelectors.ant("/api/**"));
    }

    public Docket api(String groupName, Predicate<String> path) {
        return new Docket(DocumentationType.OAS_30)
                .groupName(groupName)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.mybatis.demo.mybatisdemo"))
                .paths(path)
                .build()
                .apiInfo(metaData())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()));

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("GreenByMe REST API")
                .description("Green by me, Green by earth(us)")
                .version("0.4.0")
                .termsOfServiceUrl("Terms of service")
                .contact(new Contact("Tae Jeong, Da hun", "https://github.com/GreenByMe/GreenByMe_Server", "xowjd41@naver.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey(bearerName, bearerKey, "header");
    }

    @Deprecated
    private SecurityContext securityContext() {
        return springfox
                .documentation
                .spi.service
                .contexts
                .SecurityContext
                .builder()
                .securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope(bearerName, bearerKey);
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference(bearerName, authorizationScopes));
    }
}