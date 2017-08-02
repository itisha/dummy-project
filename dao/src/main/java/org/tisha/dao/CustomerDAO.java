package org.tisha.dao;


import org.tisha.entity.Customer;

import java.util.List;


public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);

}
