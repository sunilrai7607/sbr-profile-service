package com.sbr.platform.services.config.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "sbr.service.rediscache.config")
public class RedisConfigProperties {

    @NotNull
    private String hostName;

    @Min(6379)
    @Max(6380)
    private Integer port;

    @PostConstruct
    public void printProperties() {
        log.info("RedisConfigProperties : {} ", RedisConfigProperties.this);
    }

}
