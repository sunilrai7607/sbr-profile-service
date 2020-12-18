package com.sbr.platform.services.events;

import com.sbr.platform.services.config.properties.KafkaConfigProperties;
import com.sbr.platform.services.model.entity.Event;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
@Data
public class EventProducer {

    private final KafkaTemplate<String, Event> kafkaProfileTemplate;
    private final KafkaConfigProperties kafkaConfigProperties;

    @Autowired
    public EventProducer(KafkaTemplate<String, Event> kafkaProfileTemplate, KafkaConfigProperties kafkaConfigProperties) {
        this.kafkaProfileTemplate = kafkaProfileTemplate;
        this.kafkaConfigProperties = kafkaConfigProperties;
    }

    /**
     * Method to send message
     *
     * @param event
     * @return
     */
    public boolean publishEvent(final Event event) {
        ListenableFuture<SendResult<String, Event>> eventFuture = kafkaProfileTemplate.send(kafkaConfigProperties.getTopic(), event.getId().toString(), event);
        eventFuture.addCallback(new ListenableFutureCallback<SendResult<String, Event>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[ {} ] due to : {}", event, ex.getMessage());
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, Event> result) {
                log.info("Sent message=[ {} ] with offset=[ {} ]", event, result.getRecordMetadata().offset());
                log.info("Sent KEY=[ {} ] with value=[ {} ]", result.getProducerRecord().key(), result.getProducerRecord().value());
            }
        });
        return eventFuture.isDone();
    }

}
