/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceImpl;

import com.dao.CustomerDao;
import com.daoImpl.CustomerDaoImpl;
import com.pojo.Customer;
import com.service.CustomerService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenin Ananth
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public int saveCustomer(Customer customer) {

        int result = customerDao.saveCustomer(customer);

        return result;
    }

    @Override
    public List<Customer> getCustomerList() {
        List<Customer> custoemrList = new ArrayList<>();
        custoemrList = customerDao.getCustomerList();

        return custoemrList;
    }

    @Override
    public String customerDelete(int id) {

        String result = customerDao.customerDelete(id);

        return result;
    }

    @Override
    public Customer editCustomer(int id) {

        Customer customer = customerDao.editCustomer(id);
        return customer;
    }

    @Override
    public int updateCustomer(Customer customer) {

        int result = customerDao.updateCustomer(customer);
        return result;
    }

}
