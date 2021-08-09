package br.com.academy.storestock.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.storestock.model.ItemRequest;
import br.com.academy.storestock.service.ItemService;

@RestController
@RequestMapping(path = "/stock")
public class StockController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ItemRequest> findItemByCodigo(@PathVariable(value = "codigo") String codigo) {
		
		var itemRequest = itemService.findItemByCodigo(codigo);
		
		itemRequest.add(linkTo(methodOn(StockController.class).findItemByCodigo(codigo)).withSelfRel());
		
		return ResponseEntity.ok(itemRequest);
	}
}
