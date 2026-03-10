package com.gestion.eventos.api.security.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String SCHEMA_NAME = "bearerAuth";
    private static final String BEARER_FORMAT = "JWT";
    private static final String DESCRPTION   = "JWT authentication para la Api de Eventos";
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SCHEMA_NAME))
                .components(new Components()
                        .addSecuritySchemes(SCHEMA_NAME,
                                new SecurityScheme()
                                        .name(SCHEMA_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat(BEARER_FORMAT)
                                        .in(SecurityScheme.In.HEADER)
                                        .description(DESCRPTION)
                        )
                )
                .info(new Info()
                    .title("Gestion de Eventos Api")
                        .version("1.0")
                        .description("API RESTFULL para la gestion de eventos, categorias y ponentes")
                        .contact(new Contact()
                                .name("Fernando Fernandez")
                                .email("ff14051999@gmail.com")
                                .url("https://github.com/gohan1405"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.htlml"))
                );
    }
}
