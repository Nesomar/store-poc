package br.com.academy.storedatabase.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.storedatabase.repository.ItemRepository;
import br.com.academy.storedatabase.service.mapper.ItemMapper;
import br.com.academy.storedatabase.service.model.ItemModel;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;
	
	@Transactional
	public ItemModel saveItem(ItemModel itemModel) {
		return ItemMapper.toModel(repository.save(ItemMapper.toEntity(itemModel)));
	}
}
