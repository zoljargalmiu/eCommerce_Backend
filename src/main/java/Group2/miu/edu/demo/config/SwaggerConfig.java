package Group2.miu.edu.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public ApiInfo api() {
        return new ApiInfoBuilder()
                .title("e-Commerce Application")
                .version("1.0.0")
                .description("Api Documentation for e-Commerce System")
                .termsOfServiceUrl("")
                .build();
    }
}
