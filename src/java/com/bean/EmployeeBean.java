/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.pojo.Employee;
import com.service.EmployeeService;
import com.serviceImpl.EmployeeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Lenin Ananth
 */
@ManagedBean(name = "employeebean")
public class EmployeeBean {

    private Employee employee = new Employee();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private List<Employee> employeeList = new ArrayList<>();
    private Employee deepCopy = new Employee();

    public Employee getDeepCopy() {
        return deepCopy;
    }

    public void setDeepCopy(Employee deepCopy) {
        this.deepCopy = deepCopy;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int saveEmployee() {
        int result = 0;
        result = employeeService.saveEmployee(employee);

        return result;
    }

    public List<Employee> getEmployeeList() {

        employeeList = employeeService.getEmployeeList();

        return employeeList;
    }

    public String employeedelete(int id) {

        String result = employeeService.employeedelete(id);
        return result;
    }
    
    public Employee editEmployee(int id) throws CloneNotSupportedException {

        try {
            employee = employeeService.editEmployee(id);
            deepCopy = (Employee) employee.clone();
        } catch (Exception e) {
            System.out.println(e);
        }

        return deepCopy;
    }

    public int updateEmployee(Employee employee) {
        int result = 0;
        try {
            result = employeeService.updateEmployee(employee);
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }
}
