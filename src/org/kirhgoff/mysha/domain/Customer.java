package org.kirhgoff.mysha.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersionUID = 9140007316905605587L;

	private String firstName;
	private String surName;
	
	public Customer() {}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getSurName() {
		return surName;
	}
}
