package com.auth_sys.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                                .title("Role-Based Access Control System APIs")
                                .description("RBAC system API documentation")
                                .version("1.0.0")
//                        .contact(new Contact()
//                                .name("Auth System Support")
//                                .email("support@authsys.com"))
//                        .license(new License()
//                                .name("Apache 2.0"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8081").description("Local")
//                        new Server().url("https://api.authsys.com").description("Production")
                ))
                .components(new Components()
                        .addSecuritySchemes("BearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .tags(List.of(
                        new Tag().name("Authentication").description("Login and Register APIs"),
                        new Tag().name("Admin").description("Admin APIs"),
                        new Tag().name("User").description("User APIs"),
                        new Tag().name("Home").description("Health APIs")
                ));

    }
}
