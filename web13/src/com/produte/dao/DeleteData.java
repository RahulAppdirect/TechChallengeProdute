package com.produte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.produte.Domain.TableData;

public class DeleteData {
	Connection con = new ConnectionFactoryImpl().getConnection();
	public int deleteInfo(TableData tb)
	{
		boolean deleteAccountConfirm = false;
		boolean deleteCreatorConfirm = false;
		boolean deleteOrderConfirm = false;
		boolean deleteCompanyConfirm = false;
		try{
		PreparedStatement psAccount = con.prepareStatement("Delete from Account where accountIdentifier = ?");
		psAccount.setString(1, tb.getAccount().getAccountIdentifier());
		deleteAccountConfirm = psAccount.execute();
		
		PreparedStatement psCreator = con.prepareStatement("Delete from Creator where accountIdentifier = ?");
		psCreator.setString(1, tb.getAccount().getAccountIdentifier());
		deleteCreatorConfirm = psCreator.execute();
		
		PreparedStatement psOrder = con.prepareStatement("Delete from Order1 where accountIdentifier = ?");
		psOrder.setString(1, tb.getAccount().getAccountIdentifier());
		deleteOrderConfirm = psOrder.execute();
		
		PreparedStatement psCompany = con.prepareStatement("Delete from Company where accountIdentifier = ?");
		psCompany.setString(1, tb.getAccount().getAccountIdentifier());
		deleteCompanyConfirm = psCompany.execute();
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(deleteAccountConfirm==true && deleteCreatorConfirm==true && deleteOrderConfirm==true && deleteCompanyConfirm==true)
		{
		 return 1;
		}
		else
		{
			return 0;
		}
	}

}
