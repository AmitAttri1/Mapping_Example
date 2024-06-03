package com.infy.repository;
import org.springframework.data.repository.CrudRepository;
import com.infy.entity.Services;

public interface ServicesRepository extends CrudRepository<Services, Integer> {
	
}