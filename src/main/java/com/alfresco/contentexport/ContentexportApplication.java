package com.alfresco.contentexport;

import com.alfresco.contentexport.config.AlfrescoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AlfrescoProperties.class)
public class ContentexportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentexportApplication.class, args);
	}

}
