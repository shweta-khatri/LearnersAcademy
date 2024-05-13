package com.khatri.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

public class AddLearnersClass extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		
		pw.print("<h1 style='color: green'>Add New Class<h1/>");
		pw.print("<hr/>");
		pw.print("<form action='saveclass' method = 'post'>");
		pw.print("<table>");
		pw.print("<tr><td>Class Name:</td><td><input type='text' name='className'></td></tr>");
		pw.print("<tr><td>Subject:</td><td><select name='subject' style='width:200px'>");
		List<Subject> subjects = SubjectDao.getSubjects();
		for(Subject sub : subjects) {
			pw.print("<option>" + sub.getName() + "</option>");
		}
		pw.print("</select></td></tr>");
		pw.print("<tr><td>Teacher:</td><td><select name='teacher' style='width:200px'>");
		List<Teacher> teachers = TeacherDao.getTeachers();
		for(Teacher t : teachers) {
			pw.print("<option>" + t.getEmail() + "</option>");
		}
		pw.print("</select></td></tr>");
		pw.print("<tr><td colspan='2'><input type='submit' value='Save Class Details'></td></tr>");		
		pw.print("</table>");
		pw.print("</form>");
		
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	

}
