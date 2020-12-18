package com.sbr.platform.services.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.sbr.platform.services.repository.secondary"}, mongoTemplateRef = "secondaryMongoTemplate")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SecondaryMongodbConfig {

}
