package cn.kollorsong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class Swagger2 {

    //http://localhost:8888/foodie/swagger-ui.html
    //http://localhost:8888/foodie/doc.html


    @Bean
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2) //指定api类型为swagger2
                .apiInfo(apiInfo())  //用于定义api文档汇总信息
                .select().apis(RequestHandlerSelectors.basePackage("cn.kollorsong.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("天天吃货 api文档") //文档页标题
                .contact(new Contact("KollorSong","http:wwww.baidu.com","15632766111@163.com")) //联系人
                .description("天天吃货练习的AIP文档") //描述
                .version("1.0.1") //版本
                .termsOfServiceUrl("http:wwww.baidu.com")//网站地址
                .build();
    }





}
