package com.test.demo1;

import java.io.Serializable;

public class Account implements Serializable
{
	private static final long serialVersionUID = -5165459684337610681L;
	
	private String accountName;
	private Double money;
	private String password;
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
