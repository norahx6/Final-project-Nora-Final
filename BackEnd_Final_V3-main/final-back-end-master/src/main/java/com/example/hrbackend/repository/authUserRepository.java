package com.example.hrbackend.repository;

import com.example.hrbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authUserRepository extends JpaRepository<User,Integer> {

    User findUserByUsername(String username);

    User findCustomerByUsernameAndPassword(String username,String password);
}
