/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImpl;

import com.dao.SupplierDao;
import com.pojo.Supplier;
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
public class SupplierDaoImpl implements SupplierDao {

    @Override
    public int saveSupplier(Supplier supplier) {
        int result = 0;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into supplier(name,tin,address,email,mobile) values(?,?,?,?,?)");
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getGsTin());
            stmt.setString(3, supplier.getAddress());
            stmt.setString(4, supplier.getEmail());
            stmt.setString(5, supplier.getMobile());
            result = stmt.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("insert employee details " + ex);
        }
        return result;
    }

    @Override
    public List<Supplier> getSupplierList() {
        List<Supplier> supplierList = new ArrayList<>();
        try {
            Connection connection = LoginDaoImpl.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from supplier");
            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setId(rs.getInt("id"));
                supplier.setName(rs.getString("name"));
                supplier.setGsTin(rs.getString("tin"));
                supplier.setAddress(rs.getString("address"));
                supplier.setEmail(rs.getString("email"));
                supplier.setMobile(rs.getString("mobile"));
                supplierList.add(supplier);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return supplierList;
    }

    @Override
    public String supplierdelete(int id) {
        String message = "fail";
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("delete from supplier where id = " + id);
            stmt.executeUpdate();
            message = "success";
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return message;
    }

    @Override
    public Supplier editSupplier(int id) {
        Supplier supplier = null;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from supplier where id = " + (id));
            rs.next();
            supplier = new Supplier();
            supplier.setId(rs.getInt("id"));
            supplier.setName(rs.getString("name"));
            supplier.setGsTin(rs.getString("tin"));
            supplier.setEmail(rs.getString("email"));
            supplier.setAddress(rs.getString("address"));
            supplier.setMobile(rs.getString("mobile"));
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return supplier;
    }

    @Override
    public int updateSuppllier(Supplier supplier) {
        int result = 0;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("update supplier set name=?,tin=?,address=?,email=?,mobile=? where id=?");

            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getGsTin());
            stmt.setString(3, supplier.getAddress());
            stmt.setString(4, supplier.getEmail());
            stmt.setString(5, supplier.getMobile());
            stmt.setInt(6, supplier.getId());

            result = stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

}
