package com.khatri.servlet.mods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Students extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
			
		pw.print("<h1 style='color: green'>Hello Admin</h1>");
		pw.print("<hr/>");
		pw.print("<h2 style='color: green'>Students</h1>");
		pw.print("<hr/>");
		pw.print("<form method='post'>");
		pw.print("<input type='submit' formaction='addstudent' method='post' value='Add Student' /><br/><br/>");
		pw.print("<input type='submit' formaction='viewstudents' method='get' value='View Students' />");		
		pw.close();
		}
}
