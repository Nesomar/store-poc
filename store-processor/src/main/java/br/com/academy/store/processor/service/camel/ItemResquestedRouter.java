package br.com.academy.store.processor.service.camel;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import br.com.academy.store.processor.service.kafka.converter.JsonConverter;
import br.com.academy.store.processor.service.kafka.wrapper.ItemRequest;

@Component
public class ItemResquestedRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("kafka:{{kafka.topic.consumer.item.requested}}"
				+ "?brokers={{camel.component.kafka.brokers}}"
				+ "&groupId={{spring.kafka.consumer.group-id}}")
		.routeId("itemRequested")
		.process(exchange -> {
			ItemRequest item = JsonConverter.fromJson(exchange.getIn().getBody(String.class), ItemRequest.class);
			item.setStatus("IN PROGRESSING");
			item.setUpdateDate(LocalDateTime.now().toString());
			exchange.getIn().setBody(JsonConverter.toJson(item));
		})
		.multicast().parallelProcessing(true)
		.to("spring-rabbitmq:{{spring.rabbitmq.exchange}}"
				+ "?routingKey={{spring.rabbitmq.routingkey}}")
		.to("kafka:{{kafka.topic.producer.item.in.processing}}")
		.end();
	}

}
