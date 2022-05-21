package com.rsjavasolutions.kafkaconsumer.config;

import com.rsjavasolutions.kafkaconsumer.model.Email;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String BOOTSTRAP_SERVERS;

    @Bean
    public ConsumerFactory<String, Email> emailConsumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(Email.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Email> emailKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Email> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(emailConsumerFactory());

        return factory;
    }


    // consumer factory dla innego obietu np SMS

//    @Bean
//    public ConsumerFactory<String, Sms> smsConsumerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
//        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
//                new JsonDeserializer<>(Sms.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Sms> smsKafkaListenerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Sms> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(smsConsumerFactory());
//
//        return factory;
//    }
}
