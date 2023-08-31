package com.testwebapp.webapp.dao;

import com.testwebapp.webapp.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class CustomDaoImpl implements CustomerDao {
    public static List<Customer> listCustomer = new ArrayList<>();

    static  {
        listCustomer.add(new Customer(0, "Zakuross", "emulatos", new Date(2000, Calendar.DECEMBER, 25), "aaa000"));
        listCustomer.add(new Customer(1, "Matis", "legrand", new Date(2050, Calendar.DECEMBER, 24), "baa000"));
        listCustomer.add(new Customer(2, "Hich", "lesorcier", new Date(1050, Calendar.DECEMBER, 23), "caa000"));
    }

    @Override
    public List<Customer> findAll() {
        return listCustomer;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : listCustomer){
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        listCustomer.add(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        Customer updateCustomer = findById(id);

        updateCustomer.setFirstname(customer.getFirstname());
        updateCustomer.setName(customer.getName());
        updateCustomer.setDateofbirth(customer.getDateofbirth());
        updateCustomer.setPermitnumber(customer.getPermitnumber());

        return updateCustomer;
    }

    @Override
    public Customer deleteCustomer(int id) {
        Customer deleteCustomer = findById(id);
        if (deleteCustomer != null) {
            listCustomer.remove(deleteCustomer);
        }
        return  deleteCustomer;
    }
}
