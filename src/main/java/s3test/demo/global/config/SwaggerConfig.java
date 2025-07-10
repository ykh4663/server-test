package s3test.demo.global.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        info = @Info(
                title = "Spring Study",
                version = "1.0v",
                description = "회원 관리 API"
        ),
        servers = {
                @Server(url = "https://api.post-server.p-e.kr", description = "Default Server URL")
        }
)
@Configuration
public class SwaggerConfig {

}