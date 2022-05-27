package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GlobalState
 */
public class GlobalState extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalState() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>HelloWorld</title></head><body>");
//        Enumeration<String> names =request.getParameterNames();
//        while(names.hasMoreElements()) {
//            String parameterName=names.nextElement();
//            System.out.println(parameterName);
//            String [] values =request.getParameterValues(parameterName);
//            int length= values.length;
//            for(int i=0;i<length;i++)
//            {
//                System.out.println("Values : "+values[i]);
//            }
//        }
        String submitvalue = request.getParameter("submit");
        ServletContext ctx = this.getServletContext();// Get handle to servletContext maintained by tomcat server
        // System.out.println("value :" + submitvalue);
        if (submitvalue.equals("set")) {
            String salaryInput = request.getParameter("salary");
            this.getServletContext().setAttribute("globalSalary", salaryInput);
           // ctx.setAttribute("ctxsalary", salaryInput);// store data in servlet context for all users
            // ctx.setAttribute() stores the data in a collection using key and value.
            // ctxsalary=key,salaryInput=value.
            // System.out.println("Salary Input :" + salary);
            out.println("<h1>Value set</h1>" + salaryInput);
        } else if (submitvalue.equals("fetch")) {
            String applicationSalary = (String)this.getServletContext().getAttribute("ctxsalary");
            if (applicationSalary == null) {
                out.print("<h1>Salary CONTEXT NOT YET SET!!!</h1>");
            }
            // String sessionSalary=(String)session.getAttribute("salary");
            else {

                out.println("<h1>Value fetched</h1>" + applicationSalary);// returning value from session attributes
            }
        }
        out.println("<input type=\'hidden\' value=\'50000\' name=\'bonus\'/>");
        out.println("</body></html>");
    }
}