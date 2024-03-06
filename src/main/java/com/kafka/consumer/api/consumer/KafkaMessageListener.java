package com.kafka.consumer.api.consumer;

import com.kafka.consumer.api.constant.AppConstant;
import com.kafka.consumer.api.dto.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    private static final Logger LOGGER = LogManager.getLogger(KafkaMessageListener.class);


    @KafkaListener(topics = AppConstant.TOPIC_NAME, groupId = AppConstant.GROUP_ID)
    public void consumeEvents(Customer customer) {
        LOGGER.info("consumer consume the events {} ", customer.toString());
    }
}
