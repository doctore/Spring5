package com.module1.configuration.module;

import com.module1.enums.ApplicationPropertiesEnum;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger (KafkaProducerConfig.class);

    /**
     * Configuration of the factory used to work with {@link KafkaTemplate}
     *
     * @return {@link ProducerFactory} with the final configuration options for the Kafka producers
     */
    @Bean
    public ProducerFactory<String, Object> producerFactory() {

        Map<String, Object> configProps = new HashMap<>();
        configProps.put (ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationPropertiesEnum.KAFKA_SERVER.getValue());
        configProps.put (ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put (ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }


    /**
     * Template used by Kafka producers
     *
     * @return {@link KafkaTemplate}
     */
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {

        return new KafkaTemplate<String, Object>(producerFactory()) {

            @Override
            public ListenableFuture<SendResult<String, Object>> send (String topic, Object message) {

                ListenableFuture<SendResult<String, Object>> future = super.send (topic, message);

                // Manage possible responses of the send method
                future.addCallback (new ListenableFutureCallback<SendResult<String, Object>>() {

                    @Override
                    public void onSuccess (final SendResult<String, Object> result) {
                        LOGGER.info ("Sent message= " + message + " with offset= " + result.getRecordMetadata().offset());
                    }

                    @Override
                    public void onFailure (final Throwable throwable) {
                        LOGGER.error ("Unable to send message= " + message, throwable);
                    }
                });
                return future;
            }
        };
    }

}
