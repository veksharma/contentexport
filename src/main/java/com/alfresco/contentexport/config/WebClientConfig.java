package com.alfresco.contentexport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient alfrescoWebClient(
            WebClient.Builder builder,
            AlfrescoProperties properties
    ) {
        return builder
                .baseUrl(properties.getBaseUrl())
                .defaultHeaders(headers -> headers.setBasicAuth(
                        properties.getUsername(),
                        properties.getPassword()
                ))
                .build();
    }
}