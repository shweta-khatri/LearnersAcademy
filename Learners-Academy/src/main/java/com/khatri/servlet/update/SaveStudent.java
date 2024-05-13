package com.khatri.servlet.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.ClassDao;
import com.khatri.dao.StudentDao;
import com.khatri.model.Student;

public class SaveStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String country = request.getParameter("country");
		String lClass = request.getParameter("class");

		Student stud = null;

		if (name != null && !name.equals("") && password != null && !password.equals("")) {
			stud = new Student();
			stud.setName(name);
			stud.setEmail(email);
			stud.setPassword(password);
			stud.setAge(Integer.parseInt(age));
			stud.setCountry(country);
		}

		int status = StudentDao.save(stud);
		int studId = StudentDao.getStudentByEmail(email).getId();
		int classId = ClassDao.getClassByName(lClass).getId();
		
		StudentDao.saveClassStudent(status, studId);
		

		if (status > 0) {
			pw.print("<br><br><b>Record Saved Successfully!</b></br></br>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		} else {
			pw.print("<br><br><b>Error Saving Student Details!</b></br></br>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}

		pw.close();
	}
}
