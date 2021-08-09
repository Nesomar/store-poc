package br.com.academy.storestock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.storestock.repository.ItemRepository;
import br.com.academy.storestock.service.kafka.mapper.ItemMapper;
import br.com.academy.storestock.service.kafka.wrapper.ItemRequested;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;

	public void save(ItemRequested itemRequested) {
		repository.save(ItemMapper.toEntity(itemRequested));
	}
	
}
