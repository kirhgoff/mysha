package org.kirhgoff.mysha.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable{
	private static final long serialVersionUID = 9140007316905605587L;

    private int id;
	private String firstName;
	private String surName;
	
	public Customer() {}
	
	public void setId(int id) {
		this.id = id;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	public int getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="FIRSTNAME", nullable=false)
	public String getFirstName() {
		return firstName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	@Column(name="SURNAME", nullable=false)
	public String getSurName() {
		return surName;
	}
}
