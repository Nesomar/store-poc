package br.com.academy.storestock.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "item")
@Data
@NoArgsConstructor
public class ItemDocument {

	@Id
	private String itemId;
	private String codigo;
	private Integer quantidade;
	private String status;
	private String updateDate;
	private String resquetedDate;
}
