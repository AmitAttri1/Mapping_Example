package com.infy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.infy.dto.CustomerDTO;
import com.infy.dto.ServicesDTO;
import com.infy.service.BankService;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class SpringBootManyToManyMappingProjectApplication implements CommandLineRunner {

	@Autowired
	BankService bankService;
	
	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootManyToManyMappingProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//addCustomerAndService();
		//addExistingServiceToExistingCustomer();
		  deallocateServiceForExistingCustomer();
	}
	
	public void addCustomerAndService() {
		try{
			CustomerDTO customerDTO=new CustomerDTO();
			customerDTO.setDateOfBirth(LocalDate.of(1995, 2, 1));
			customerDTO.setEmailId("peter@ibm.com");
			customerDTO.setName("Peter");
			Set<ServicesDTO> servicesList=new LinkedHashSet<ServicesDTO>();
			ServicesDTO servicesDTO1=new ServicesDTO();
			servicesDTO1.setServiceId(3004);
			servicesDTO1.setServiceName("Demat Services");
			servicesDTO1.setServiceCost(200);
			servicesList.add(servicesDTO1);
			customerDTO.setBankServices(servicesList);
			Integer customerId=bankService.addCustomerAndService(customerDTO);
			System.out.println(environment.getProperty("UserInterface.NEW_CUSTOMER_SUCCESS")+customerId);
		}catch(Exception e){
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}
	
	public void addExistingServiceToExistingCustomer() {
		try{
			Integer customerId=1004;
			List<Integer> serviceIds=new ArrayList<>();
			serviceIds.add(3001);
			serviceIds.add(3003);
			bankService.addExistingServiceToExistingCustomer(customerId, serviceIds);
			System.out.println(environment.getProperty("UserInterface.CUSTOMER_SERVICE_ALLOCATION_SUCCESS"));
			
		}catch(Exception e){
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}
	
	public void deallocateServiceForExistingCustomer() {
		try{
			Integer customerId=1002;
			List<Integer> serviceIds=new ArrayList<>();
			serviceIds.add(3003);
			bankService.deallocateServiceForExistingCustomer(customerId, serviceIds);
			System.out.println(environment.getProperty("UserInterface.CUSTOMER_SERVICE_DEALLOCATION_SUCCESS"));
		}catch(Exception e){
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}
}
	