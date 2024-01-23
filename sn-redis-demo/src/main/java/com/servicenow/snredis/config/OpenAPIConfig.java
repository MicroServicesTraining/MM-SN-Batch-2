package com.servicenow.snredis.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

  @Value("${sn.openapi.dev-url}")
  private String devUrl;

  @Value("${sn.openapi.uat-url}")
  private String uatUrl;

  @Bean
  public OpenAPI snAPIConfig() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Server uatServer = new Server();
    uatServer.setUrl(uatUrl);
    uatServer.setDescription("Server URL in UAT environment");

    Contact contact = new Contact();
    contact.setEmail("babu@gmail.com");
    contact.setName("Babu");
    contact.setUrl("http://www.sn.com");

    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
        .title("Students Management API")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to manage students.")
        .termsOfService("https://www.sn.com/terms")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(devServer, uatServer));
  }
}
