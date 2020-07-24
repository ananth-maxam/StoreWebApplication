/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Employee;
import java.util.List;

/**
 *
 * @author Lenin Ananth
 */
public interface EmployeeDao {
    
    public int saveEmployee(Employee employee);
    
    public List<Employee> getEmployeeList();
    
    public String employeedelete(int id);
    
    public Employee editEmployee(int id);
    
    public int updateEmployee(Employee employee);
    
    
    
}
