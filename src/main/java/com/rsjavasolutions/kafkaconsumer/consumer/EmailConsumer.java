package com.rsjavasolutions.kafkaconsumer.consumer;

import com.rsjavasolutions.kafkaconsumer.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailConsumer {

    @KafkaListener(groupId = "email-1", topics = "email", containerFactory = "kafkaListenerContainerFactory")
    public void processMessage(String text) {
        log.info("Text  consumed {}", text);
    }

//    @KafkaListener(groupId = "email-2", topics = "email", containerFactory = "emailKafkaListenerContainerFactory")
//    public void processMessage(Email email) {
//        log.info("Message email consumed {}", email);
//    }
}
