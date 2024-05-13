package com.khatri.servlet.update;

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

public class EditClass extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		String className = request.getParameter("className");
		String subjectName = request.getParameter("subject");
		String teacherEmail = request.getParameter("teacher");

		LearnersClass lClass = null;

		if (subjectName != null && !subjectName.equals("") && teacherEmail != null && !teacherEmail.equals("")) {
			lClass = new LearnersClass();

			Teacher teacher = TeacherDao.getTeacherByEmail(teacherEmail);

			Subject subject = SubjectDao.getSubjectByName(subjectName);
			lClass.setClassName(className);
			lClass.setSubject(subject);
			lClass.setTeacher(teacher);
			
		}

		int status = ClassDao.save(lClass);

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
