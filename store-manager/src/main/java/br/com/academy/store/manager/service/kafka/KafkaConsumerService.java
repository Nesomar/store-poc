package br.com.academy.store.manager.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumerService {

	@KafkaListener(topics = "${kafka.topic.consumer.item.processed}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeProcessedItem(@Payload String message) {
		 log.info(String.format("Message recieved -> %s", message));
	}
}
