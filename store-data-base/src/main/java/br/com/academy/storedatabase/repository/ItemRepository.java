package br.com.academy.storedatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.academy.storedatabase.repository.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
