package br.com.academy.store.payment.service.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receivedPaymentRequest(@Payload String body) {
		log.info(body);
	}
}
