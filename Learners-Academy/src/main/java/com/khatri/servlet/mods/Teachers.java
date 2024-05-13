package com.khatri.servlet.mods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.StudentDao;
import com.khatri.dao.TeacherDao;
import com.khatri.model.Student;
import com.khatri.model.Teacher;

public class Teachers extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
			
		pw.print("<h1 style='color: green'>Hello Admin</h1>");
		pw.print("<hr/>");
		pw.print("<h2 style='color: green'>Teachers</h1>");
		pw.print("<hr/>");
		pw.print("<form method='post'>");
		pw.print("<input type='submit' formaction='addteacher' method='post' value='Add Teacher' />&nbsp;&nbsp;");
		pw.print("<input type='submit' formaction='viewteachers' method='get' value='View Teachers' /><br/><br/>");
		pw.close();
		}
}
