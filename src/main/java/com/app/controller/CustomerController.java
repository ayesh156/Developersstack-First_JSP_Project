package com.app.controller;

import com.app.db.HibernateUtil;
import com.app.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerController {
    public boolean saveCustomer(Customer customer){
        try(Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
        return true;
    }
    public boolean updateCustomer(Customer customer){
        try(Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            Customer selectedCustomer = session.get(Customer.class, customer.getId());
            if (selectedCustomer == null) return false;
            selectedCustomer.setName(customer.getName());
            selectedCustomer.setAddress(customer.getAddress());
            selectedCustomer.setSalary(customer.getSalary());
            transaction.commit();
        }
        return true;
    }
    public boolean deleteCustomer(long id){
        try(Session session = new HibernateUtil().getSession()) {
            Transaction transaction = session.beginTransaction();
            Customer selectedCustomer = session.get(Customer.class, id);
            if (selectedCustomer == null) return false;

            session.delete(selectedCustomer);
            transaction.commit();
        }
        return true;
    }
    public Customer findCustomer(long id){
        try(Session session = new HibernateUtil().getSession()) {
            return session.get(Customer.class,id);
        }
    }
    public List<Customer> findAllCustomer(){
        try(Session session = new HibernateUtil().getSession()) {
            return session.createQuery("FROM Customer", Customer.class).list();
        }
    }
}
