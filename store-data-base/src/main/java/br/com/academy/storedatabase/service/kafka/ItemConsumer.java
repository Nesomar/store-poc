package br.com.academy.storedatabase.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.academy.storedatabase.service.ItemService;
import br.com.academy.storedatabase.service.kafka.converter.JsonConverter;
import br.com.academy.storedatabase.service.model.ItemModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ItemConsumer {

	@Autowired
	private ItemService service;
	
	@KafkaListener(topics = "${kafka.topic.consumer.item.in.processing}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeProcessedItem(@Payload String message) {
		 log.info(String.format("Message recieved -> %s", message));
		 service.saveItem(JsonConverter.fromJson(message, ItemModel.class));
	}
}
