package br.com.academy.storestock.service.kafka;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import br.com.academy.storestock.service.kafka.converter.JsonConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducer {

	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topic, String message) {

		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				log.info("Message [{}] delivered with offset {}", message, result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.warn("Unable to deliver message [{}]. {}", message, ex.getMessage());
			}
		});

	}

	public void sendMessage(String topic, Object body) {

		String message = JsonConverter.toJson(body);

		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				log.info("Message [{}] delivered with offset {}", message, result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.warn("Unable to deliver message [{}]. {}", message, ex.getMessage());
			}
		});
	}
}
