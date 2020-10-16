package com.adv.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Db {
	public static String jumpserverHost = "playground.bradley.edu";
	public static String jumpserverUsername = "ngade";
	public static String databaseUsername = "s_ngade";
	public static String databasePassword = "Dhaya@2229";
	public static Connection con = null;
	public static Session session = null;
	
	public static Connection driverCon(){
		JSch jsch = new JSch();
		//Session session = null;
		try {
			session = jsch.getSession(jumpserverUsername, jumpserverHost,22);
			java.util.Properties config = new java.util.Properties() ;
			config.put("StrictHostKeyChecking", "no") ;
			session.setConfig(config);
			session.setPassword("Akhil@2229");
			session.connect();
			System.out.println("connected");
			System.out.println(session.getHost());
			int forwardedPort = session.setPortForwardingL(0,"127.0.0.1", 3306);
			System.out.println(forwardedPort);
			System.out.println(session.getUserName());
			String url = "jdbc:mysql://localhost:"+ forwardedPort+"/s_ngade?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
			try {
				con = DriverManager.getConnection(url, databaseUsername, databasePassword);
				System.out.println(con);
				return con;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (JSchException e1) {
			
			e1.printStackTrace();
		}
		return con;
		
	}
	
	public static void closeCon(){
		
		try {
			session.disconnect();
			System.out.println("Session Disconnected"+session.getHost());
			con.close();
			System.out.println("Disconnected from server succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
