package com.infy.service;

import java.util.List;

import com.infy.dto.CardDTO;
import com.infy.dto.CustomerDTO;
import com.infy.exception.InfyBankException;
public interface CardCustomerService {
	
	public CustomerDTO getCustomerDetails(Integer customerId) throws InfyBankException;
	public Integer addCustomer(CustomerDTO customerDTO) throws InfyBankException;
	public void issueCardToExistingCustomer(Integer customerId, CardDTO cardDTO) throws InfyBankException;
	public void deleteCardOfExistingCustomer(Integer customerId, List<Integer> cardIdsToDelete) throws InfyBankException;
	
}
