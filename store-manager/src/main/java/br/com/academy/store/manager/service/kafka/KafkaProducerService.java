package br.com.academy.store.manager.service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducerService {

	private KafkaTemplate<String, String> kafkaTemplate;

	private ObjectMapper mapper;

	public void sendMessage(String topic, String message) {
		
		kafkaTemplate.send(topic, message);
		
	}

	public void sendMessage(String topic, Object body) {
		try {
			kafkaTemplate.send(topic, mapper.writeValueAsString(body));
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
	}
}
