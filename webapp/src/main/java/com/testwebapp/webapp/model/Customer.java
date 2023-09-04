package com.testwebapp.webapp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Entity;

//@JsonFilter("monFiltreDynamique")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String firstname;
    private Date dateofbirth;
    private String permitnumber;


    public Customer(int id, String name, String firstname, Date dateofbirth, String permitnumber) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.dateofbirth = dateofbirth;
        this.permitnumber = permitnumber;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPermitnumber() {
        return permitnumber;
    }

    public void setPermitnumber(String permitnumber) {
        this.permitnumber = permitnumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", permitnumber='" + permitnumber + '\'' +
                '}';
    }
}

