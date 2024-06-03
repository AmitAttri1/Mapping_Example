package com.infy.repository;

import org.springframework.data.repository.CrudRepository;
import com.infy.entity.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer>{
	
}
