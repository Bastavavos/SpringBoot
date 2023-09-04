package com.testwebapp.webapp.dao;

import com.testwebapp.webapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    List<Customer> findAll(); // tous les clients
    Customer findById(int id); // client par id
    Customer save(Customer customer); // ajoute un client
  //  Customer updateCustomer(int id, Customer customer); // maj
    Customer deleteAllById(int id); // supp
}
