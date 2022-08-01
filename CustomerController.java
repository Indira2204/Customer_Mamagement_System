package com.example.bank.controller;

import com.example.bank.service.CustomerService;
import com.example.bank.entity.Customer;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	@PostMapping("/addcustomers")
	public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
		return service.saveCustomers(customers);
	}
	
	@GetMapping("/customers/")
	public List<Customer> findAllCustomers() {
		return service.getCustomers();
	}
	@GetMapping("/customerById/{id}")
	public Customer findCustomerById(@PathVariable int id) {
		return (Customer) service.getCustomerById(id);
	}
	
	@GetMapping("/customerByName/{name}")
	public Customer findCustomerByName(@PathVariable String name) {
		return (Customer) service.getCustomerByName(name);
	}
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return service.deleteCustomerById(id);
	}


}
