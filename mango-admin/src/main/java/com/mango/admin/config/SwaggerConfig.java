package com.mango.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(){
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())/*配置Swagger信息*/
                    .enable(true)/*是否启用swagger*/
                    .select()/*选择哪些路径和api会生成document*/
                    .apis(RequestHandlerSelectors/*RequestHandlerSelectors配置要扫描接口的方式*/
                            /*basePackage指定要扫描的包()最常用*/
                            .basePackage("com.mango.admin.controller")
                            /*.any()是扫描全部*/)
                    .build();
    }
    //配置Swagger信息
    private ApiInfo apiInfo(){
        //作者信息org.example
        Contact contact = new Contact("ShiLiLi","https://blog.csdn.net/u010017876","fet518@live.cn");
        return new ApiInfo("第一次使用SwaggerAPI文档"
                , "ShiLiLi"
                , "1.0"
                , "urn:tos"
                , contact
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());
    }
}
