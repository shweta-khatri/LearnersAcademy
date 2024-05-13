package com.khatri.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.SubjectDao;
import com.khatri.model.Subject;

public class ViewSubject extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		List<Subject> subjects = SubjectDao.getSubjects();
		pw.print("<br><br>Subject details fetched successfully<br><br>");
		pw.print("<table border='1' width='100%'>");
		pw.print("<tr><th>Id</th><th>Name</th><th colspan='2'>Edit/Delete</th></tr>");

		for (Subject subject : subjects) {
			pw.print(
					"<tr><td>" + subject.getId() + "</td><td>" + subject.getName() + "</td><td><a href='editsubject?id="
							+ subject.getId() + "'>Edit</a></td><td><a href='deletesubject?id=" + subject.getId()
							+ "'>Delete</a></td></tr>");
		}
		pw.print("</table>");
		pw.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
