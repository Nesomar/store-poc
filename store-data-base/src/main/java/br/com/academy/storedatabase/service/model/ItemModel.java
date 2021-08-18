package br.com.academy.storedatabase.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemModel {

	private Long id;
	private String codigo;
	private Integer quantidade;
	private String status;
	private String updateDate;
	private String resquetedDate;
}
