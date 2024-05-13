package com.khatri.servlet.mods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.ClassDao;
import com.khatri.dao.SubjectDao;
import com.khatri.dao.TeacherDao;
import com.khatri.model.LearnersClass;
import com.khatri.model.Subject;
import com.khatri.model.Teacher;

public class Classes extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
			
		pw.print("<h1 style='color: green'>Hello Admin</h1>");
		pw.print("<hr/>");
		pw.print("<h2 style='color: green'>Classes</h1>");
		pw.print("<hr/>");
		pw.print("<form method='post'>");
		pw.print("<input type='submit' formaction='addclass' method='post' value='Add Class' />&nbsp;&nbsp;");
		pw.print("<input type='submit' formaction='viewclasses' method='get' value='View Classes' /><br/><br/>");
		pw.close();
		}
}
