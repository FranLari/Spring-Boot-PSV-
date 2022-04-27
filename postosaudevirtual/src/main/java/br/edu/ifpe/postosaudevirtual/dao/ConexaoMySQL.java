package br.edu.ifpe.postosaudevirtual.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static Connection getConexaoMySQL() throws SQLException, ClassNotFoundException {
		Connection connection = null; 
		Class.forName("com.mysql.jdbc.Driver");	
		connection = DriverManager.getConnection("jdbc:mysql://localhost/pvs_bd_postosaudevirtual","root","");
		return connection;
	}
}
