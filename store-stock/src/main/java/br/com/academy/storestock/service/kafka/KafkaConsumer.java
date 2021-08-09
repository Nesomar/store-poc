package br.com.academy.storestock.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.academy.storestock.service.ItemService;
import br.com.academy.storestock.service.kafka.converter.JsonConverter;
import br.com.academy.storestock.service.kafka.wrapper.ItemRequested;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {
	
	@Autowired
	private ItemService service;

	@KafkaListener(topics = "${kafka.topic.consumer.item.in.processing}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeProcessedItem(@Payload String message) {
		 log.info(String.format("Message recieved -> %s", message));
		 service.save(JsonConverter.fromJson(message, ItemRequested.class));
	}
}
