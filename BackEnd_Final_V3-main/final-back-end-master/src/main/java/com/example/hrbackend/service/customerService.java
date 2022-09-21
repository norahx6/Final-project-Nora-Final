package com.example.hrbackend.service;

import com.example.hrbackend.model.Customer;
import com.example.hrbackend.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class customerService {
    private final CustomerRepository custmerrepositry;
    public List<Customer> get_Customer() {

        return custmerrepositry.findAll();
    }
    public void add_customer(Customer customer) {

        custmerrepositry.save(customer);
    }
    public void update_customer(Customer customer, Integer id) {
        Customer cus=custmerrepositry.getById(id);
        cus.setGoal(customer.getGoal());
        cus.setUserId(customer.getUserId());
        custmerrepositry.save(cus);
    }

    public void delete_customer(Integer id) {
        Customer myCustomer = custmerrepositry.getById(id);
        custmerrepositry.delete(myCustomer);
    }

}
