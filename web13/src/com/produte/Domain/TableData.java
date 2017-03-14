package com.produte.Domain;

public class TableData {

	private CompanyDomain company;
	private OrderDomain order;
	private CreatorDomain creator;
	private AccountDomain account;
	public CompanyDomain getCompany() {
		return company;
	}
	public void setCompany(CompanyDomain company) {
		this.company = company;
	}
	public OrderDomain getOrder() {
		return order;
	}
	public void setOrder(OrderDomain order) {
		this.order = order;
	}
	public CreatorDomain getCreator() {
		return creator;
	}
	public void setCreator(CreatorDomain creator) {
		this.creator = creator;
	}
	public AccountDomain getAccount() {
		return account;
	}
	public void setAccount(AccountDomain account) {
		this.account = account;
	}
}
