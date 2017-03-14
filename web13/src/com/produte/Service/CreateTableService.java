package com.produte.Service;

import com.produte.dao.CreateTable;

public class CreateTableService {
	
	public void createTables()
	{
		new CreateTable().createTableCreator();
		new CreateTable().createTableCompany();
		new CreateTable().createTableOrder();
		new CreateTable().createTableAccount();
	}

}
