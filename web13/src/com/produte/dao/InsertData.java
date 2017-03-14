package com.produte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.produte.Domain.TableData;

public class InsertData {
	Connection con = new ConnectionFactoryImpl().getConnection();
	public void insertDataDao(TableData tb)
	{
		try{
		PreparedStatement psCreator = con.prepareStatement("Insert into Creator(accountIdentifier,uuid,openId,email,firstName,lastName,language,locale,city,country,phone,state,street1,zip) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		psCreator.setString(1, tb.getAccount().getAccountIdentifier());
		psCreator.setString(2, tb.getCreator().getUuid());
		psCreator.setString(3, tb.getCreator().getOpenId());
		psCreator.setString(4, tb.getCreator().getEmail());
		psCreator.setString(5, tb.getCreator().getFirstName());
		psCreator.setString(6, tb.getCreator().getLastName());
		psCreator.setString(7, tb.getCreator().getLanguage());
		psCreator.setString(8, tb.getCreator().getLocale());
		psCreator.setString(9, tb.getCreator().getCity());
		psCreator.setString(10, tb.getCreator().getCountry());
		psCreator.setString(11, tb.getCreator().getPhone());
		psCreator.setString(12, tb.getCreator().getState());
		psCreator.setString(13, tb.getCreator().getStreet1());
		psCreator.setString(14, tb.getCreator().getZip());
		
		psCreator.executeUpdate();
		
		PreparedStatement psCompany = con.prepareStatement("Insert into Company(accountIdentifier,uuid,name,email,phoneNumber,website,country) values(?,?,?,?,?,?,?)");
		psCompany.setString(1, tb.getAccount().getAccountIdentifier());
		psCompany.setString(2, tb.getCompany().getUuid());
		psCompany.setString(3, tb.getCompany().getName());
		psCompany.setString(4, tb.getCompany().getEmail());
		psCompany.setString(5, tb.getCompany().getPhoneNumber());
		psCompany.setString(6, tb.getCompany().getWebsite());
		psCompany.setString(7, tb.getCompany().getCountry());
		
		psCompany.executeUpdate();
		
		PreparedStatement psOrder = con.prepareStatement("Insert into Order1(accountIdentifier,editionCode,pricingDuration) values (?,?,?)");
		psOrder.setString(1, tb.getAccount().getAccountIdentifier());
		psOrder.setString(2, tb.getOrder().getEditionCode());
		psOrder.setString(3, tb.getOrder().getPricingDuration());
		
		psOrder.executeUpdate();
		
		PreparedStatement psAccount = con.prepareStatement("Insert into Account(accountIdentifier) values(?)");
		psAccount.setString(1, tb.getAccount().getAccountIdentifier());
		
		psAccount.executeUpdate();
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
