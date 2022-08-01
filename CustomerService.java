package com.example.bank.service;

import com.example.bank.entity.Customer;
import com.example.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> saveCustomers(List<Customer> customers) {
        return repository.saveAll(customers);
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Customer getCustomerByName(String name) {
        return (Customer) repository.findByName(name);
    }

    public String deleteCustomerById(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Customer updateCustomer (Customer customer) {
        Customer existingCustomer = repository.findById(customer.getId()).orElse(null);
        existingCustomer.setName(customer.getName());
        existingCustomer.setAcc_no(customer.getAcc_no());
        existingCustomer.setBalance(customer.getBalance());
        return repository.save(existingCustomer);
    }


}