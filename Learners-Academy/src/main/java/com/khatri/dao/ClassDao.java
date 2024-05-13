package com.khatri.dao;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khatri.model.LearnersClass;
import com.khatri.model.Student;
import com.khatri.model.Subject;
import com.khatri.model.Teacher;

public class ClassDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learners_world", "root", "shweta");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static int save(LearnersClass c) {
		int status = 0;

		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select MAX(id) as maxId from LearnersClass");
			int existingMaxId = 0;
			if (rs.next())
				existingMaxId = rs.getInt("maxId");

			PreparedStatement ps = con.prepareStatement("insert into LearnersClass values(?,?,?,?)");

			ps.setInt(1, existingMaxId + 1);
			ps.setString(2, c.getClassName());
			ps.setInt(3, c.getSubject().getId());
			ps.setInt(4, c.getTeacher().getId());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	public static List<LearnersClass> getLearnersClasses() {
		List<LearnersClass> LearnersClasss = new ArrayList<LearnersClass>();

		try {

			Connection con = getConnection();
			Statement statement = con.createStatement();

			Statement statement2 = con.createStatement();

			Statement statement3 = con.createStatement();

			ResultSet rs = statement.executeQuery("select * from LearnersClass");
			while (rs.next()) {
				LearnersClass c = new LearnersClass();
				c.setId(rs.getInt(1));
				c.setClassName(rs.getString(2));

				ResultSet subRs = statement2
						.executeQuery("select * from Subject where id=" + rs.getInt("subjectId") + "");
				Subject sub = new Subject();
				while (subRs.next()) {
					sub.setId(subRs.getInt("id"));
					sub.setName(subRs.getString("name"));
				}

				ResultSet tchrRs = statement3
						.executeQuery("select * from Teacher where id=" + rs.getInt("teacherId") + "");
				Teacher tchr = new Teacher();
				while (tchrRs.next()) {
					tchr.setId(tchrRs.getInt("id"));
					tchr.setName(tchrRs.getString("name"));
					tchr.setEmail(tchrRs.getString("email"));
					tchr.setSalary(tchrRs.getInt("salary"));
				}
				c.setSubject(sub);
				c.setTeacher(tchr);
				LearnersClasss.add(c);
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return LearnersClasss;
	}

	public static LearnersClass getClassById(int id) {
		LearnersClass c = new LearnersClass();
		try {

			Connection con = getConnection();
			Statement statement = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select * from LearnersClass where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ResultSet subRs = statement.executeQuery("select * from Subject where id=" + rs.getInt(3));
				Subject sub = new Subject();
				sub.setId(rs.getInt(1));
				sub.setName(rs.getString(2));

				ResultSet tchrRs = statement.executeQuery("select * from Teacher where id=" + rs.getInt(4));
				Teacher tchr = new Teacher();
				tchr.setId(rs.getInt(1));
				tchr.setName(rs.getString(2));
				tchr.setSalary(rs.getInt(3));

				c.setId(rs.getInt(1));
				c.setClassName(rs.getString(2));
				c.setSubject(sub);
				c.setTeacher(tchr);
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return c;
	}

	public static LearnersClass getClassByName(String className) {
		LearnersClass c = new LearnersClass();
		try {

			Connection con = getConnection();
			Statement statement = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select * from LearnersClass where className=?");
			ps.setString(1, className);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ResultSet subRs = statement.executeQuery("select * from Subject where id=" + rs.getInt(3));
				Subject sub = new Subject();
				sub.setId(rs.getInt(1));
				sub.setName(rs.getString(2));

				ResultSet tchrRs = statement.executeQuery("select * from Teacher where id=" + rs.getInt(4));
				Teacher tchr = new Teacher();
				tchr.setId(rs.getInt(1));
				tchr.setName(rs.getString(2));
				tchr.setSalary(rs.getInt(3));

				c.setId(rs.getInt(1));
				c.setClassName(rs.getString(2));
				c.setSubject(sub);
				c.setTeacher(tchr);
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return c;
	}

	public static int updateClass(LearnersClass c) {
		int status = 0;

		try {
			Connection con = getConnection();

			PreparedStatement ps = con
					.prepareStatement("UPDATE LearnersClass SET className=? subjectId=?,teacherId=? WHERE id=?");

			ps.setInt(3, c.getId());
			ps.setString(1, c.getClassName());
			ps.setInt(1, c.getSubject().getId());
			ps.setInt(2, c.getTeacher().getId());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	public static int deleteClassById(int id) {
		int status = 0;
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE from LearnersClass where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	public static List<Student> getStudents(int classId) {
		LearnersClass c = new LearnersClass();
		List<Student> students = new ArrayList<>();
		try {

			Connection con = getConnection();
			Statement statement = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select * from Student_Class where classId=?");
			ps.setInt(1, classId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ResultSet studentRs = statement.executeQuery("select * from Student where id=" + rs.getInt(3));
				Student stud = new Student();
				while (studentRs.next()) {
					
					stud.setId(studentRs.getInt(1));
					stud.setName(studentRs.getString(2));
					stud.setEmail(studentRs.getString(3));
					stud.setPassword(studentRs.getString(4));
					stud.setAge(studentRs.getInt(5));
					stud.setCountry(studentRs.getString(6));
				}

				students.add(stud);
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return students;
	}

}
