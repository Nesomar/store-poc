package br.com.academy.store.manager.service.kafka.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonConverter {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private JsonConverter() {
	}
	
	public static String toJson(Object entity) {
		try {
			return objectMapper.writeValueAsString(entity);
		} catch (Exception e) {
			log.error("Error converting entity to json");
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(String json, Class<T> typeReference) {
		try {
			return objectMapper.readValue(json, typeReference);
		} catch (Exception e) {
			log.error("Error converting json: {} to: {} ", json, typeReference.getSimpleName());
			throw new RuntimeException(e);
		}
	}
}
