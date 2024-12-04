package com.studdao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studdao.entity.Student;

public class StudentDao_Implementation implements StudentDao
{
	 private static String driver_name = "com.mysql.cj.jdbc.Driver"; 
	 private static String url = "jdbc:mysql://127.0.0.1:3306/studentdbdao";
	 private static String username="root";
	 private static String password = "";
	 
	 private static Connection getConnection() throws ClassNotFoundException, SQLException
	 {
		 Class.forName(driver_name);
		 return DriverManager.getConnection(url, username, password);
		 
	 }
	 
	 public void saveStudent(Student student) 
	 {
		 try {
	
		  Connection con = getConnection();
		  con.setAutoCommit(false);
		  PreparedStatement pstmt = con.prepareStatement("insert into student_info(name,address,email,age) values(?,?,?,?)");
		  
		  pstmt.setString(1,student.getName());
		  pstmt.setString(2,student.getAddress());
		  pstmt.setString(3,student.getEmail());
		  pstmt.setInt(4,student.getAge());
		  
		  pstmt.executeUpdate();
		  System.out.println("Data Inserted!");
				
		  con.commit();
		 }
		 catch(ClassNotFoundException e)
		 {
			 System.out.println(e.getMessage());
			 
		 }
		 catch(SQLException e)
		 {
			 System.out.println(e.getMessage());
		 }
		 
	 }
	 
	 public void readStudent() 
	 {
        try 
        {
		   Connection con = getConnection();
		   con.setAutoCommit(false);
		   PreparedStatement pstmt = con.prepareStatement("select * from student_info");
		   ResultSet rs = pstmt.executeQuery();
        
		   while(rs.next())
		   {
			   System.out.println("Id :"+rs.getInt(1));
			   System.out.println("Name :"+rs.getString(2));
			   System.out.println("address:"+rs.getString(3));
			   System.out.println("email:"+rs.getString(4));
			   System.out.println("age :"+rs.getInt(5));
		   }
         con.commit();
        }
        catch(ClassNotFoundException e)
		 {
			 System.out.println(e.getMessage());
			 
		 }
		 catch(SQLException e)
		 {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 public void updateStudent(int id) 
	 {
		 try 
	        {
			   Connection con = getConnection();
			   con.setAutoCommit(false);
			   PreparedStatement pstmt = con.prepareStatement("update student_info set address = ? where id = ?");
			   pstmt.setString(1, "Ichalkaranji");
			   pstmt.setInt(2, id);
			   
			   pstmt.executeUpdate();
			   System.out.println("Data Updated!");
			   
	         con.commit();
	        }
	        catch(ClassNotFoundException e)
			 {
				 System.out.println(e.getMessage());
				 
			 }
			 catch(SQLException e)
			 {
				 System.out.println(e.getMessage());
			 } 
		 
	 }
	 public void deleteStudent(int id)
	 {
		 try 
	        {
			   Connection con = getConnection();
			   con.setAutoCommit(false);
			   PreparedStatement pstmt = con.prepareStatement("delete from student_info where id = ?");
			   pstmt.setInt(1, id);
			   
			   pstmt.executeUpdate();
			   System.out.println("Data Deleted!");
			   
	         con.commit();
	        }
	        catch(ClassNotFoundException e)
			 {
				 System.out.println(e.getMessage());
				 
			 }
			 catch(SQLException e)
			 {
				 System.out.println(e.getMessage());
			 } 
		 
	 }
	 
}
