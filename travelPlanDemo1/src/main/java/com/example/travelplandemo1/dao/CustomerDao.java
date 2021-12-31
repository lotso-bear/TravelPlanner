package com.example.travelplandemo1.dao;

import com.example.travelplandemo1.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    public void signUp(Customer customer) {

    }

    public Customer getCustomer (String email) {
        return new Customer();
    }
}
