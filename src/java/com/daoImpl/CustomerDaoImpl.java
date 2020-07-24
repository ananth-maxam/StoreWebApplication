/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImpl;

import com.dao.CustomerDao;
import com.pojo.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenin Ananth
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public int saveCustomer(Customer customer) {
        int result = 0;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into customer(name,address,email,mobile) values(?,?,?,?)");
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getMobile());
            result = stmt.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("insert customer details " + ex);
        }
        return result;
    }

    @Override
    public List<Customer> getCustomerList() {
        List<Customer> custoemrList = new ArrayList<>();
        try {
            Connection connection = LoginDaoImpl.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setMobile(rs.getString("mobile"));
                custoemrList.add(customer);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return custoemrList;
    }

    @Override
    public String customerDelete(int id) {
        String message = "fail";
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("delete from customer where id = " + id);
            stmt.executeUpdate();
            message = "success";
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return message;
    }

    @Override
    public Customer editCustomer(int id) {
        Customer customer = null;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer where id = " + (id));
            rs.next();
            customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setEmail(rs.getString("email"));
            customer.setAddress(rs.getString("address"));
            customer.setMobile(rs.getString("mobile"));
            //sessionMap.put("editUser", user);
            connection.close();
            System.out.println(customer);
        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    @Override
    public int updateCustomer(Customer customer) {
        int result = 0;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("update customer set name=?,address=?,email=?,mobile=? where id=?");

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getMobile());
            stmt.setInt(5, customer.getId());

            result = stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

}
