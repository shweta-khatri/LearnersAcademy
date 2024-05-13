package com.khatri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khatri.model.Student;

public class StudentDao {
	
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

	public static int save(Student s) {
		int status = 0;

		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select MAX(id) as maxId from Student");
			int existingMaxId = 0;
			if (rs.next())
				existingMaxId = rs.getInt("maxId");
				
			PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?,?,?,?)");

			ps.setInt(1, existingMaxId + 1);
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setInt(5, s.getAge());
			ps.setString(6, s.getCountry());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public static int saveClassStudent(int classId, int studentId) {
		int status = 0;

		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select MAX(id) as maxId from Student_Class");
			int existingMaxId = 0;
			if (rs.next())
				existingMaxId = rs.getInt("maxId");
				
			PreparedStatement ps = con.prepareStatement("insert into Student_Class values(?,?,?)");

			ps.setInt(1, existingMaxId + 1);
			ps.setInt(2, classId);
			ps.setInt(3, studentId);

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public static String getLearnersClass(int studentId) {
		
		String className = null;

		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();
			int classid=0;
			ResultSet rs = statement.executeQuery("select classId from Student_Class where studentId=" + studentId);
			if (rs.next())
				classid = rs.getInt("classId");
			
			ResultSet rs2 = statement.executeQuery("select className from learnersclass where id=" + classid);
			if (rs2.next())
				className = rs2.getString("className");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return className;
	}

	public static List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();

		try {

			Connection con = getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select * from Student");
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setAge(rs.getInt(5));
				s.setCountry(rs.getString(6));
				students.add(s);
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return students;
	}

	public static Student getStudentById(int id) {
		Student s = new Student();
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setAge(rs.getInt(5));
				s.setCountry(rs.getString(6));
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s;
	}

	public static Student getStudentByEmail(String email) {
		Student s = new Student();
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Student where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setAge(rs.getInt(5));
				s.setCountry(rs.getString(6));
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s;
	}
	
	public static int updateStudent(Student s) {
		int status = 0;

		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("UPDATE Student SET name=?,email=?,password=?,country=? WHERE id=?");

			ps.setInt(5, s.getId());
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getCountry());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public static int deleteStudentById(int id) {
		int status = 0;
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE from Student where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	
}
