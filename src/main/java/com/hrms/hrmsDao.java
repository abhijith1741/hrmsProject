package com.hrms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.hrms.leave.leaveFetch;
import com.hrms.salary.salaryDisplayUser;

public class hrmsDao {
	
	public boolean validate(loginBean log) {
		
		boolean status = false;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "select * from users where userName = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, log.getUsername());
			pstmt.setString(2, log.getPassword());
			System.out.println(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return status; 
	}
	
	public int register(registerBean regs) {
		int result = 0;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "insert into users(userName,email,mobile,password)values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, regs.getName());
			pstmt.setString(2, regs.getEmail());
			pstmt.setString(3, regs.getMobile());
			pstmt.setString(4, regs.getPassword());
			System.out.println(pstmt);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean update(updateBean up, int id) {
		boolean result = false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String i = "select * from users";
			String q = "update users set userName = ?, password = ? where id = ? ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(i);
			while(rs.next()) {
				id = rs.getInt(1);
			}
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, up.getUsername());
			pstmt.setString(2, up.getPassword());
			pstmt.setInt(3, id);
			
			System.out.println(pstmt);
			
			result = pstmt.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int applied(String name, Integer id, String email, String mobile,String reason) {
		
		int result = 0;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String i = "select * from users ";
			String q = "insert into applied(name,empId,email,mobile,reason)values(?,?,?,?,?)";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(i);	
			while(rs.next()) {
				id = rs.getInt(1);
			}
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.setString(3, email);
			pstmt.setString(4, mobile);
			pstmt.setString(5, reason);
			
			
			
			System.out.println(pstmt);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
//	public String get(String name) {
//		String email = null;
//		ResultSet rs = null;
//		
//		
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/hrms";
//			String username = "root";
//			String password = "1741";
//			Connection con = DriverManager.getConnection(url, username, password );
//			String q = "select * from users where userName = ?";
//			PreparedStatement pstmt = con.prepareStatement(q);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				email = rs.getString(3);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return email;
//	}
	public List<userDetailsBean> get(String name) {
		String email = null;
		ResultSet rs = null;
		List<userDetailsBean> users = new ArrayList<userDetailsBean>();
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "select * from users where userName = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userDetailsBean user = new userDetailsBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("userName"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return users;
	}			
	public Boolean admin_validate(adminBean ad) {
		
		Boolean status = false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "select * from admin where name = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, ad.getName());
			pstmt.setString(2, ad.getPassword());
			System.out.println(pstmt);
			ResultSet rs =  pstmt.executeQuery();
			status = rs.next();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public List<displayEmployee> userFetch() {
		List<displayEmployee> users = new ArrayList<displayEmployee>();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "select * from users";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next()) {
				 displayEmployee user = new displayEmployee();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("userName"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setCreated(rs.getString("created"));
				users.add(user);			
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public String salary(String id) {
		
		String name = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "select * from users where id = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, id);
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
				name = rs.getString(2);
			}
			System.out.println(name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public int addSalary(String id, String name, String salary) {
		
			int result = 0;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "insert into salary(name,empId,salary)values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, salary);
			result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<salaryDisplayUser> showSalary() {
		Integer id = null;
		List<salaryDisplayUser> users = new ArrayList<salaryDisplayUser>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "select * from salary where empId = ? ";
			String i = "select * from users";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(i);
			while(rs.next()) {
				id = rs.getInt(1);
			}
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, id);
			ResultSet rss = pstmt.executeQuery();
			while(rss.next()) {
				salaryDisplayUser user = new salaryDisplayUser();
				user.setNo(rss.getString("no"));
				user.setName(rss.getString("name"));
				user.setEmpId(rss.getString("empId"));
				user.setSalary(rss.getString("salary"));
				user.setDate(rss.getString("date"));
				users.add(user);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public List<leaveFetch> leaveDisplay() {
		List<leaveFetch> users = new ArrayList<leaveFetch>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "select * from applied";
			PreparedStatement pstmt = con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				leaveFetch user = new leaveFetch();
				user.setNo(rs.getString("No"));
				user.setName(rs.getString("name"));
				user.setEmpId(rs.getString("empId"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setReason(rs.getString("reason"));
				user.setCreated(rs.getString("created"));
				users.add(user);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	public int addAdmin(String name, String email, String mobile, String pass) {
		int rs = 0;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrms";
			String username = "root";
			String password = "1741";
			Connection con = DriverManager.getConnection(url, username, password );
			String q = "insert into admin(name,email,mobile,password)values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, mobile);
			pstmt.setString(4, pass);
			rs =  pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}


