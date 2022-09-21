package com.example.hrbackend.controller;

import com.example.hrbackend.dto.ApiResponse;
import com.example.hrbackend.model.Customer;
import com.example.hrbackend.service.customerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
@RestController
public class CustomerController {


    public final customerService customerservice;


    @GetMapping
    public ResponseEntity<List> getCustomer(){
        List<Customer> customer=customerservice.get_Customer();
        return ResponseEntity.status(200).body(customer);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> addCustomer(@RequestBody @Valid Customer customer){
        customerservice.add_customer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("customer added",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCustomer(@RequestBody @Valid Customer custmer, @PathVariable Integer id){
        customerservice.update_customer(custmer,id);
        return ResponseEntity.status(200).body(new ApiResponse("Customer updated,",200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Integer id){
        customerservice.delete_customer(id);
        return ResponseEntity.status(200).body(new ApiResponse("customer deleted",200));

    }


}