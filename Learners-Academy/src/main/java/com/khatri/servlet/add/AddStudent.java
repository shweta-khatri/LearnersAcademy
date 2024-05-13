package com.khatri.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.ClassDao;
import com.khatri.model.LearnersClass;

public class AddStudent extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		
		pw.print("<h1 style='color: green'>Add New Student Details<h1/>");
		pw.print("<hr/>");
		pw.print("<form action='savestudent' method = 'post'>");
		pw.print("<table>");
		pw.print("<tr><td>Name:</td><td><input type='text' name='name'></td></tr>");
		pw.print("<tr><td>Email:</td><td><input type='email' name='email'></td></tr>");
		pw.print("<tr><td>Password:</td><td><input type='password' name='password'></td></tr>");
		pw.print("<tr><td>Age:</td><td><input type='text' name='age'></td></tr>");
		pw.print("<tr><td>Country:</td><td><select name='country' style='width:200px'>");
		pw.print("<option>INDIA</option>");
		pw.print("<option>USA</option>");
		pw.print("<option>UK</option>\r\n");
		pw.print("<option>ARGENTINA</option>\r\n");
		pw.print("<option>Other</option>\r\n");
		pw.print("</select></td></tr>");
		pw.print("<tr><td>Class:</td><td><select name='class' style='width:200px'>");
		List<LearnersClass> classes = ClassDao.getLearnersClasses();
		for(LearnersClass lClass : classes) {
			pw.print("<option>" + lClass.getClassName() + "</option>");
		}
		pw.print("</select></td></tr>");
		pw.print("<tr><td colspan='2'><input type='submit' value='Save Student Details'></td></tr>");		
		pw.print("</table>");
		pw.print("</form>");
		
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	



}
