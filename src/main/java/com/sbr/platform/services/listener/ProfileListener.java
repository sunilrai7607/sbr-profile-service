package com.sbr.platform.services.listener;

import com.sbr.platform.services.model.entity.Event;
import com.sbr.platform.services.repository.primary.EventPrimaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

@Configuration
@EnableKafka
@Slf4j
public class ProfileListener {

    private static int value = 1;
    private final EventPrimaryRepository eventPrimaryRepository;

    @Autowired
    public ProfileListener(EventPrimaryRepository eventPrimaryRepository) {
        this.eventPrimaryRepository = eventPrimaryRepository;
    }

    @KafkaListener(topics = "${sbr.service.kafka-config.topic}", groupId = "${sbr.service.kafka-config.group-id}", containerFactory = "kafkaListenerContainerFactory")
    @SendTo
    public void eventListener(Event event, ConsumerRecord<?, ?> cr, Acknowledgment ack) {
        event = eventPrimaryRepository.save(event);
        log.info("Event consume and persisted into collections: {} ", event);
        ack.acknowledge();
    }

    @KafkaListener(id = "profile", topics = "${sbr.service.kafka-config.topic}", containerFactory = "kafkaListenerContainerFactory")
    @SendTo
    public void listenPEN_RE(@Payload Event event,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                             @Header(KafkaHeaders.OFFSET) int offsets,
                             Acknowledgment acknowledgment) {
        log.info("Event Consumer: Partition : {} OffSet : {}  consume : {} ", partition, offsets, event);

        if (value % 2 == 0) {
            acknowledgment.acknowledge();
        }
        value++;
    }


    @KafkaListener(topicPartitions
            = @TopicPartition(topic = "${sbr.service.kafka-config.topic}", partitionOffsets = {
            @PartitionOffset(partition = "0", initialOffset = "0")}), groupId = "${sbr.service.kafka-config.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void listenAllMsg(@Payload Event message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info(" all msg Received Messasge in group {}:  {} ", message, "RECEIVED_PARTITION_ID - " + partition);

    }
}
