package com.produte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.produte.Domain.TableData;


public class CheckAccountIdDao {
	Connection con = new ConnectionFactoryImpl().getConnection();
	public int checkAccountIdDao(TableData tb)
	{
		if(tb.getAccount()!=null){
		int count = 0;
		try{
		PreparedStatement ps = con.prepareStatement("Select accountIdentifier from Account where accountIdentifier = ?");
		ps.setString(1, tb.getAccount().getAccountIdentifier());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
		  count++;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(count!=0){
		return 1;
		}
		
		else{
		return 0;
		}
		}
		else{
			return 0;
		}
		
	}

}
