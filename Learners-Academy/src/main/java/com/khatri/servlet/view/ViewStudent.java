package com.khatri.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.StudentDao;
import com.khatri.model.Student;

public class ViewStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		List<Student> students = StudentDao.getStudents();
		pw.print("<br><br>Student details fetched successfully<br><br>");
		pw.print("<table border='1' width='100%'>");
		pw.print(
				"<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Age</th><th>Country</th><th>Class</th><th  colspan='2'>Edit/Delete</th></tr>");

		for (Student student : students) {
			String className = StudentDao.getLearnersClass(student.getId());
			pw.print("<tr><td>" + student.getId() + "</td><td>" + student.getName() + "</td><td>"
					+ student.getPassword() + "</td><td>" + student.getEmail() + "</td><td>" + student.getAge()
					+ "</td><td>" + student.getCountry() + "</td><td>" + className + "</td><td><a href='editstudent?id=" + student.getId()
					+ "'>Edit</a></td><td><a href='deletestudent?id=" + student.getId()
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
