package com.example.travelplandemo1.service;


import com.example.travelplandemo1.dao.CustomerDao;
import com.example.travelplandemo1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public void signUp(Customer customer) {

    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }
}
