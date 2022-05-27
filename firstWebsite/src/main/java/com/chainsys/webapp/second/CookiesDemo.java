package com.chainsys.webapp.second;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookiesDemo
 */
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        Cookie [] allCookies =request.getCookies();
        if(allCookies==null)
        {
            System.out.println("no cookies found !!!");
            // Use log manager and log message instead of System.out.println
            return;
        }
        int cookielength=allCookies.length;
        for (int i=0;i<cookielength;i++){
            System.out.println(allCookies[i].getName()+"-"+allCookies[i].getValue());
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();
        Cookie firstCookie = new Cookie ("Captain" , "Kohli");
        firstCookie.setMaxAge(-1);
        
        //If value is zero or less than zero than cookie will get deleted immediately after the execution.
        // If the value is positive than the cookie will expire after the specific seconds.(in seconds)
        response.addCookie(firstCookie);
        Cookie secondCookie = new Cookie ("Keeper" , "Dhoni");
        // Life set for two days
        secondCookie.setMaxAge(22460*60);
        response.addCookie(secondCookie);
        Cookie thirdCookie = new Cookie ("AllRounder" , "Duplessie");
        response.addCookie(thirdCookie);
        
    }

}