package s3test.demo.global.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import io.swagger.v3.oas.models.OpenAPI;


@OpenAPIDefinition(
        info = @Info(
                title = "Spring Study",
                description = """
            
            """,
                version = "1.0v"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "로컬 서버")
        }
)
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .servers(List.of(
                                new io.swagger.v3.oas.models.servers.Server()
                                        .url("http://localhost:8080")
                                        .description("로컬 서버")
                        )
                );
    }
}