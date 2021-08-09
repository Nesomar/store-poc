package br.com.academy.store.manager.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemRequest implements Serializable {

	private static final long serialVersionUID = 5401218128573421660L;
	
	private String codigo;
	private Integer quantidade;
	private String resquetedDate;

}
