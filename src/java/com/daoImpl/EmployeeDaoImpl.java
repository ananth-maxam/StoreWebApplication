/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImpl;

import com.dao.EmployeeDao;
import com.pojo.Employee;
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
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public int saveEmployee(Employee employee) {
        int result = 0;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into employee(name,address,email,mobile) values(?,?,?,?)");
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getAddress());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getMobileNumber());
            result = stmt.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("insert employee details " + ex);
        }
        return result;

    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Connection connection = LoginDaoImpl.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAddress(rs.getString("address"));
                emp.setEmail(rs.getString("email"));
                emp.setMobileNumber(rs.getString("mobile"));
                employeeList.add(emp);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return employeeList;
    }

    @Override
    public String employeedelete(int id) {
        String message = "fail";
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("delete from employee where id = " + id);
            stmt.executeUpdate();
            message = "success";
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return message;
    }

    @Override
    public Employee editEmployee(int id) {
        Employee employee = null;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee where id = " + (id));
            rs.next();
            employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setAddress(rs.getString("address"));
            employee.setMobileNumber(rs.getString("mobile"));
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return employee;
    }

    @Override
    public int updateEmployee(Employee employee) {
        int result = 0;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("update employee set name=?,address=?,email=?,mobile=? where id=?");

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getAddress());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getMobileNumber());
            stmt.setInt(5, employee.getId());

            result = stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

}
