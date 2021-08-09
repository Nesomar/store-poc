package br.com.academy.storestock.service.kafka.mapper;

import org.modelmapper.ModelMapper;

import br.com.academy.storestock.document.ItemDocument;
import br.com.academy.storestock.service.kafka.wrapper.ItemRequested;

public class ItemMapper {

	private static ModelMapper modelMapper = new ModelMapper();
	
	private ItemMapper() {
		
	}
	
	public static ItemDocument toEntity(ItemRequested itemRequested) {
		return modelMapper.map(itemRequested, ItemDocument.class);
	}
	
	public static ItemRequested toModel(ItemDocument itemDocument) {
		return modelMapper.map(itemDocument, ItemRequested.class);
	}
}
