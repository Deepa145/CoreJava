package com.secondwebapp.first;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Environment implements ServletContextListener {
		  static String env = null;

		  public void contextInitialized(ServletContextEvent e) {
		    env = "Environment is ready to provide service";
		    System.out.println(env);
		  }
		  public void contextDestroyed(ServletContextEvent e) {
		    env = "Sorry, Environment is not ready to provide service";
		    System.out.println(env);
		  }
		  public static String getStatus() {
		    return env;
		  }
		}


