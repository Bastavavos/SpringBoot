package com.testwebapp.webapp.dao;

import com.testwebapp.webapp.exception.PermitException;
import com.testwebapp.webapp.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAll(); // tous les clients
    Customer findById(int id); // client par id
    Customer save(Customer customer); // ajoute un client
    Customer updateCustomer(int id, Customer customer); // maj
    Customer deleteCustomer(int id); // supp
}
