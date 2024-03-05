package com.kafka.consumer.api.consumer;

import com.kafka.consumer.api.constant.AppConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class MessageConsumer {

    private static final Logger LOGGER = LogManager.getLogger(MessageConsumer.class);

    @KafkaListener(topics = AppConstant.TOPIC_NAME, groupId = AppConstant.GROUP_ID)
    public void consumeMessage(String message) {
        LOGGER.info(format("Consuming the message from " + AppConstant.TOPIC_NAME + " topic:: %s", message));
    }
}
