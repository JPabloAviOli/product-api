package com.pavila.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(

        info = @Info(
                contact = @Contact(
                        name = "Pablo Avila",
                        url = "https://www.linkedin.com/in/pablo-avila-olivar/"

                ),
                description = "Documentation for the Product Management API. This API provides CRUD (Create, Read, Update, Delete) operations for managing product data, including product creation, retrieval, updating, and deletion. It's designed to be simple and easy to use for basic product management tasks.",
                title = "API Product",
                version = "1.0"

        ),
        servers = {
                @Server(
                        description = "Local",
                        url = "http://localhost:8090"
                )
        }
)
public class OpenApiConfig {
}
