/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImpl;

import com.dao.LoginDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenin Ananth
 */
public class LoginDaoImpl implements LoginDao {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "MySQL123$$");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    @Override
    public String loginCheck(String userName, String passWord) {
        String role = "";

        try {
            if (userName != null && passWord != null) {
                Connection connection = getConnection();
                String sql = "Select * from persons Where username='" + userName + "' and password='" + passWord + "'";
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    role = rs.getString("role");
                }
                connection.close();
            }else{
                role = "";
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return role;
    }

}
