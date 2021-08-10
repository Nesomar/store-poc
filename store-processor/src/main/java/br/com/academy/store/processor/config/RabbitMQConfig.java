package br.com.academy.store.processor.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.host}")
	private String host;
	
	@Value("${spring.rabbitmq.port}")
	private Integer port;
	
	@Value("${spring.rabbitmq.username}")
	private String username;
	
	@Value("${spring.rabbitmq.password}")
	private String password;
	
	@Bean
	public ConnectionFactory connectionFactory() {
		
	    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
	    
	    connectionFactory.setHost(host);
	    connectionFactory.setPort(port);
	    connectionFactory.setUsername(username);
	    connectionFactory.setPassword(password);
	    return connectionFactory;
	}
}
