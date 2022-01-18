package com.ics.common.swagger.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 时髦汽车配置
 *
 * @author Kevin
 * @date 2022-01-17
 */
@Configuration
@EnableOpenApi
@EnableAutoConfiguration
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration
{
    /**
     * 默认的排除路径，排除Spring Boot默认的错误处理路径和端点
     */
    private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

    private static final String BASE_PATH = "/**";

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties()
    {
        return new SwaggerProperties();
    }
    @Bean
    public Docket createRestApi() {

    // 注意此处改动，需要将SWAGGER_2改成OAS_30
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger3接口文档")
                .description("接口文档")
                .contact(new Contact("碧海燕鱼", "#", "654195681@qq.com"))
                .version("0.1.0")
                .build();
    }

//    @Bean
//    public Docket api(SwaggerProperties swaggerProperties)
//    {
//        // base-path处理
//        if (swaggerProperties.getBasePath().isEmpty())
//        {
//            swaggerProperties.getBasePath().add(BASE_PATH);
//        }
//        // noinspection unchecked
//        List<Predicate<String>> basePath = new ArrayList<Predicate<String>>();
//        swaggerProperties.getBasePath().forEach(path -> basePath.add(PathSelectors.ant(path)));
//
//        // exclude-path处理
//        if (swaggerProperties.getExcludePath().isEmpty())
//        {
//            swaggerProperties.getExcludePath().addAll(DEFAULT_EXCLUDE_PATH);
//        }
//        List<Predicate<String>> excludePath = new ArrayList<>();
//        swaggerProperties.getExcludePath().forEach(path -> excludePath.add(PathSelectors.ant(path)));
//
//        //noinspection Guava
//        return new Docket(DocumentationType.SWAGGER_2)
//                .host(swaggerProperties.getHost())
//                .apiInfo(apiInfo(swaggerProperties)).select()
//                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
//                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath)))
//                .build()
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts())
//                .pathMapping("/");
//    }

    /**
     * 安全模式，这里指定token通过Authorization头请求头传递
     */
    private List<ApiKey> securitySchemes()
    {
        List<ApiKey> apiKeyList = new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    /**
     * 安全上下文
     */
    private List<SecurityContext> securityContexts()
    {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    /**
     * 默认的全局鉴权策略
     *
     * @return
     */
    private List<SecurityReference> defaultAuth()
    {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    private ApiInfo apiInfo(SwaggerProperties swaggerProperties)
    {
         return new ApiInfoBuilder()
             .title(swaggerProperties.getTitle())
             .description(swaggerProperties.getDescription())
             .license(swaggerProperties.getLicense())
             .licenseUrl(swaggerProperties.getLicenseUrl())
             .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
             .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
             .version(swaggerProperties.getVersion())
             .build();
    }
}
