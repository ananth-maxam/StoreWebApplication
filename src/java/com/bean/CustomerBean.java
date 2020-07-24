/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.pojo.Customer;
import com.service.CustomerService;
import com.serviceImpl.CustomerServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lenin Ananth
 */
@ManagedBean(name = "customerbean")
public class CustomerBean {

    private Customer customer = new Customer();
    private Customer deepcopy = new Customer();
    private CustomerService customerService = new CustomerServiceImpl();
    private List<Customer> customerList = new ArrayList<>();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private boolean editDialog = false;

    public boolean isEditDialog() {
        return editDialog;
    }

    public void setEditDialog(boolean editDialog) {
        this.editDialog = editDialog;
    }

    public Customer getDeepcopy() {
        return deepcopy;
    }

    public void setDeepcopy(Customer deepcopy) {
        this.deepcopy = deepcopy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int saveCustomer() {

        int result = customerService.saveCustomer(customer);

        return result;
    }

    public List<Customer> getCustomerList() {
        customerList = customerService.getCustomerList();
        return customerList;
    }

//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
    public String delete(int id) {

        String result = customerService.customerDelete(id);
        return result;
    }

    public Customer editCustomer(int id) throws CloneNotSupportedException {

        try {
            customer = customerService.editCustomer(id);
//             sessionMap.put("editUser", customer);  

            deepcopy = (Customer) customer.clone();
            editDialog = true;
//        Customer copy = (Customer)((Customer)customer).clone();
        } catch (Exception e) {
            System.out.println(e);
        }

        return deepcopy;
    }

    public int updateCustomer(Customer customer) {
        int result = 0;
        try {
            result = customerService.updateCustomer(customer);
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }
}
