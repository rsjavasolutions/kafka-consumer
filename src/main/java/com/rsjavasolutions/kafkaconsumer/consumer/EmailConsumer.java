package com.rsjavasolutions.kafkaconsumer.consumer;

import com.rsjavasolutions.kafkaconsumer.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailConsumer {

    @KafkaListener(groupId = "groupId", topics = "email")
    public void getJsonMsgFromTopic(Email email) {
        log.info("Wiadomość otrzymana z topica -> Email to: {} with content: {} ", email.getAddresses(), email.getContent());
    }
}