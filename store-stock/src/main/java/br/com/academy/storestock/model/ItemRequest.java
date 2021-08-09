package br.com.academy.storestock.model;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemRequest extends RepresentationModel<ItemRequest> implements Serializable {
	
	private static final long serialVersionUID = -2251653606386643986L;
	
	private String codigo;
	private Integer quantidade;
	private String status;
	private String updateDate;
	private String resquetedDate;

}
