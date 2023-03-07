package com.distribuida.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaConexionJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//jdbc:sqlserver://localhost\\sqlexpress;database=DBFacturas;TrustServerCertificate=True;
		String jdbcURL="jdbc:sqlserver://localhost:1433;database=DBFacturas;trustServerCertificate=True";
		String user="user";
		String password="1234";
		
		try {
			
			System.out.println("Estableciendo conexión..." + jdbcURL);
			
			Connection connection = DriverManager.getConnection(jdbcURL,user,password);
			
			System.out.println("Conexión establecida!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
