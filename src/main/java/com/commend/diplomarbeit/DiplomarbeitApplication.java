package com.commend.diplomarbeit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//  import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@SwaggerEnable2
public class DiplomarbeitApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiplomarbeitApplication.class, args);
    }

    /*
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.commend.diplomarbeit")).build();
    }

     */

}
