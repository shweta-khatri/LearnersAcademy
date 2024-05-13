package com.khatri.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTeacher extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		
		pw.print("<h1 style='color: green'>Add New Teacher Details<h1/>");
		pw.print("<hr/>");
		pw.print("<form action='saveteacher' method = 'post'>");
		pw.print("<table>");
		pw.print("<tr><td>Name:</td><td><input type='text' name='name'></td></tr>");
		pw.print("<tr><td>Email:</td><td><input type='email' name='email'></td></tr>");
		pw.print("<tr><td>Password:</td><td><input type='password' name='password'></td></tr>");
		pw.print("<tr><td>Salary:</td><td><input type='text' name='salary'></td></tr>");
		pw.print("<tr><td colspan='2'><input type='submit' value='Save Teacher Details'></td></tr>");		
		pw.print("</table>");
		pw.print("</form>");
		
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	

}
