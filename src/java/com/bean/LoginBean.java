/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.pojo.StoreDetails;
import com.pojo.User;
import com.service.LoginService;
import com.service.StoreService;
import com.serviceImpl.LoginServiceImpl;
import com.serviceImpl.StoreServiceImpl;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.catalina.manager.util.SessionUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author Lenin Ananth
 */
@ManagedBean(name = "loginbean")
@SessionScoped
@RequestScoped
public class LoginBean {
    
    private static final Logger logger = Logger.getLogger(LoginBean.class);

    private User user = new User();
    private String role = "";
    private StoreDetails storeDetails = new StoreDetails();
    private LoginService loginService = new LoginServiceImpl();
    private StoreService storeService = new StoreServiceImpl();

    public StoreDetails getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(StoreDetails storeDetails) {
        this.storeDetails = storeDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String loginCheck() throws CloneNotSupportedException{

        boolean valid = checkLogin();
        if (valid) {
//            HttpSession session = SessionUtils.getSession();
//            session.setAttribute("username", user);
            return "response";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "index";
        }

    }

    public boolean checkLogin() throws CloneNotSupportedException {
        String message = loginService.loginCheck(user.getUserName(), user.getPassword());
        StoreBean storebean = new StoreBean();
        storeDetails = storebean.editStore();
        role = message;
        logger.info("============================== role value is " +role);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("role", role);
        if (message.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public StoreDetails getStore() {

        try {
            storeDetails = storeService.editStore();
            logger.info("loggin successfully");
        } catch (Exception e) {
            System.out.println(e);
            logger.info("login exception " +e);
        }
        return storeDetails;
    }

    
    public String logout(){
        
        return "index";
    }
}
