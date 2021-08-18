package br.com.academy.storedatabase.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "itens")
@Data
@NoArgsConstructor
public class Item implements Serializable {
	
	private static final long serialVersionUID = -5002695081948820547L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "updateDate")
	private String updateDate;
	
	@Column(name = "resquetedDate")
	private String resquetedDate;
}
