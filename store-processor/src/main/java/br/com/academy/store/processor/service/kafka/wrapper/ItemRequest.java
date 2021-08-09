package br.com.academy.store.processor.service.kafka.wrapper;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemRequest implements Serializable {

	private static final long serialVersionUID = -1353380986622256491L;
	
	private String codigo;
	private Integer quantidade;
	private String status;
	private String updateDate;
	private String resquetedDate;
}
