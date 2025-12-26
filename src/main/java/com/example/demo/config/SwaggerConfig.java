package com.example.demo.config;

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

    @Bean
    public OpenAPI customOpenAPI() {

        final String securitySchemeName = "BearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("Hostel Roommate Compatibility Matcher API")
                        .description("API documentation with JWT authentication")
                        .version("1.0"))

                // 🔐 JWT Security Requirement
                .addSecurityItem(
                        new SecurityRequirement().addList(securitySchemeName)
                )

                // 🔐 JWT Security Scheme
                .components(
                        new io.swagger.v3.oas.models.Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )

                // 🌍 Server configuration
                .servers(List.of(
                        new Server().url("https://9030.408procr.amypo.ai/")
                ));
    }
}
