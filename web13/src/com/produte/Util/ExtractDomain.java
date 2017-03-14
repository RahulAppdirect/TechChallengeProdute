package com.produte.Util;

import java.util.Random;

import com.produte.Bean.Parent;
import com.produte.Domain.AccountDomain;
import com.produte.Domain.CompanyDomain;
import com.produte.Domain.CreatorDomain;
import com.produte.Domain.OrderDomain;
import com.produte.Domain.TableData;


public class ExtractDomain {
	
	public TableData extractDomain(Parent p)
	{
		//UserData ud = new UserData();
		
//		ud.setApplicationUuid(p.getApplicationUuid());
//		ud.setBaseUrl(p.getMarketplace().getBaseUrl());
//		ud.setCompanyCountry(p.getPayload().getCompany().getCountry());
//		ud.setCompanyExternalId(p.getPayload().getCompany().getExternalId());
//		ud.setCompanyName(p.getPayload().getCompany().getName());
//		ud.setCompanyPhNumber(p.getPayload().getCompany().getPhoneNumber());
//		ud.setCompanyWebsite(p.getPayload().getCompany().getWebsite());
//		ud.setEditionCode(p.getPayload().getOrder().getEditionCode());
//		ud.setEmail(p.getCreator().getEmail());
//		ud.setFirstName(p.getCreator().getFirstName());
//		ud.setFlag(p.getFlag());
//		ud.setLanguage(p.getCreator().getLanguage());
//		ud.setLastName(p.getCreator().getLastName());
//		ud.setLocale(p.getCreator().getLocale());
//		ud.setPartner(p.getMarketplace().getPartner());
//		//ud.setPricingDuration(p.getPayload().getOrder().getPricingDuration());
//		ud.setType(p.getType());
//		
//		if(p.getPayload().getAccount()!=null)
//		{
//			ud.setAccountIdentifier(p.getPayload().getAccount().getAccountIdentifier());
//		}
//		else
//		{
//			Random rand = new Random();
//
//			int  n = rand.nextInt(10000) + 100;
//			String acctId = "A"+n;
//			ud.setAccountIdentifier(acctId);
//		}
//		
//		if(p.getCreator().getAddress()!=null)
//		{
//			ud.setCity(p.getCreator().getAddress().getCity());
//			ud.setCountry(p.getCreator().getAddress().getCountry());
//			ud.setPhone(p.getCreator().getAddress().getPhone());
//			ud.setState(p.getCreator().getAddress().getState());
//			ud.setStreet1(p.getCreator().getAddress().getStreet1());
//			ud.setZip(p.getCreator().getAddress().getZip());
//		}
//		
//		if(p.getPayload().getOrder()!=null)
//		{
//			
//		}
//		
//		return ud;
		
		CreatorDomain creator = new CreatorDomain();
		CompanyDomain company = new CompanyDomain();
		OrderDomain order = new OrderDomain();
		AccountDomain account = new AccountDomain();
		
		creator.setUuid((p.getCreator().getUuid()));
		creator.setOpenId(p.getCreator().getOpenId());
		creator.setEmail(p.getCreator().getEmail());
		creator.setFirstName(p.getCreator().getFirstName());
		creator.setLastName(p.getCreator().getLastName());
		creator.setLanguage(p.getCreator().getLanguage());
		creator.setLocale(p.getCreator().getLocale());
		
		if(p.getCreator().getAddress()!=null)
		{
			creator.setCity(p.getCreator().getAddress().getCity());
			creator.setCountry(p.getCreator().getAddress().getCountry());
			creator.setPhone(p.getCreator().getAddress().getPhone());
			creator.setState(p.getCreator().getAddress().getState());
			creator.setStreet1(p.getCreator().getAddress().getStreet1());
			creator.setZip(p.getCreator().getAddress().getZip());
		}
		
		if(p.getPayload().getCompany()!=null)
		{
		company.setUuid(p.getPayload().getCompany().getUuid());
		company.setName(p.getPayload().getCompany().getName());
		company.setEmail(p.getPayload().getCompany().getEmail());
		company.setPhoneNumber(p.getPayload().getCompany().getPhoneNumber());
		company.setWebsite(p.getPayload().getCompany().getWebsite());
		company.setCountry(p.getPayload().getCompany().getCountry());
		}
		
		if(p.getPayload().getOrder()!=null){
		order.setEditionCode(p.getPayload().getOrder().getEditionCode());
		order.setPricingDuration(p.getPayload().getOrder().getPricingDuration());
		}
		
		if(p.getPayload().getAccount()!=null)
		{
			account.setAccountIdentifier(p.getPayload().getAccount().getAccountIdentifier());
		}
		else
		{
			Random rand = new Random();
			int  n = rand.nextInt(10000) + 100;
			String acctId = "A"+n;
			account.setAccountIdentifier(acctId);
		}
		
		TableData tb = new TableData();
		tb.setAccount(account);
		tb.setCompany(company);
		tb.setCreator(creator);
		tb.setOrder(order);
		
		return tb;
		
	}

}
