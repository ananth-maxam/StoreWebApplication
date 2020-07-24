/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImpl;

import com.dao.StoreDao;
import com.pojo.Customer;
import com.pojo.StoreDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenin Ananth
 */
public class StoreDaoImpl implements StoreDao {

    @Override
    public int addStoreDetails(StoreDetails storeDetails) {
        int result = 0;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            PreparedStatement stmt = connection.prepareStatement("update storedetails set storeName=?,address=?,tinNumber=?,emailId=?,mobileNumber=? where id=?");
            stmt.setString(1, storeDetails.getStoreName());
            stmt.setString(2, storeDetails.getAddress());
            stmt.setString(3, storeDetails.getTinNumber());
            stmt.setString(4, storeDetails.getEmailId());
            stmt.setString(5, storeDetails.getMobileNumber());
            stmt.setInt(6, 1);
            result = stmt.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("insert store details " + ex);
        }
        return result;
    }

    @Override
    public StoreDetails editStore() {

        StoreDetails storeDetails = null;
        try {
            Connection connection = LoginDaoImpl.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from storedetails where id = 1");
            rs.next();
            storeDetails = new StoreDetails();
            storeDetails.setId(rs.getInt("id"));
            storeDetails.setStoreName(rs.getString("storeName"));
            storeDetails.setEmailId(rs.getString("emailId"));
            storeDetails.setAddress(rs.getString("address"));
            storeDetails.setMobileNumber(rs.getString("mobileNumber"));
            storeDetails.setTinNumber(rs.getString("tinNumber"));
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return storeDetails;

    }

}
