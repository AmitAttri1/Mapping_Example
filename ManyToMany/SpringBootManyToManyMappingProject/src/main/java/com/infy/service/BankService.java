package com.infy.service;
import java.util.List;

import com.infy.dto.CustomerDTO;
import com.infy.exception.InfyBankException;

public interface BankService {
	public Integer addCustomerAndService(CustomerDTO customerDTO) throws InfyBankException;
	public void addExistingServiceToExistingCustomer(Integer customerId,List<Integer> serviceIds) throws InfyBankException;
	public void deallocateServiceForExistingCustomer(Integer customerId,List<Integer> serviceIds) throws InfyBankException;		
}