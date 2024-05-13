package com.khatri.servlet.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khatri.dao.SubjectDao;
import com.khatri.model.Subject;

public class SaveSubject extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");

		Subject subject = null;

		if (name != null && !name.equals("")) {
			subject = new Subject();
			subject.setName(name);
		}

		int status = SubjectDao.save(subject);

		if (status > 0) {
			pw.print("<br><br><b>Record Saved Successfully!</b></br></br>");
			RequestDispatcher rd = request.getRequestDispatcher("viewsubjects");
			rd.include(request, response);
		} else {
			pw.print("<br><br><b>Error Saving Subject Details!</b></br></br>");
			RequestDispatcher rd = request.getRequestDispatcher("addsubject");
			rd.include(request, response);
		}

		pw.close();
	}
}
