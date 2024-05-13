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

public class ViewClassStudents extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();

			int id = Integer.parseInt(request.getParameter("id"));

			List<LearnersClass> classes = ClassDao.getLearnersClasses();
			pw.print("<h1 style='color: green'>Class : " + ClassDao.getClassById(id).getClassName() + "</h1>");
			pw.print("<hr/>");
			pw.print("<br><br>Student details fetched<br><br>");
			pw.print("<table border='1' width='100%'>");
			pw.print("<tr><th>Id</th><th>Student Name</th><th>Student Email</th></tr>");

			List<Student> students = ClassDao.getStudents(id);
			for (Student student : students) {
				pw.print("<tr><td>" + student.getId() + "</td><td>" + student.getName() + "</td><td>"
						+ student.getEmail() + "</td></tr>");
			}
			pw.print("</table>");

			pw.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		doGet(request, response);
//	}

}
