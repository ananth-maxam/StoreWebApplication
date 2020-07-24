/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.pojo.Customer;
import java.util.List;

/**
 *
 * @author Lenin Ananth
 */
public interface CustomerService {

    public int saveCustomer(Customer customer);

    public List<Customer> getCustomerList();

    public String customerDelete(int id);

    public Customer editCustomer(int id);

    public int updateCustomer(Customer customer);

}
