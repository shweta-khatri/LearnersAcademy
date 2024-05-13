package com.khatri.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSubject extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		
		pw.print("<h1 style='color: green'>Add New Subject<h1/>");
		pw.print("<hr/>");
		pw.print("<form action='savesubject' method = 'post'>");
		pw.print("<table>");
		pw.print("<tr><td>Name:</td><td><input type='text' name='name'></td></tr>");
		pw.print("<tr><td colspan='2'><input type='submit' value='Save Subject'></td></tr>");		
		pw.print("</table>");
		pw.print("</form>");
		
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	

}
