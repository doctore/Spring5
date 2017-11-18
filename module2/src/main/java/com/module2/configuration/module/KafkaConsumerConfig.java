package com.module2.configuration.module;

import com.module2.Constants;
import com.module2.enums.ApplicationPropertiesEnum;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.converter.MessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {Constants.APPLICATION_PATH.SERVICE})
@EnableKafka
public class KafkaConsumerConfig {

    /**
     *    {@link KafkaListenerContainerFactory} used here accepts a {@link MessageConverter}, and to automatically
     * turn a {@link String} into the desired object, you can pass it a {@link StringJsonMessageConverter}.
     * This will take the {@link String} and convert it into the object as specified as argument in the @KafkaListener
     * annotated method.
     */
    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setMessageConverter (new StringJsonMessageConverter());
        factory.setConsumerFactory (consumerFactory());

        return factory;
    }


    /**
     * Configuration of the factory used to work with {@link KafkaListenerContainerFactory}
     *
     * @return {@link ConsumerFactory} with the final configuration options for the Kafka consumers
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        Map<String, Object> props = new HashMap<>();
        props.put (ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationPropertiesEnum.KAFKA_SERVER.getValue());
        props.put (ConsumerConfig.GROUP_ID_CONFIG, Constants.KAFKA_GROUPID);
        props.put (ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put (ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props);
    }

}
