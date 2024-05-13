package com.khatri.servlet.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		
		pw.print("<h1 style='color: green'>Hello Admin</h1>");
		pw.print("<hr/>");
		pw.print("<form method='post'>");
		pw.print("<input type='submit' formaction='teachers' method='post' value='Teachers' />&nbsp;&nbsp;");
		pw.print("<input type='submit' formaction='subjects' method='post' value='Subjects' />&nbsp;&nbsp;");
		pw.print("<input type='submit' formaction='classes' method='post' value='Classes' />&nbsp;&nbsp;");
		pw.print("<input type='submit' formaction='students' method='post' value='Students' /><br/><br/>");	
		pw.close();
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
