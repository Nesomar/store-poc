package br.com.academy.store.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.store.manager.model.ItemRequest;
import br.com.academy.store.manager.service.StoreService;

@RestController
@RequestMapping(path = "/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@PostMapping("/request-item")
	public ResponseEntity<?> requestItem(@RequestBody ItemRequest itemRequest) {
		
		service.requestItem(itemRequest);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
