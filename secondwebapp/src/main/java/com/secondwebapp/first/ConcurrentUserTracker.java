package com.secondwebapp.first;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ConcurrentUserTracker implements HttpSessionListener {
		  static int users = 0;

		  public void sessionCreated(HttpSessionEvent e) {
		    ++users;
		    System.out.println("new session is created");
		  }
		  public void sessionDestroyed(HttpSessionEvent e) {
		    ++users;
		    System.out.println("session is created destroyed");
		  }
		  public static int getConcurrentUsers() {
		    return users;
		  }
		}

