package com.kafka.consumer.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.consumer.api.model.User;

@SpringBootApplication
@RestController
public class KafkaConsumerApplication {

	List<String> message = new ArrayList<>();
	User userFromTopic = null;

	@GetMapping("/consumerStringMessage")
	public List<String> consumeMsg() {
		return message;
	}

	@GetMapping("/consumerJsonMessage")
	public User consumeJsonMsg() {
		return userFromTopic;
	}

	@KafkaListener(groupId = "test-1", topics = "TestTopic", containerFactory = "concurrentKafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		message.add(data);
		return message;
	}

	@KafkaListener(groupId = "test-2", topics = "TestTopic", containerFactory = "userConcurrentKafkaListenerContainerFactory")
	public User getJsonMsgFromTopic(User user) {
		userFromTopic = user;
		return userFromTopic;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
