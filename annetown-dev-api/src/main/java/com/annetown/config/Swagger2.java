package com.annetown.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 implements WebMvcConfigurer {

//    http://localhost:8080/swagger-ui.html     原路径
//    http://localhost:8080/doc.html     原路径

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  // 指定api类型为swagger2
                .apiInfo(apiInfo())                 // 用于定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.annetown.controller"))   // 指定controller包
                .paths(PathSelectors.any())         // 所有controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台接口api")        // 文档页标题
                .contact(new Contact("imooc",
                        "https://www.imooc.com",
                        "abc@imooc.com"))        // 联系人信息
                .description("专为天天吃货提供的api文档")  // 详细信息
                .version("1.0.1")   // 文档版本号
                .termsOfServiceUrl("https://www.imooc.com") // 网站地址
                .build();
    }

}
