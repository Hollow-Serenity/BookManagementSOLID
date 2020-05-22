package com.java.repository;

import com.java.entity.Book;
import com.java.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    void addCustomer(Customer customer);

    List<Customer> getCustomers();

    void clear();
}
