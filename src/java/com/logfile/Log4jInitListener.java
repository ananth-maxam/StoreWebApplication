/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logfile;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.BasicConfigurator;

import org.apache.log4j.xml.DOMConfigurator;

@WebListener
public final class Log4jInitListener implements ServletContextListener {

    public Log4jInitListener() {
    }

    public void contextDestroyed(ServletContextEvent paramServletContextEvent)  { 
    }

    public void contextInitialized(ServletContextEvent servletContext)  { 
    	String webAppPath = servletContext.getServletContext().getRealPath("/");
	String log4jFilePath = webAppPath + "WEB-INF\\log4j.properties";
    	DOMConfigurator.configure(log4jFilePath);
        BasicConfigurator.configure();
    	System.out.println("initialized log4j configuration from file:"+log4jFilePath);
    }
	
}

