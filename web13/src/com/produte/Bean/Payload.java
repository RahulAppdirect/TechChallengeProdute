package com.produte.Bean;

public class Payload {
	private User user;
	private Company company;
	private Account account;
	private AddOnInstance addonInstance;
	private AddOnBinding addonBinding;
	private Order order;
	private Notice notice;
	private Configuration configuration;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public AddOnInstance getAddonInstance() {
		return addonInstance;
	}
	public void setAddonInstance(AddOnInstance addonInstance) {
		this.addonInstance = addonInstance;
	}
	public AddOnBinding getAddonBinding() {
		return addonBinding;
	}
	public void setAddonBinding(AddOnBinding addonBinding) {
		this.addonBinding = addonBinding;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	

}
