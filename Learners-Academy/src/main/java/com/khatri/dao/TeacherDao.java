package com.khatri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khatri.model.Teacher;

public class TeacherDao {

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

	public static int save(Teacher t) {
		int status = 0;

		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select MAX(id) as maxId from Teacher");
			int existingMaxId = 0;
			if (rs.next())
				existingMaxId = rs.getInt("maxId");
				
			PreparedStatement ps = con.prepareStatement("insert into Teacher values(?,?,?,?,?)");

			ps.setInt(1, existingMaxId + 1);
			ps.setString(2, t.getName());
			ps.setString(3, t.getEmail());
			ps.setString(4, t.getPassword());
			ps.setInt(5, t.getSalary());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	public static List<Teacher> getTeachers() {
		List<Teacher> teachers = new ArrayList<Teacher>();

		try {

			Connection con = getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select * from Teacher");
			while (rs.next()) {
				Teacher t = new Teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setPassword(rs.getString(4));
				t.setSalary(rs.getInt(5));
				teachers.add(t);
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return teachers;
	}

	public static Teacher getTeacherById(int id) {
		Teacher t = new Teacher();
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Teacher where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setPassword(rs.getString(4));
				t.setSalary(rs.getInt(5));
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return t;
	}
	
	public static Teacher getTeacherByEmail(String email) {
		Teacher t = new Teacher();
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Teacher where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setPassword(rs.getString(4));
				t.setSalary(rs.getInt(5));
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return t;
	}

	public static int updateTeacher(Teacher t) {
		int status = 0;

		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("UPDATE Teacher SET name=?,email=?,password=?,salary=? WHERE id=?");

			ps.setInt(5, t.getId());
			ps.setString(1, t.getName());
			ps.setString(2, t.getEmail());
			ps.setString(3, t.getPassword());
			ps.setInt(4, t.getSalary());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public static int deleteTeacherById(int id) {
		int status = 0;
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE from Teacher where id=?");
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
