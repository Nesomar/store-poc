package br.com.academy.storestock.service.kafka.wrapper;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemRequested implements Serializable {
	
	private static final long serialVersionUID = 4133278042480919604L;
	
	private String codigo;
	private Integer quantidade;
	private String status;
	private String updateDate;
	private String resquetedDate;
}
