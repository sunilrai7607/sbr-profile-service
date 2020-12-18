package com.sbr.platform.services.config.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "sbr.service.kafka-config")
public class KafkaConfigProperties {

    @NotNull
    private String bootstrapServers;
    @NotNull
    private String groupId;
    @NotNull
    private String autoOffsetReset;
    @NotNull
    private String topic;
}
