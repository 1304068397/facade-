package com.example.demo.config;

/**
 * @PackageName:com.example.demo.config
 * @ClassName:SwaggerConfig
 * @Description:
 * @Author:王宗保
 * @Version V1.0.0
 * @Date:2020/12/22 21:06
 */

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
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
@EnableKnife4j
@Import({BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {
    @Value("${swagger.enable}")
    private Boolean swaggerEnale;

    public SwaggerConfig() {
    }

    @Bean
    public Docket api() {
        Docket docket = (new Docket(DocumentationType.SWAGGER_2)).enable(this.swaggerEnale).apiInfo(this.apiInfo()).groupName("seasky_v1").select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any()).build().directModelSubstitute(Timestamp.class, String.class).directModelSubstitute(Date.class, String.class).useDefaultResponseMessages(false);
        return docket;
    }

    public ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title("SEASKY-API").contact(new Contact("seasky", "", "")).description("SEASKY-API").version("1.0").termsOfServiceUrl("http://localhost").build();
    }
}
