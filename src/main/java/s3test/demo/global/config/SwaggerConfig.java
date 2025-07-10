package s3test.demo.global.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        info = @Info(
                title = "Spring Study",
                version = "1.0v",
                description = "회원 관리 API"
        )
)
@Configuration
public class SwaggerConfig {

}