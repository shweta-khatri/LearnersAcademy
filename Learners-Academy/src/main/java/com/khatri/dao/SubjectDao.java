package com.khatri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khatri.model.Subject;

public class SubjectDao {

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

	public static int save(Subject s) {
		int status = 0;

		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select MAX(id) as maxId from Subject");
			int existingMaxId = 0;
			if (rs.next())
				existingMaxId = rs.getInt("maxId");
				
			PreparedStatement ps = con.prepareStatement("insert into Subject values(?,?)");

			ps.setInt(1, existingMaxId + 1);
			ps.setString(2, s.getName());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	public static List<Subject> getSubjects() {
		List<Subject> subjects = new ArrayList<Subject>();

		try {

			Connection con = getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select * from Subject");
			while (rs.next()) {
				Subject s = new Subject();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				subjects.add(s);
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return subjects;
	}

	public static Subject getSubjectById(int id) {
		Subject s = new Subject();
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Subject where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s;
	}
	
	public static Subject getSubjectByName(String name) {
		Subject s = new Subject();
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Subject where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
			}

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s;
	}

	public static int updateSubject(Subject s) {
		int status = 0;

		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();

			PreparedStatement ps = con.prepareStatement("UPDATE Subject SET name=? WHERE id=?");

			ps.setInt(5, s.getId());
			ps.setString(1, s.getName());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public static int deleteSubjectById(int id) {
		int status = 0;
		try {

			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE from Subject where id=?");
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
