package org.tisha.service;


import org.tisha.entity.Customer;

import java.util.List;


public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);

}
