package com.adv.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jcraft.jsch.Session;

public class JDBC {
	
	public static Db db=new Db();
	public static Connection conn=db.driverCon();
	public static Session ses=db.session;
	
	
	public static void insert(String fName,String lName,String isbn,String title,int edition,int copyright){
		 
		try {
			String insert_query1="Insert into Authors(FirstName,LastName) values(?,?)";
			PreparedStatement ps1=conn.prepareStatement(insert_query1);
			ps1.setString(1,fName);
			ps1.setString(2, lName);
			ps1.execute();
			
			String insert_query2="Insert into Titles(ISBN,Title,EditionNumber,Copyright) values(?,?,?,?)";
			PreparedStatement ps2=conn.prepareStatement(insert_query2);
			ps2.setString(1, isbn);
			ps2.setString(2, title);
			ps2.setInt(3,edition);
			ps2.setInt(4, copyright);
			ps2.execute();
			
			String insert_query3="Insert into AuthorISBN(AutorID,ISBN) values((Select AuthorID from Authors where FirstName=? and LastName=?),?)";
			PreparedStatement ps3=conn.prepareStatement(insert_query3);
			ps3.setString(1,fName);
			ps3.setString(2,lName);
			ps3.setString(3, isbn);
			ps3.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void update(int authID,String fName,String lName,String isbn,String title,int edition,int copyright){
		
		try {
			String update_query1="update Authors set FirstName=?, LastName=? where AuthorID=?";
			PreparedStatement ps1=conn.prepareStatement(update_query1);
			ps1.setString(1,fName);
			ps1.setString(2, lName);
			ps1.setInt(3, authID);
			ps1.execute();
			
			ps1.execute("SET FOREIGN_KEY_CHECKS=0");
			String update_query2="update Titles set Title=?,ISBN=?,EditionNumber=?, Copyright=?  where ISBN=?";
			PreparedStatement ps2=conn.prepareStatement(update_query2);
			ps2.setString(1, title);
			ps2.setString(2,isbn);
			ps2.setInt(3,edition);
			ps2.setInt(4, copyright);
			ps2.setString(5, isbn);
			ps2.execute();
			
			String query_upd3="update AuthorISBN set ISBN=? where AuthorID=?";
			PreparedStatement ps3=conn.prepareStatement(query_upd3);
			ps3.setString(1,isbn);
			ps3.setInt(2,authID);
			ps3.execute();
			
			ps1.execute("SET FOREIGN_KEY_CHECKS=1");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(int authID,String isbn){
		try {
			String delete_query1="Delete from Authors where AuthorID=?";
			PreparedStatement ps1=conn.prepareStatement(delete_query1);
			ps1.setInt(1, authID);
			ps1.execute();
			
			String delete_query2="Delete from Titles where ISBN=?";
			PreparedStatement ps2=conn.prepareStatement(delete_query2);
			ps2.setString(1, isbn);
			ps2.execute();
			
			String delete_query3="Delete from AuthorISBN where AuthorID=?";
			PreparedStatement ps3=conn.prepareStatement(delete_query3);
			ps2.setInt(1, authID);
			ps2.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
