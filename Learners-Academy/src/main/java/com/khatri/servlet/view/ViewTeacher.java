package com.khatri.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.TeacherDao;
import com.khatri.model.Teacher;

public class ViewTeacher extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		List<Teacher> teachers = TeacherDao.getTeachers();
		pw.print("<br><br>Teacher details fetched successfully<br><br>");
		pw.print("<table border='1' width='100%'>");
		pw.print(
				"<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Salary</th><th  colspan='2'>Edit/Delete</th></tr>");

		for (Teacher teacher : teachers) {
			pw.print("<tr><td>" + teacher.getId() + "</td><td>" + teacher.getName() + "</td><td>"
					+ teacher.getPassword() + "</td><td>" + teacher.getEmail() + "</td><td>" + teacher.getSalary()
					+ "</td><td><a href='editteacher?id=" + teacher.getId()
					+ "'>Edit</a></td><td><a href='deleteteacher?id=" + teacher.getId()
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
