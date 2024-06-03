package com.infy;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infy.dto.CustomerDTO;
import com.infy.dto.LoanDTO;
import com.infy.service.CustomerLoanService;

@SpringBootApplication
public class SpringBootManyToOneMappingProjectApplication  implements CommandLineRunner {

	@Autowired
	CustomerLoanService customerLoanService;
	
	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootManyToOneMappingProjectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//getLoanDetails();
		//addLoanAndCustomer();
		//sanctionLoanToExistingCustomer();
		//closeLoan();
		  deleteLoan();
	}

	public void getLoanDetails() {
		try {
			LoanDTO loanDTO=customerLoanService.getLoanDetails(2001);
			System.out.println(loanDTO);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}
	
	public void addLoanAndCustomer() {
		try{
			LoanDTO loanDTO=new LoanDTO();
			
			loanDTO.setAmount(5000000.0);
			loanDTO.setLoanIssueDate(LocalDate.of(2015, 11, 1));
			loanDTO.setStatus("Open");
			
			CustomerDTO customerDTO=new CustomerDTO();
			customerDTO.setCustomerId(1006);
			customerDTO.setDateOfBirth(LocalDate.of(1992, 1, 10));
			customerDTO.setEmailId("peter@infy.com");
			customerDTO.setName("Peter");
			
			loanDTO.setCustomer(customerDTO);
			Integer loanId=customerLoanService.addLoanAndCustomer(loanDTO);
			System.out.println(environment.getProperty("UserInterface.NEW_LOAN_CUSTOMER_SUCCESS")+loanId);
		}catch(Exception e){
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}
	
	public void sanctionLoanToExistingCustomer() {
		try{
			
			LoanDTO loanDTO=new LoanDTO();
			loanDTO.setAmount(573279.0);
			loanDTO.setLoanIssueDate(LocalDate.of(2013, 11, 1));
			loanDTO.setStatus("Open");
			Integer customerId=1001;
			customerLoanService.sanctionLoanToExistingCustomer(customerId, loanDTO);
			System.out.println(environment.getProperty("UserInterface.LOAN_SANCTION_SUCCESS"));
		}catch(Exception e){
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}
	
	public void closeLoan() {
		try {
			Integer loanId=2003;
			customerLoanService.closeLoan(loanId);
			System.out.println(environment.getProperty("UserInterface.LOAN_CLOSE_SUCCESS"));
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}
	
	public void deleteLoan() {
		try {
			Integer loanId=2003;
			customerLoanService.deleteLoan(loanId);
			System.out.println(environment.getProperty("UserInterface.LOAN_DELETE_SUCCESS"));
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}
}
