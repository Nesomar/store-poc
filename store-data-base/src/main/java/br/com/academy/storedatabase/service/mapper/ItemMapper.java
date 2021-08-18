package br.com.academy.storedatabase.service.mapper;

import org.modelmapper.ModelMapper;

import br.com.academy.storedatabase.repository.entity.Item;
import br.com.academy.storedatabase.service.model.ItemModel;

public class ItemMapper {

	private ItemMapper() {
		
	}
	
	private static ModelMapper mapper = new ModelMapper();
	
	public static Item toEntity(ItemModel model) {
		return mapper.map(model, Item.class);
	}
	
	public static ItemModel toModel(Item item) {
		return mapper.map(item, ItemModel.class);
	}
}
