/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceImpl;

import com.dao.EmployeeDao;
import com.daoImpl.EmployeeDaoImpl;
import com.pojo.Employee;
import com.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenin Ananth
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public int saveEmployee(Employee employee) {

        int result = employeeDao.saveEmployee(employee);

        return result;
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList = employeeDao.getEmployeeList();
        return employeeList;
    }

    @Override
    public String employeedelete(int id) {
        String message = employeeDao.employeedelete(id);
        return message;
    }

    @Override
    public Employee editEmployee(int id) {

        Employee employee = employeeDao.editEmployee(id);

        return employee;
    }

    @Override
    public int updateEmployee(Employee employee) {
        int result = employeeDao.updateEmployee(employee);
        return result;
    }

}
