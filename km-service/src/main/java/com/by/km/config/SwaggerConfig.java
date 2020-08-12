package com.by.km.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 * @author bingyi
 */
@Configuration
@EnableSwagger2 // 启用 Swagger2
public class SwaggerConfig {

    /**
     * 配置了Swagger的Docket的bean实例
     * @return
     */
    @Bean
    public Docket createRestApi(Environment environment) {

        // 设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        // 获得项目的环境
        //String[] activeProfiles = environment.getActiveProfiles();

        // 判断是否处于自己设定的环境之中
        boolean flag = environment.acceptsProfiles(profiles);

        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (declaringClass == BasicErrorController.class) { // 排除
                    return false;
                }
                if(declaringClass.isAnnotationPresent(RestController.class)) { // 被注解的类
                    return true;
                }
                if(input.isAnnotatedWith(ResponseBody.class)) { // 被注解的方法
                    return true;
                }
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("wangby")
                .apiInfo(apiInfo())
                .enable(flag)
                .useDefaultResponseMessages(false)
                .select()
                /*
                    RequestHandlerSelectors：配置要扫描接口的方式
                        basePackage：指定要扫描的包
                        any()：扫描全部
                        none()：都不扫描
                        withClassAnnotation()：扫描类上的注解，参数是一个注解的反射对象
                        withMethodAnnotation()：扫描方法上的注解
                 */
                .apis(predicate)
                .build();
    }


    /**
     * 配置了Swagger 的信息 apiInfo
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("接口文档")
                // 版本信息
                .version("1.0")
                // 作者信息
                .contact(new Contact("wangby", "无", "wbytts@163.com"))
                .build();
    }
}

