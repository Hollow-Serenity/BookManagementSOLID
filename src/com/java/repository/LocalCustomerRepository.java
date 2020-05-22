package com.java.repository;

import com.java.SystemManager;
import com.java.entity.Book;
import com.java.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class LocalCustomerRepository implements CustomerRepository {

    private ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        //never return the actual list to prevent modification from outside.
        return new ArrayList<>(customers);
    }

    @Override
    public void clear() {
        customers.clear();
    }
}
