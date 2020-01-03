package org.cmsspringfive.newscms.configurations.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String BEARER = "Bearer";
    private static final String AUTHORIZATION = "Authorization";
    private static final String HEADER = "header";
    private static final String GLOBAL = "global";
    private static final String ACCESS_EVERYTHING = "accessEverything";

    @Bean
    public Docket documentation(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.basePackage("org.cmsspringfive.newscms.domain.resources"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()));
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("News Cms")
                .description("SpringBoot project that manages news, news categories, and users roles top manage the news")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
    private SecurityContext securityContext() {
        return  SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey(BEARER, AUTHORIZATION, HEADER);
    }

    private List<SecurityReference> defaultAuth(){

        AuthorizationScope authorizationScope = new AuthorizationScope(GLOBAL, ACCESS_EVERYTHING);
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        return Collections.singletonList(new SecurityReference(BEARER, authorizationScopes));
    }
}
