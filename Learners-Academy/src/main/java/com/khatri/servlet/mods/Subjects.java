package com.khatri.servlet.mods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.SubjectDao;
import com.khatri.model.Subject;

public class Subjects extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
			
		pw.print("<h1 style='color: green'>Hello Admin</h1>");
		pw.print("<hr/>");
		pw.print("<h2 style='color: green'>Subjects</h1>");
		pw.print("<hr/>");
		pw.print("<form method='post'>");
		pw.print("<input type='submit' formaction='addsubject' method='post' value='Add Subject' />&nbsp;&nbsp;");
		pw.print("<input type='submit' formaction='viewsubjects' method='get' value='View Subjects' /><br/><br/>");
		pw.close();
		}
}
