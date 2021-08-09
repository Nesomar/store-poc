package br.com.academy.storestock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.academy.storestock.document.ItemDocument;
import br.com.academy.storestock.model.ItemRequest;

@Repository
public interface ItemRepository extends MongoRepository<ItemDocument, String> {

	ItemRequest findByCodigo(String codigo);
}
