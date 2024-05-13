package com.khatri.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.LoginDao;

public class StudentLogin  extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		String email = request.getParameter("username");
		String password = request.getParameter("password");

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		
		if(LoginDao.checkUser("Student",email)==0){
			pw.println("<h1 style='color: red'>Username or Password is incorrect. Please try again!!!<h1/>");
			RequestDispatcher rd = request.getRequestDispatcher("userlogin");
			rd.include(request, response);
		}
		
		String pwd = LoginDao.getUserPassword("Student",email);

		if(pwd!=null && pwd.equals(password)) {
			pw.println("<h1> Username and Password is correct<h1/>");
			RequestDispatcher rd = request.getRequestDispatcher("studentpage");
			rd.forward(request, response);
		}
		else {
			pw.println("<h1 style='color: red'>Username or Password is incorrect<h1/>");
			RequestDispatcher rd = request.getRequestDispatcher("userlogin");
			rd.include(request, response);
		}
		pw.close();

	}
	

}
