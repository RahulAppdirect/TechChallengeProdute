package com.produte.dao;

import java.sql.Connection;

public interface ConectionFactory {
	
	public static final String URL = "jdbc:mysql://localhost:3306/TechChallenge";
    public static final String USER = "root";
    public static final String PASSWORD = "password01";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    
    public Connection getConnection();

}
