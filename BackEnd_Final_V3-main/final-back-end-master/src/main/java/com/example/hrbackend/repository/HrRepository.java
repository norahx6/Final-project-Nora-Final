package com.example.hrbackend.repository;

import com.example.hrbackend.model.Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrRepository extends JpaRepository<Hr,Integer> {
//    Hr findCustomerById(Integer hrId);
    Hr findByUserId(Integer id);
}