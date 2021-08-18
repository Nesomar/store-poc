package br.com.academy.store.processor.service.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DebeziumRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		from("debezium-postgres:dbz-postgres?offsetStorageFileName={{camel.component.debezium-postgres.offset-storage-file-name}}"
				+ "&databaseHostName={{camel.component.debezium-postgres.database-hostname}}"
				+ "&databaseUser={{camel.component.debezium-postgres.database-user}}"
				+ "&databasePassword={{camel.component.debezium-postgres.database-password}}"
				+ "&databaseServerName={{camel.component.debezium-postgres.database-server-name}}"
				+ "&databaseDbname={{camel.component.debezium-postgres.database-dbname}}"
				+ "&pluginName={{camel.component.debezium-postgres.plugin-name}}")
		.log("Event: ${body}");
	}

}
