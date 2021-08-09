package br.com.academy.store.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.academy.store.manager.model.ItemRequest;
import br.com.academy.store.manager.service.kafka.KafkaProducerService;

@Service
public class StoreService {

	@Autowired
	private KafkaProducerService itemProducer;
	
	@Value("${kafka.topic.producer.item.requested}")
	private String topicName;
	
	public void requestItem(ItemRequest itemRequest) {
		itemProducer.sendMessage(topicName, itemRequest);
	}

}
