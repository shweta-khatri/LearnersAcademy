package com.khatri.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.ClassDao;
import com.khatri.model.LearnersClass;
import com.khatri.model.Student;

public class ViewClass extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		List<LearnersClass> classes = ClassDao.getLearnersClasses();
		pw.print("<br><br>Class details fetched successfully<br><br>");
		pw.print("<table border='1' width='100%'>");
		pw.print(
				"<tr><th>Id</th><th>Class Name</th><th>Subject Name</th><th>Teacher's EmailId</th><th>Students</th></tr>");

		for (LearnersClass lClass : classes) {
			pw.print("<tr><td>" + lClass.getId() + "</td><td>" + lClass.getClassName() + "</td><td>"
					+ lClass.getSubject().getName() + "</td><td>" + lClass.getTeacher().getEmail()
					+ "</td><td><a href='viewclassstudents?id=" + lClass.getId() + "'>View Class Students</a></td></tr>");
		}
		pw.print("</table>");

		pw.close();

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
