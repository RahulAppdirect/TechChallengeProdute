package com.produte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateTable {
	Connection con = new ConnectionFactoryImpl().getConnection();
	public void createTableCreator()
	{
		try{
		PreparedStatement ps = con.prepareStatement("Create table Creator(accountIdentifier varchar(100) NOT NULL DEFAULT '',uuid varchar(100) DEFAULT NULL, openId varchar(100) DEFAULT NULL,email varchar(100) DEFAULT NULL,firstName varchar(100) DEFAULT NULL,lastName varchar(100) DEFAULT NULL,language varchar(100) DEFAULT NULL,locale varchar(100) DEFAULT NULL,city varchar(100) DEFAULT NULL,country varchar(100) DEFAULT NULL,phone varchar(100) DEFAULT NULL,state varchar(100) DEFAULT NULL,street1 varchar(100) DEFAULT NULL,zip varchar(100) DEFAULT NULL),PRIMARY KEY (accountIdentifier)");
		ps.execute();
		System.out.println("Creator table created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void createTableCompany()
	{
		try{
		PreparedStatement ps = con.prepareStatement("Create table Company(accountIdentifier varchar(100) NOT NULL DEFAULT '',uuid varchar(100) DEFAULT NULL, name varchar(100) DEFAULT NULL,email varchar(100) DEFAULT NULL,phoneNumber varchar(100) DEFAULT NULL,website varchar(100) DEFAULT NULL,country varchar(100) DEFAULT NULL,PRIMARY KEY (accountIdentifier)");
		ps.execute();
		System.out.println("Company table created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void createTableOrder()
	{
		try{
			PreparedStatement ps = con.prepareStatement("Create table Order1(accountIdentifier varchar(100) NOT NULL DEFAULT '',editionCode varchar(100) DEFAULT NULL,pricingDuration varchar(100) DEFAULT NULL,PRIMARY KEY (accountIdentifier)");
			ps.execute();
			System.out.println("Order1 table created");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	public void createTableAccount()
	{
		try{
			PreparedStatement ps = con.prepareStatement("Create table Account(accountIdentifier varchar(100) NOT NULL DEFAULT '',PRIMARY KEY (accountIdentifier)");
			ps.execute();
			System.out.println("Account table created");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}

}
