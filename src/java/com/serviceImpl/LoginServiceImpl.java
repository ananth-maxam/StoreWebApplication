/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceImpl;

import com.dao.LoginDao;
import com.daoImpl.LoginDaoImpl;

import com.service.LoginService;

/**
 *
 * @author Lenin Ananth
 */
public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao = new LoginDaoImpl();

   

    @Override
    public String loginCheck(String userName, String passWord) {
        String message = loginDao.loginCheck(userName, passWord);

        return message;
    }

}
