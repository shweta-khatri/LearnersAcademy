package com.khatri.servlet.save;

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

public class SaveTeacher extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String salary = request.getParameter("salary");

		Teacher teacher = null;

		if (name != null && !name.equals("") && password != null && !password.equals("")) {
			teacher = new Teacher();
			teacher.setName(name);
			teacher.setEmail(email);
			teacher.setPassword(password);
			teacher.setSalary(Integer.parseInt(salary));
		}

		int status = TeacherDao.save(teacher);

		if (status > 0) {
			pw.print("<br><br><b>Record Saved Successfully!</b></br></br>");
			RequestDispatcher rd = request.getRequestDispatcher("viewteachers");
			rd.include(request, response);
		} else {
			pw.print("<br><br><b>Error Saving Teacher Details!</b></br></br>");
			RequestDispatcher rd = request.getRequestDispatcher("addteacher");
			rd.include(request, response);
		}

		pw.close();
	}
}
