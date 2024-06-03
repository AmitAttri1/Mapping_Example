package com.infy.repository;

import org.springframework.data.repository.CrudRepository;
import com.infy.entity.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {
	
}

