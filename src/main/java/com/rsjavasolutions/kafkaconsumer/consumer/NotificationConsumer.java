package com.rsjavasolutions.kafkaconsumer.consumer;

import com.rsjavasolutions.kafkaconsumer.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {

    private static final String EMAIL_TOPIC = "email";

    @KafkaListener(groupId = "groupId", topics = EMAIL_TOPIC, containerFactory = "emailKafkaListenerFactory")
    public void getJsonMsgFromEmail(Email email) {

        log.info("Wiadomość otrzymana z topica: EMAIL_TOPIC -> Email to: {} with content: {} ", email.getAddresses(), email.getContent());
    }

    // przykładowe odbieranie innego obiektu z innego Topica

//    @KafkaListener(groupId = "groupId", topics = SMS_TOPIC, containerFactory = "smsKafkaListenerFactory")
//    public void getJsonMsgFromSmsTopic(Sms sms) {
//
//        log.info("Wiadomość otrzymana z topica SMS_TOPIC -> Sms for number: {} with content: {} ", sms.getNumber(), sms.getContent());
//    }
}