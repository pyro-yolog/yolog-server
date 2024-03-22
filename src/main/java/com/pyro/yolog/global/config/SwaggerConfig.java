package com.pyro.yolog.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    private final String JWT = "JWT";
    private final String BEARER = "Bearer";

    @Bean
    public OpenAPI openAPI() {
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(JWT);
        return new OpenAPI()
                .servers(getServers())
                .info(getInfo())
                .addSecurityItem(securityRequirement)
                .components(getComponents());
    }

    private List<Server> getServers() {
        return List.of(new Server()
                .url("/api")
                .description("백엔드 api 서버")
        );
    }

    private Info getInfo() {
        return new Info()
                .title("Yolog API")
                .description("간단하게 여행을 기록할 수 있는 서비스")
                .version("demo");
    }

    private Components getComponents() {
        return new Components().addSecuritySchemes(JWT, new SecurityScheme()
                .name(JWT)
                .type(SecurityScheme.Type.HTTP)
                .scheme(BEARER)
                .bearerFormat(JWT)
        );
    }
}
