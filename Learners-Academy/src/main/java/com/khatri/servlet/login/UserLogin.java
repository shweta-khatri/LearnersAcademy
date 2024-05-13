package com.khatri.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		
		pw.print("<h1 style='color: green'>Welcome to Login Page</h1>");
		pw.print("<hr/>");
		pw.print("<form method='post'>");
		pw.print("Enter Name: <input type='text' name='username' /><br />");
		pw.print("Enter Password: <input type='password' name='password' /><br /><br />");
		pw.print("<input type='submit' formaction='adminlogin' method='post' value='Admin Login' />&nbsp;&nbsp;");
		pw.print("<input type='submit' formaction='studentlogin' method='post' value='Student Login' />&nbsp;&nbsp;");
		pw.print("<input type='submit' formaction='teacherlogin' method='post' value='Teacher Login' />");
		
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	

}
